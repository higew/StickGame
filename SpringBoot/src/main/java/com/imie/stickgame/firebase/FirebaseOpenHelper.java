package com.imie.stickgame.firebase;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseOpenHelper {

    private FirebaseAuth defaultAuth;
    private FirebaseDatabase defaultDatabase;

    private FirebaseOpenHelper() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/stick-game-firebase-adminsdk-ghd01-e036b12c1b.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://stick-game.firebaseio.com/").build();

        FirebaseApp.initializeApp(options);

        defaultAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance());
        defaultDatabase = FirebaseDatabase.getInstance(FirebaseApp.getInstance());
    }

    private static FirebaseOpenHelper INSTANCE = null;

    public static synchronized FirebaseOpenHelper getInstance() throws IOException {
        if (INSTANCE == null) {
            INSTANCE = new FirebaseOpenHelper();
        }
        return INSTANCE;
    }

    public FirebaseDatabase getDatabase() {
        return defaultDatabase;
    }
}

/*

<script src="https://www.gstatic.com/firebasejs/5.6.0/firebase.js"></script>
<script>
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyDF5kudIsloz3Z-71VSc1ckz1e-FUYDdTI",
    authDomain: "stick-game.firebaseapp.com",
    databaseURL: "https://stick-game.firebaseio.com",
    projectId: "stick-game",
    storageBucket: "stick-game.appspot.com",
    messagingSenderId: "624366143716"
  };
  firebase.initializeApp(config);
</script>
 */
