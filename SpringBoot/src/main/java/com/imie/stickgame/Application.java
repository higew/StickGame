package com.imie.stickgame;

import com.imie.stickgame.firebase.FirebaseOpenHelper;
import com.imie.stickgame.firebase.models.FirebaseGamePlayer;
import com.imie.stickgame.security.services.PreLaunchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        /*FirebaseGamePlayer firebaseGamePlayer = new FirebaseGamePlayer(new Player("cc", new Deck(), "pic"), new
                Player("dd", new Deck
                (),"pic"));
        Player player1 = firebaseGamePlayer.getPlayer1();
        player1.setName("TAMER");
        System.out.println(firebaseGamePlayer.getPlayer1().getName());*/


        //FirebaseGamePlayer firebaseGamePlayer = new FirebaseGamePlayer();
        /*GameManager gameManager = new GameManager("Brice", "Antoine", new Deck(), new Deck(),
                "../StickGame/html/media/profilBrice.jpeg", "../StickGame/html/media/profilAntoine.jpeg");
        gameManager.game();

        System.out.println("1");*/
        /*try {
            FirebaseOpenHelper.getInstance().getDatabase().getReference("games/").child(firebaseGamePlayer.toString()
            ).setValueAsync(firebaseGamePlayer);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //db.getReference("notifications").setValueAsync(new GameManagerDTO());
        //System.out.println("2");
        }


//        @Autowired
//        PreLaunchService service;
//
//        @Bean
//        public CommandLineRunner commandLineRunner (ApplicationContext ctx) {
//            return new CommandLineRunner() {
//                public void run(String... args) throws Exception {
//                    service.createFirstAdmin();
//                    service.createRoleUser();
//                    service.createFirstCardsDeck();
//                }
//            };
//        }
    }
