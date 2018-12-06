package com.imie.stickgame;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.imie.stickgame.manager.GameManager;
import com.imie.stickgame.models.BaseEffect;
import com.imie.stickgame.models.Card;
import com.imie.stickgame.models.Classes;
import com.imie.stickgame.models.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.imie.stickgame.security.services.PreLaunchService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("src/main/resources/stick-game-firebase-adminsdk.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://stick-game.firebaseio.com/")
                    .build();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        FirebaseApp app = FirebaseApp.initializeApp(options);
        FirebaseDatabase db = FirebaseDatabase.getInstance(app);
        System.out.println("1");
        db.getReference("notifications").setValueAsync(new GameManagerDTO());
        System.out.println("2");
	}

//	@Autowired
//	PreLaunchService service;
//
//	@Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return new CommandLineRunner() {
//			public void run(String... args) throws Exception {
//				service.createFirstAdmin();
//				service.createUSER();
//			}
//		};
//   }
}


