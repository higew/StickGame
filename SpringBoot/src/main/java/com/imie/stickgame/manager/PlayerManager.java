package com.imie.stickgame.manager;

import com.imie.stickgame.models.Battlefield;
import com.imie.stickgame.models.Player;

import java.util.Random;

public class PlayerManager {

    public void draw(Player player, int nb) {
        int temp;
        Random rand = new Random();

        for (int i = 0; i < nb; i++) {
            temp = rand.nextInt(player.getDeck().getCards().size()) + 1;
            player.getHand().add(player.getDeck().getCards().get(temp));
            player.getDeck().getCards().remove(temp);
        }
    }

//    public void putOnField(Player player, int nb, int spot) {
//        if (player.getInkTurn() - player.getHand().get(nb).getInkCost() >= 0 &&
//                player.getBattlefield().getMonsterZone()[spot] == null) {
//            player.getHand().get(nb).setAtkTemp(player.getHand().get(nb).getAtk());
//            player.getHand().get(nb).setAtk(0);
//            player.getBattlefield().getMonsterZone()[spot] = player.getHand().get(nb); // Does it work tough ?
//            player.setInkTurn(player.getInkTurn() - player.getHand().get(nb).getInkCost());
//            player.getHand().remove(nb);
//        }
//    }
//
//    public void attack(Player player, Player enemy) {
//        int tempLife;
//        int i = 0;
//
//        while (i < 5 && enemy.getHp() > 0) {
//            if (player.getBattlefield().getMonsterZone()[i] != null
//                    && player.getBattlefield().getMonsterZone()[i].getAtk() != 0) {
//                // Si ma zone de monstre n'est pas nulle ou posée ce tour, je vérifie celle de l'ennemi
//                if (enemy.getBattlefield().getMonsterZone()[i] != null) {
//                    // Non nulle, j'attaque la carte ennemie
//                    tempLife = enemy.getBattlefield().getMonsterZone()[i].getHp()
//                            - player.getBattlefield().getMonsterZone()[i].getAtk();
//                    if (tempLife < 0) {
//                        tempLife = 0;
//                    }
//                    enemy.getBattlefield().getMonsterZone()[i].setHp(tempLife);
//                    // Si les HP de la carte tombent à zéro on la met dans le discard deck et on set à null la zone.
//                    if (enemy.getBattlefield().getMonsterZone()[i].getHp() == 0) {
//                        enemy.getBattlefield().getDiscardDeck().add(enemy.getBattlefield().getMonsterZone()[i]);
//                        enemy.getBattlefield().getMonsterZone()[i] = null;
//                    }
//                } else {
//                    // Attaquer le héros ennemi
//                    tempLife = enemy.getHp() - player.getBattlefield().getMonsterZone()[i].getAtk();
//                    if (tempLife < 0) {
//                        tempLife = 0;
//                    }
//                    enemy.setHp(tempLife);
//                    // Si les HPs du héros tombent à zéro la partie est finie
//                }
//            }
//            i++;
//        }
//        // Si les HPs de l'ennemi sont supérieur à zéro, la partie continue et nos cartes posées ce tour s'activent
//        if (enemy.getHp() > 0) {
//            changeAtkFirstTurn(player.getBattlefield());
//        }
//    }
//
//    private void changeAtkFirstTurn(Battlefield battlefield) {
//        for (int i = 0; i < 5; i++) {
//            if (battlefield.getMonsterZone()[i].getAtk() == 0) {
//                battlefield.getMonsterZone()[i].setAtk(battlefield.getMonsterZone()[i].getAtkTemp());
//                battlefield.getMonsterZone()[i].setAtkTemp(0);
//            }
//        }
//    }
//
//    public void addInk(Player player, int nb) {
//        player.setInk(player.getInk() + nb);
//        player.setInkTurn(player.getInk());
//    }
//
//    public void discard(Player player, int spot) {
//        player.getBattlefield().getDiscardDeck().add(player.getHand().get(spot));
//        player.getHand().remove(spot);
//    }
}
