package com.imie.stickgame.firebase;

import java.io.FileInputStream;
import java.io.IOException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Singleton permettant la connexion a Firebase
 */
public class FirebaseOpenHelper {

    private FirebaseAuth defaultAuth;
    private FirebaseDatabase defaultDatabase;

    /**
     * Fonction permettant la connexion à Firebase du singleton lors de la première instantiation
     * Les suivantes renverront l'instance déjà en cours
     * @throws IOException
     */
    private FirebaseOpenHelper() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/stick-game-firebase-adminsdk.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://stick-game.firebaseio.com/").build();

        FirebaseApp.initializeApp(options);

        defaultAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance());
        defaultDatabase = FirebaseDatabase.getInstance(FirebaseApp.getInstance());
    }

    private static FirebaseOpenHelper INSTANCE = null;

    /**
     * Fonction renvoyant l'instance de Firebase
     * @return
     * @throws IOException
     */
    public static synchronized FirebaseOpenHelper getInstance() throws IOException {
        if (INSTANCE == null) {
            INSTANCE = new FirebaseOpenHelper();
        }
        return INSTANCE;
    }

    /**
     * Fonction renvoyant l'accès à la base de donnée de Firebase
     * @return
     */
    public FirebaseDatabase getDatabase() {
        return defaultDatabase;
    }
}
