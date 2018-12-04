package com.imie.stickgame.models;

import java.util.ArrayList;

public interface Effect {
    EffectPhase getEffectPhase();
    void doEffect(Player player, Player ennemy, Card currCard);
}
