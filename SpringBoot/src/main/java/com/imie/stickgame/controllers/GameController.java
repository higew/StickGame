package com.imie.stickgame.controllers;

import com.imie.stickgame.controllers.base.BaseController;
import com.imie.stickgame.firebase.models.FirebaseGamePlayer;
import com.imie.stickgame.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GameController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value= {"/game"}, method=RequestMethod.GET)
    public String index(Model model) {
        FirebaseGamePlayer firebaseGamePlayer = new FirebaseGamePlayer();
        for (int i = 1; i <= 30; i++) {
            firebaseGamePlayer.getPlayer1().getDeck().getCards().addAll(cardService.findByName("card" + i));
        }
        for (int i = 0; i < 30; i++) {
            System.out.println(firebaseGamePlayer.getPlayer1().getDeck().getCards().get(i).getName());
        }

        return "/game";
    }
}

// Créer un event listener qui va attendre que la partie ait deux joueurs et que deux joueurs aient rejoint la partie
// avant d'appeller la fonction qui permettra de décider du premier joueur
// Ajouter un boolean qui permettra de jouer un gif en attendant qu'un deuxième joueur se connecte pour lancer la
// parties