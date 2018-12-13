package com.imie.stickgame.manager;

import com.imie.stickgame.models.BaseEffect;
import com.imie.stickgame.models.Card;
import com.imie.stickgame.models.Effect;
import com.imie.stickgame.models.Player;
import com.imie.stickgame.models.enumPhase.EffectPhase;

/**
 * Classe permettant de construire les effets associés aux cartes en possédant
 */
public class EffectBuilder {

    public void setupEffect(BaseEffect baseEffect, Card card) {
        switch (baseEffect.getEffectIdentifier()) {
            case 1:
                card.setEffect(new Effect() {
                    @Override
                    public EffectPhase getEffectPhase() {
                        return EffectPhase.POSE;
                    }

                    @Override
                    public void doEffect(Player player, Player ennemy, Card currCard) {
                        currCard.setAtk(currCard.getAtk() + 1);
                        currCard.setHp(currCard.getHp() + 1);
                    }
                });

            case 2:
                card.setEffect(new Effect() {
                    @Override
                    public EffectPhase getEffectPhase() {
                        return EffectPhase.DESTRUCTION;
                    }

                    @Override
                    public void doEffect(Player player, Player ennemy, Card currCard) {

                    }
                });
        }
    }

}
