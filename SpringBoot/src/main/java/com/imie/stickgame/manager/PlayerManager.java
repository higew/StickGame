package com.imie.stickgame.manager;

import com.imie.stickgame.models.Player;
import java.util.Random;

public class PlayerManager {

    Player player1;
    Player player2;

    PlayerManager() {
        player1 = new Player();
        player2 = new Player();
    }

    public void draw(Player player, int nb) {
        int temp;
        Random rand = new Random();
        for (int i = 0; i < nb; i++) {
            temp = rand.nextInt(player.getDeck().getCards().size()) + 1;
            player.getHand().add(player.getDeck().getCards().get(temp));
            player.getDeck().getCards().remove(temp);
        }
    }

    public void putOnField(Player player, int nb, int spot) {
        player.getBattlefield().getMonsterZone()[spot] = player.getHand().get(nb); // Does it work tough ?
        player.getHand().remove(nb);
    }

    public void attack(Player player, Player ennemy) {
        int tempLife;

        for (int i = 0; i < 5; i++) {
            tempLife = 0;
            if (player.getBattlefield().getMonsterZone()[i] != null &&
                    player.getBattlefield().getMonsterZone()[i].getAtk() != 0) {
                // Si ma zone de monstre n'est pas nulle, je vérifie celle de l'ennemi
                if (ennemy.getBattlefield().getMonsterZone()[i] != null) {
                    // Non nulle, j'attaque la carte ennemie
                    tempLife = ennemy.getBattlefield().getMonsterZone()[i].getHp() -
                            player.getBattlefield().getMonsterZone()[i].getAtk();
                    if (tempLife < 0) {
                        tempLife = 0;
                    }
                    ennemy.getBattlefield().getMonsterZone()[i].setHp(tempLife);
                    // Si les HP de la carte tombent à zéro on la détruit.
                } else {
                    // Attaquer le héros ennemi
                    tempLife = ennemy.getHp() - player.getBattlefield().getMonsterZone()[i].getAtk();
                    if (tempLife < 0) {
                        tempLife = 0;
                    }
                    ennemy.setHp(tempLife);
                    // Si les HPs du héros tombent à zéro la partie est finie
                }
            }
        }
}

    public void addInk(Player player) {
        player.setInk(player.getInk() + 1);
    }
}
