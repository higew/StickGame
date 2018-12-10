package com.imie.stickgame.controllers;

import com.imie.stickgame.firebase.FirebaseOpenHelper;
import com.imie.stickgame.firebase.FirebaseWaitingRoomObserver;
import com.imie.stickgame.firebase.models.FirebaseWaitingRoom;
import com.imie.stickgame.manager.GameManager;
import com.imie.stickgame.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class GameController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value= {"/game"}, method=RequestMethod.GET)
    public String index(Model model) throws IOException {
        boolean isReady = false;
        GameManager gameManager = new GameManager();
        FirebaseWaitingRoom firebaseWaitingRoom = new FirebaseWaitingRoom();
        FirebaseOpenHelper.getInstance().getDatabase().getReference("/waitingroom").
                setValueAsync(firebaseWaitingRoom);

        /*
        Map<Salle d'attente, User> --> Il possède en fait l'id de la game dans la DB

        addUser(User user) {
            if la map > 0
                addtogame(map<0>, user)
            else
                CreateListener(   createGame(user)   ) -- Listen sur la map retournée par le createGame pour trouver
                un adversaire
          }

          createGame(User user) {
            Map wait<game, user>
          }

        */

        model.addAttribute("play", isReady);



        // Créer un ArrayList FirebaseWaitingRoom contenant le nom des utilisateurs en attente d'une game
        // Lorsqu'on a deux users dedans, on prend les deux pour les lancer sur une game
        // On appelle donc la fonction game du gameManager et on assigne le deck par défaut a ces deux persos la
        // Le fait de lancer une game requiert la création d'un event listener sur l'ArrayList
        // On changera le boolean de false a true lorsque la game sera prête
        // Ajouter un boolean pour savoir si le player a terminé de poser ses cartes



        //**************************************************************************************************
        //**************************************************************************************************
        // Code de test pour insérer un player complet dans Firebase

        /*FirebaseGamePlayer firebaseGamePlayer = new FirebaseGamePlayer();
        PlayerManager playerManager = new PlayerManager();

        for (int i = 1; i <= 30; i++) {
            firebaseGamePlayer.getPlayer1().getDeck().getCards().add(cardService.findByName("card" + i));
        }
        playerManager.draw(firebaseGamePlayer.getPlayer1(), 5);
        firebaseGamePlayer.getPlayer1().getBattlefield().getMonsterZone().add(cardService.findByName("card30"));
        playerManager.discard(firebaseGamePlayer.getPlayer1(), 1);
        try {
            FirebaseOpenHelper.getInstance().getDatabase().getReference("games/")
                    .child(firebaseGamePlayer.getGame()).setValueAsync(firebaseGamePlayer);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //**************************************************************************************************
        //**************************************************************************************************


        return "/game";
    }
}
