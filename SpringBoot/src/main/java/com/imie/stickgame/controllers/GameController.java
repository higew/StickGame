package com.imie.stickgame.controllers;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.imie.stickgame.firebase.FirebaseOpenHelper;
import com.imie.stickgame.firebase.FirebaseWaitingRoomObserver;
import com.imie.stickgame.firebase.models.FirebaseWaitingRoom;
import com.imie.stickgame.firebase.models.WaitingRoom;
import com.imie.stickgame.models.Deck;
import com.imie.stickgame.models.Player;
import com.imie.stickgame.services.CardService;
import com.imie.stickgame.services.GameService;
import com.imie.stickgame.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.concurrent.Executor;

@Controller
public class GameController {

   @Autowired
    GameService gameService;

    @RequestMapping(value= {"/game"}, method=RequestMethod.GET)
    public String index(Model model) throws IOException {

        String[] datas = gameService.addUser(new Player(SecurityContextHolder.getContext().getAuthentication()
                .getName(),new Deck(),"/media/cat.jpg"));
        model.addAttribute("gameReference", datas[0]);
        model.addAttribute("playerReference",datas[1]);

        return "/game";
    }
}
