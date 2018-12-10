package com.imie.stickgame.firebase;

import com.imie.stickgame.firebase.models.FirebaseWaitingRoom;

import java.io.IOException;
import java.util.concurrent.Executor;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class FirebaseWaitingRoomObserver {

    FirebaseWaitingRoom firebaseWaitingRoom;

    private FirebaseWaitingRoomObserver() throws IOException {
        this.firebaseWaitingRoom = new FirebaseWaitingRoom();
        firebaseWaitingRoomObserver(this.firebaseWaitingRoom);
    }

    private static FirebaseWaitingRoomObserver INSTANCE = null;

    public static synchronized FirebaseWaitingRoomObserver getInstance() throws IOException {
        if (INSTANCE == null) {
            INSTANCE = new FirebaseWaitingRoomObserver();
        }
        return INSTANCE;
    }

    private void firebaseWaitingRoomObserver(FirebaseWaitingRoom firebaseWaitingRoom) throws IOException {
        FirebaseOpenHelper.getInstance().getDatabase().getReference("/waitingroom").setValueAsync
                (firebaseWaitingRoom).addListener(new Runnable() {

            public void run() {
                System.out.println("run");
            }
        }, new Executor() {

            public void execute(Runnable command) {
                System.out.println("execute");
            }
        });;

        FirebaseOpenHelper.getInstance().getDatabase().getReference("/waitingroom").addChildEventListener(new ChildEventListener() {

            public void onChildRemoved(DataSnapshot snapshot) {
                System.out.println("removed "+snapshot.getKey());
            }

            public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
                System.out.println("moved "+snapshot.getKey());
            }

            public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
                System.out.println("changed " + snapshot.getKey());
                System.out.println("Il y a " + FirebaseWaitingRoomObserver.this.firebaseWaitingRoom.getSizeWaitingRoom() + " " +
                        "personnes actuellement en attente");
            }

            public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                System.out.println("Added " + snapshot.getKey());
                if (snapshot.getKey().equals("usernames")) {
                    FirebaseWaitingRoomObserver.this.firebaseWaitingRoom.getUsers().add(snapshot.getValue().toString());
                }
                if (snapshot.getKey().equals("sizeWaitingRoom")) {
                    FirebaseWaitingRoomObserver.this.firebaseWaitingRoom.setSizeWaitingRoom(Integer.valueOf(snapshot
                            .getValue().toString()));
                }
                System.out.println("Il y a " + FirebaseWaitingRoomObserver.this.firebaseWaitingRoom.getSizeWaitingRoom() + " " +
                        "personnes actuellement en attente");
            }

            public void onCancelled(DatabaseError error) {
                System.out.println("Error");
            }
        });
    }

    public FirebaseWaitingRoom getFirebaseWaitingRoom() {
        return this.firebaseWaitingRoom;
    }
}
