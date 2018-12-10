package com.imie.stickgame.firebase.models;

import java.util.ArrayList;
import java.util.List;

public class FirebaseWaitingRoom {
    private List<String> users;
    private Integer sizeWaitingRoom;

    public List<String> getUsers() {
        return users;
    }

    public Integer getSizeWaitingRoom() {
        return sizeWaitingRoom;
    }

    public void setUsers(List<String> users) {
        this.users = users;
        this.sizeWaitingRoom = this.users.size();
    }

    public void setSizeWaitingRoom(Integer sizeWaitingRoom) {
        this.sizeWaitingRoom = sizeWaitingRoom;
    }

    public FirebaseWaitingRoom() {
        this.users = new ArrayList<>();
        this.sizeWaitingRoom = new Integer(0);
    }

    public void addMe(String username) {
        this.users.add(username);
        this.sizeWaitingRoom = this.users.size();
    }
}
