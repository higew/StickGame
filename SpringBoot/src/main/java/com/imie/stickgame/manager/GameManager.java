package com.imie.stickgame.manager;

import java.util.Random;

public class GameManager {

    PlayerManager playerManager;

    GameManager() {
        playerManager = new PlayerManager();
    }

    public void decideFirst() {
        Random rand = new Random();
        boolean test = rand.nextBoolean();

        if (test == true) {
           // Ajoute le bonus au joueur 1
            System.out.println("Le joueur 1 joue en premier !");
        }
        else {
            // Ajoute le bonus au joueur 2
            System.out.println("Le joueur 2 joue en premier !");
        }
    }

    public void game() {

    }
}
