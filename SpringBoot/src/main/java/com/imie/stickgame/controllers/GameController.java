package com.imie.stickgame.controllers;

import com.imie.stickgame.models.Deck;
import com.imie.stickgame.models.Player;
import com.imie.stickgame.services.DeckService;
import com.imie.stickgame.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;

@Controller
public class GameController {

    @Autowired
    GameService gameService;
    @Autowired
    DeckService deckService;

    /**
     * Controller servant à afficher la page du jeu
     * @param model
     * @return
     * @throws IOException
     *
     */
    @RequestMapping(value= {"/game"}, method=RequestMethod.GET)
    public String index(Model model) throws IOException {
        Deck deck = deckService.findByName("Elf");
        deck.setSize(deck.getCards().size());
        deck.setName("Elf");

        String[] datas = gameService.addUser(new Player(SecurityContextHolder.getContext().getAuthentication()
                .getName(),deck,"/media/cat.jpg"));
        model.addAttribute("gameReference", datas[0]);
        model.addAttribute("playerReference",datas[1]);

        return "/game";
    }
}
