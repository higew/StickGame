package com.imie.stickgame.services;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.imie.stickgame.firebase.FirebaseOpenHelper;
import com.imie.stickgame.firebase.models.FirebaseGamePlayer;
import com.imie.stickgame.models.Player;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class GameService {

    private static final String GAME_PACKAGE = "com.imie.stickgame.firebase.models.";
    private static final String USER_PACKAGE = "com.imie.stickgame.models.";

    Map<Player, Map<String,FirebaseGamePlayer>> gameMap;

    public String[] addUser(Player player) throws IOException {

        String[] result = new String[2];
        if(this.gameMap.size() == 0) {

            FirebaseGamePlayer game = this.createGame();
            Map<String, FirebaseGamePlayer> item = new HashMap<String, FirebaseGamePlayer>();
            item.put(game.toString().replace(GAME_PACKAGE, ""), game);
            result[0] = item.entrySet().iterator().next().getKey();
            this.gameMap.put(player, item);
            result[1] = this.gameMap.entrySet().iterator().next().toString().replace(USER_PACKAGE, "");

        } else if(this.gameMap.size() > 0 && this.gameMap.size() < 2) {

            Map.Entry<Player, Map<String, FirebaseGamePlayer>> entry = gameMap.entrySet().iterator().next();
            result[0] = entry.getValue().entrySet().iterator().next().getKey();
            for (Map.Entry<Player, Map<String, FirebaseGamePlayer>> iterable_element : gameMap.entrySet()) {
                if(player.equals(iterable_element.getKey())) {
                    result[1] = this.gameMap.get(player).toString().replace(USER_PACKAGE, "");
                    return result;
                }
            }
            this.gameMap.put(player, entry.getValue());
            Map.Entry<Player, Map<String, FirebaseGamePlayer>> data;

            this.gameMap.forEach((key, value) -> {
                result[1] = key.toString().replace(USER_PACKAGE, "");
            });

            if (this.gameMap.size() == 2) {

                this.lancerGame(this.gameMap);
                this.gameMap.clear();
            }
        }

        return result;
    }

    public FirebaseGamePlayer createGame() throws IOException {
        FirebaseGamePlayer game = new FirebaseGamePlayer();
        String gameName = game.toString().replace(GAME_PACKAGE, "");

        FirebaseOpenHelper.getInstance().getDatabase().getReference(gameName).setValueAsync(game);
        ChildEventListener listener = new GameEventListener();
        FirebaseOpenHelper.getInstance().getDatabase().getReference(gameName).addChildEventListener(listener);

        return game;
    }

    public GameService() {
        this.gameMap = new HashMap<Player, Map <String,FirebaseGamePlayer>>();
    }

    public void lancerGame(Map<Player, Map<String, FirebaseGamePlayer>> gameMap) throws IOException {
        FirebaseGamePlayer game = this.gameMap.entrySet().iterator().next().getValue().entrySet().iterator().next().getValue();
        Map<String, Player> players = new HashMap<String, Player>();

        for (Map.Entry<Player, Map<String, FirebaseGamePlayer>> iterable_element : this.gameMap.entrySet()) {
            players.put(iterable_element.getKey().toString().replace(USER_PACKAGE, ""), iterable_element.getKey());
        }

        game.setPlayers(players);

        Map.Entry<Player, Map<String, FirebaseGamePlayer>> entry = gameMap.entrySet().iterator().next();
        String gameName = entry.getValue().entrySet().iterator().next().getKey();
        FirebaseOpenHelper.getInstance().getDatabase().getReference(gameName).setValueAsync(game);
    }

    final class GameEventListener implements ChildEventListener {

        @Override
        public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
            // TODO Auto-generated method stub
            System.out.println("Added "+snapshot.getKey());
        }

        @Override
        public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
            // TODO Auto-generated method stub
            System.out.println("Changed "+snapshot.getKey());
        }

        @Override
        public void onChildRemoved(DataSnapshot snapshot) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
            // TODO Auto-generated method stub
            System.out.println("Removed "+snapshot.getKey());
        }

        @Override
        public void onCancelled(DatabaseError error) {
            // TODO Auto-generated method stub
            System.out.println("Cancelled "+error);
        }
    }
}
