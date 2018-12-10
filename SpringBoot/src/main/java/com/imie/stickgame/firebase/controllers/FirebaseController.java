package com.imie.stickgame.firebase.controllers;

import java.io.IOException;
import java.util.concurrent.Executor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

@Controller
@RequestMapping("/firebase")
public class FirebaseController {

    @RequestMapping(value= {"","/","/index"})
    public String index(Model model) throws IOException {

        return "/firebase/index";
    }
}
