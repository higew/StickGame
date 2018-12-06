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
        this.player1 = new Player("cc", new Deck(), "TAMER");
        this.player2 = new Player("CKOOL", new Deck(), "la vi");
        this.game = "Battle between " + this.player1.getName() + " and " + this.player2.getName() +
                " uuidkey" + new Random().nextInt(Integer.MAX_VALUE);
    }

    public FirebaseGamePlayer(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.game = "Battle between " + this.player1.getName() + " and " + this.player2.getName() +
                " uuidkey" + new Random().nextInt(Integer.MAX_VALUE);
    }
}
