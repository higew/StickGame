package com.imie.stickgame.models;

import java.util.ArrayList;

public interface Effect {
    EffectPhase getEffectPhase();
    void doEffect(ArrayList<Card> card, Card currCard);
}
