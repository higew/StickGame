package com.imie.stickgame.services;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.imie.stickgame.firebase.FirebaseOpenHelper;
import com.imie.stickgame.firebase.models.FirebaseGamePlayer;
import com.imie.stickgame.models.Card;
import com.imie.stickgame.models.Player;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Classe gérant l'affichage et la logique du jeu
 */
@Service
public class GameService {

    private static final String GAME_PACKAGE = "com.imie.stickgame.firebase.models.";
    private static final String USER_PACKAGE = "com.imie.stickgame.models.";

    private Map<Player, Map<String, FirebaseGamePlayer>> gameMap;
    private String[] result = new String[2];

    /**
     * Fonction permettant l'ajout d'un player a une partie contenant déjà un joueur
     *
     * @param player
     * @return
     * @throws IOException
     */
    public String[] addUser(Player player) throws IOException {


        if (this.gameMap.size() == 0) {

            FirebaseGamePlayer game = this.createGame();
            Map<String, FirebaseGamePlayer> item = new HashMap<String, FirebaseGamePlayer>();
            item.put(game.toString().replace(GAME_PACKAGE, ""), game);
            result[0] = item.entrySet().iterator().next().getKey();
            this.gameMap.put(player, item);
            result[1] = this.gameMap.entrySet().iterator().next().getKey().toString().replace(USER_PACKAGE, "");

        } else if (this.gameMap.size() > 0 && this.gameMap.size() < 2) {

            Map.Entry<Player, Map<String, FirebaseGamePlayer>> entry = gameMap.entrySet().iterator().next();
            result[0] = entry.getValue().entrySet().iterator().next().getKey();
            for (Map.Entry<Player, Map<String, FirebaseGamePlayer>> iterable_element : gameMap.entrySet()) {
                if (player.equals(iterable_element.getKey())) {
                    result[1] = this.gameMap.get(player).toString().replace(USER_PACKAGE, "");
                    return result;
                }
            }
            this.gameMap.put(player, entry.getValue());
            Map.Entry<Player, Map<String, FirebaseGamePlayer>> data;

            this.gameMap.forEach((key, value) -> {
                result[1] = key.toString().replace(USER_PACKAGE, "");
            });

            if (this.gameMap.size() == 2) {

                this.lancerGame(this.gameMap);
                this.gameMap.clear();
            }
        }

        return result;
    }

    /**
     * Fonction permettant la création d'une partie s'il n'y en a pas déjà une en attente
     *
     * @return
     * @throws IOException
     */
    public FirebaseGamePlayer createGame() throws IOException {
        FirebaseGamePlayer game = new FirebaseGamePlayer();
        String gameName = game.toString().replace(GAME_PACKAGE, "");

        FirebaseOpenHelper.getInstance().getDatabase().getReference(gameName).setValueAsync(game);
        ChildEventListener listener = new GameEventListener();
        FirebaseOpenHelper.getInstance().getDatabase().getReference(gameName).addChildEventListener(listener);

        return game;
    }

    /**
     * Constructeur de la classe
     */
    public GameService() {
        this.gameMap = new HashMap<Player, Map<String, FirebaseGamePlayer>>();
    }

    /**
     * Fonction permettant le lancement d'une partie de jeu lorsqu'elle contient deux joueurs
     *
     * @param gameMap
     * @throws IOException
     */
    public void lancerGame(Map<Player, Map<String, FirebaseGamePlayer>> gameMap) throws IOException {
        FirebaseGamePlayer game = this.gameMap.entrySet().iterator().next().getValue().entrySet().iterator().next().getValue();
        Map<String, Player> players = new HashMap<String, Player>();

        for (Map.Entry<Player, Map<String, FirebaseGamePlayer>> iterable_element : this.gameMap.entrySet()) {
            players.put(iterable_element.getKey().toString().replace(USER_PACKAGE, ""), iterable_element.getKey());
        }

        game.setPlayers(players);

        Map.Entry<Player, Map<String, FirebaseGamePlayer>> entry = gameMap.entrySet().iterator().next();
        String gameName = entry.getValue().entrySet().iterator().next().getKey();
        FirebaseOpenHelper.getInstance().getDatabase().getReference(gameName).setValueAsync(game);
    }

    /**
     * Fonction permettant de tirer les 5 cartes de la main au début de la partie
     *
     * @param snapshot
     * @return
     */
    public DataSnapshot drawFirstHand(DataSnapshot snapshot) {
        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

            dataSnapshot.getRef().addChildEventListener(new PlayerEventListener());
            Player p = dataSnapshot.getValue(Player.class);
            ArrayList<Card> draw = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                int j = new Random().nextInt(p.getDeck().getCards().size());
                draw.add(p.getDeck().getCards().get(j));
                p.getDeck().getCards().remove(j);
            }

            p.setHand(draw);
            p.setSizeHand(p.getHand().size());
            p.getDeck().setSize(p.getDeck().getCards().size());
            dataSnapshot.getRef().setValueAsync(p);
        }
        return snapshot;
    }

    /**
     * Class Listener permettant d'écouter les modifications sur Firebase de la game afin de faire diverses actions
     */
    final class GameEventListener implements ChildEventListener {

        @Override
        public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
            System.out.println("Added " + snapshot.getKey());

            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                dataSnapshot.getRef().addChildEventListener(new PlayerEventListener());
            }
            if (snapshot.getKey().equals("players")) {
                System.out.println("J'ai vu ton equals");
                snapshot = drawFirstHand(snapshot);
                Boolean isFirst = new Random().nextBoolean();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    Player p = dataSnapshot.getValue(Player.class);
                    p.setWaiting(isFirst);
                    dataSnapshot.getRef().setValueAsync(p);
                    isFirst = !isFirst;
                }
            }
        }

        @Override
        public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
            System.out.println("Game changed " + snapshot.getKey());
        }

        @Override
        public void onChildRemoved(DataSnapshot snapshot) {
            System.out.println("Removed " + snapshot.getKey());
        }

        @Override
        public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
            System.out.println("Moved " + snapshot.getKey());
        }

        @Override
        public void onCancelled(DatabaseError error) {
            System.out.println("Cancelled " + error);
        }
    }

    /**
     * Class listener permettant d'écouter les modifications sur Firebase sur un joueur afin d'effectuer diverses
     * actions
     */
    final class PlayerEventListener implements ChildEventListener {

        @Override
        public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
            System.out.println("Player added " + snapshot.getKey());
        }

        @Override
        public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
            System.out.println("Changed " + snapshot.getKey() + " in player listner");
            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                Player p = dataSnapshot.getValue(Player.class);
                if (p.getWaiting() == false) {
                    p.setInk(p.getInk() + 1);
                    p.setInkTurn(p.getInk());

                    int j = new Random().nextInt(p.getDeck().getCards().size());
                    Card draw = p.getDeck().getCards().get(j);
                    p.getDeck().getCards().remove(j);
                    p.getHand().add(draw);

                    dataSnapshot.getRef().setValueAsync(p);
                }
            }
        }

        @Override
        public void onChildRemoved(DataSnapshot snapshot) {
            System.out.println("Removed " + snapshot.getKey());
        }

        @Override
        public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
            System.out.println("Moved " + snapshot.getKey());
        }

        @Override
        public void onCancelled(DatabaseError error) {
            System.out.println("Cancelled " + error);
        }
    }
}
