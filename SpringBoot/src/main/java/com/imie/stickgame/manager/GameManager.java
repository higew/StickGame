package com.imie.stickgame.manager;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.imie.stickgame.firebase.FirebaseOpenHelper;
import com.imie.stickgame.firebase.models.FirebaseGamePlayer;
import com.imie.stickgame.firebase.models.WaitingRoom;
import com.imie.stickgame.models.Deck;
import com.imie.stickgame.models.Player;

import java.io.IOException;
import java.util.Random;

public class GameManager {

    private PlayerManager playerManager;
    private EffectBuilder effectBuilder;
    private FirebaseGamePlayer firebaseGamePlayer;
    private Player player1;
    private Player player2;
    private boolean firstPlayer;

    private static final int MAXINK = 10;
    private static final int MAXHANDSIZE = 7;
    private static final int NBSTARTCARD = 4;

    public FirebaseGamePlayer getFirebaseGamePlayer() {
        return firebaseGamePlayer;
    }

    public GameManager(String player1, String player2, Deck deck1, Deck deck2, String picture1, String picture2) {
        this.playerManager = new PlayerManager();
        this.effectBuilder = new EffectBuilder();
        this.firebaseGamePlayer = new FirebaseGamePlayer();
       // this.firebaseGamePlayer = new FirebaseGamePlayer(new Player (player1, deck1, picture1), new Player (player2,
         //       deck2, picture2));

        try {
            FirebaseOpenHelper.getInstance().getDatabase().getReference("games/").
                    child(this.firebaseGamePlayer.getGame()).setValueAsync(firebaseGamePlayer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.player1 = this.firebaseGamePlayer.getPlayer1();
        this.player2 = this.firebaseGamePlayer.getPlayer2();
    }

    public GameManager() {
        PlayerManager playerManager = new PlayerManager();
        EffectBuilder effectBuilder = new EffectBuilder();
        FirebaseGamePlayer firebaseGamePlayer = new FirebaseGamePlayer();
    }

    public void decideFirst() {
        Random rand = new Random();

        this.firstPlayer = rand.nextBoolean();
        if (this.firstPlayer) {
            System.out.println("Player 1 will start the game !");
            this.playerManager.addInk(this.player2, 1);
        } else {
            System.out.println("Player 2 will start the game !");
            this.playerManager.addInk(this.player1, 1);
        }
    }

    public void playerTurn(Player player) {
        if (player.getInk() < MAXINK) {
            this.playerManager.addInk(player, 1);
        } else {
            player.setInkTurn(MAXINK);
        }
        if (player.getHand().size() < MAXHANDSIZE) {
            this.playerManager.draw(player, 1);
        }
        // Pose de cartes ici avec putOnField(player, @RequestParams cardPos, @RequestParams spot);
        // Bouton pour nexter et passer à la phase combat si on ne souhaite ou ne peux pas poser de cartes
    }

    public void game() {
        decideFirst();
        this.playerManager.draw(this.player1, NBSTARTCARD);
        this.playerManager.draw(this.player2, NBSTARTCARD);
        while (this.player1.getHp() > 0 && this.player2.getHp() > 0) {
            if (this.firstPlayer) {
                this.firstPlayer = false;
                playerTurn(this.player1);
                this.playerManager.attack(this.player1, this.player2);
            }
            playerTurn(this.player2);
            this.playerManager.attack(this.player2, this.player1);
            if (this.player1.getHp() > 0) {
                playerTurn(this.player1);
                this.playerManager.attack(this.player1, this.player2);
            }
        }
    }

    public WaitingRoom createGame(String user) throws IOException {
        WaitingRoom waitingRoom = new WaitingRoom();
        this.firebaseGamePlayer.createPlayer1(user);
        this.firebaseGamePlayer.createRoom();
        waitingRoom.getWaitingRoom().putIfAbsent(user, this.firebaseGamePlayer.getGame());
        FirebaseOpenHelper.getInstance().getDatabase().getReference("games/").child(this.firebaseGamePlayer.getGame()
        ).setValueAsync(this.firebaseGamePlayer);
        FirebaseOpenHelper.getInstance().getDatabase().getReference("games/").child(this.firebaseGamePlayer.getGame()
        ).child("player2").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                System.out.println("Brace yourself for da next nuclear war");
                game();
            }

            @Override
            public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
                System.out.println("Brace yourself for da next nuclear war");
                game();
            }

            @Override
            public void onChildRemoved(DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot snapshot, String previousChildName) {

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        return waitingRoom;
    }

    public void addToGame(String username, WaitingRoom waitingRoom) throws IOException {
        this.firebaseGamePlayer.createPlayer2(username);
        FirebaseOpenHelper.getInstance().getDatabase().getReference(waitingRoom.getWaitingRoom().get(0))
                .setValueAsync(firebaseGamePlayer.getPlayer2());
    }
}
