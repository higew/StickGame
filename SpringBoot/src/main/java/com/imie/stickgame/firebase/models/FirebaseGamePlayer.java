package com.imie.stickgame.firebase.models;

import com.imie.stickgame.models.Deck;
import com.imie.stickgame.models.Player;
import java.util.Random;

public class FirebaseGamePlayer {

    private Player player1;
    private Player player2;
    private String game;

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public String getGame() {
        return game;
    }

    public FirebaseGamePlayer() {
        /*this.player1 = new Player("cc", new Deck(), "TAMER");
        this.player2 = new Player("CKOOL", new Deck(), "la vi");
        this.player1.getDeck().setName("Elf");
        this.game = "Battle between " + this.player1.getName() + " and " + this.player2.getName() +
                " uuidkey282003293";*/
        //+ new Random().nextInt(Integer.MAX_VALUE);
    }

    public FirebaseGamePlayer(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.game = "Battle between " + this.player1.getName() + " and " + this.player2.getName() +
                " uuidkey" + new Random().nextInt(Integer.MAX_VALUE);
    }

    /*private FirebaseGamePlayer() throws IOException {
        this.player1 = new Player();
        firebaseNotificationsObserver(this.notification);
    }*/

    public void createPlayer1(String username) {
        this.player1 = new Player(username, new Deck(), "Default Pic");
        this.player1.getDeck().setName("Elf");
    }

    public void createRoom() {
        this.game = "Battle uuidkey" + new Random().nextInt(Integer.MAX_VALUE);
    }

    public void createPlayer2(String username) {
        this.player2 = new Player(username, new Deck(), "Default pic");
        this.player2.getDeck().setName("Elf");
    }
}
