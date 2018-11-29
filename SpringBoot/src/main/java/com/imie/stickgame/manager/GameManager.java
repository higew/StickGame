package com.imie.stickgame.manager;

import com.imie.stickgame.models.Player;

import java.util.Random;

public class GameManager {

    private PlayerManager playerManager;
    private Player player1;
    private Player player2;
    private boolean firstPlayer;

    private static final int MAXINK = 10;
    private static final int MAXHANDSIZE = 7;

    public boolean isFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(boolean firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public void setPlayerManager(PlayerManager playerManager) {
        this.playerManager = playerManager;
    }

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

    GameManager() {
        this.playerManager = new PlayerManager();
        this.player1 = new Player();
        this.player2 = new Player();
    }

    public void decideFirst() {
        Random rand = new Random();

        this.firstPlayer = rand.nextBoolean();
        if (this.firstPlayer == true) {
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
        while (this.player1.getHp() > 0 && this.player2.getHp() > 0) {
            if (this.firstPlayer == true) {
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
}

// Constructeurs etc pour avoir des valeurs dans les classes