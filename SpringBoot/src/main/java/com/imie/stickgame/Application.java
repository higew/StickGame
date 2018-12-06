package com.imie.stickgame;

import com.imie.stickgame.firebase.FirebaseOpenHelper;
import com.imie.stickgame.firebase.models.FirebaseGamePlayer;
import com.imie.stickgame.manager.GameManager;
import com.imie.stickgame.models.Deck;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


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


