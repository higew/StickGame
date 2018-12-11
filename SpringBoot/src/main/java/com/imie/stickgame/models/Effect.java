package com.imie.stickgame.models;

import com.imie.stickgame.models.enumPhase.EffectPhase;

public interface Effect {
    EffectPhase getEffectPhase();
    void doEffect(Player player, Player ennemy, Card currCard);
}
