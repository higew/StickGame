package com.imie.stickgame.firebase.models;

import com.imie.stickgame.models.Deck;
import com.imie.stickgame.models.Player;

import java.util.Map;
import java.util.Random;

public class FirebaseGamePlayer {

   private Map<String,Player> players;
   private Boolean waiting;

    public Map<String, Player> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Player> players) {
        this.players = players;
    }

    public Boolean getWaiting() {
        return waiting;
    }

    public void setWaiting(Boolean waiting) {
        this.waiting = waiting;
    }

    public FirebaseGamePlayer() {
        this.waiting = true;
    }
}
