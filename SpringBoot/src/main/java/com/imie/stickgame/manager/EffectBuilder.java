package com.imie.stickgame.manager;

// Agit comme un manager d'effets

import com.imie.stickgame.models.*;
import com.imie.stickgame.models.enumPhase.EffectPhase;

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
                        return EffectPhase.POSE;
                    }

                    @Override
                    public void doEffect(Player player, Player ennemy, Card currCard) {
                        PlayerManager pm = new PlayerManager();

                        pm.draw(player, 1);
                    }
                });
            case 3:
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
