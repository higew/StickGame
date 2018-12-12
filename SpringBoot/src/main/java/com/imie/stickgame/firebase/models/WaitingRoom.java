package com.imie.stickgame.firebase.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WaitingRoom {

    // Prend en premier String le nom du joueur et en second le numéro de la room de la game
    private Map<String, String> waitingRoom;

    public Map<String, String> getWaitingRoom() {
        return waitingRoom;
    }

    public void setWaitingRoom(Map<String, String> waitingRoom) {
        this.waitingRoom = waitingRoom;
    }

    public WaitingRoom() {
        this.waitingRoom = new HashMap<>();
    }
}
