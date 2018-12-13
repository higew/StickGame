//package com.imie.stickgame;
//import com.imie.stickgame.models.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class GameManagerDTO {
//
////    private User user;
////
////    public User getUser() {
////        return user;
////    }
////
////    public void setUser(User user) {
////        this.user = user;
////    }
////
////    public List<User> getUsers(){
////        return new ArrayList<User>(){{add(new User("u1","hey"));
////        add(new User("u2","hey"));}};
////    }
////
////    private Player player;
////
////    public Player getPlayer() {
////        return player;
////    }
////
////    public void setPlayer(Player player) {
////        this.player = player;
////    }
//
//
//    private Map<String,GameManager> gameManager;
//
//    public Map<String,GameManager> getGameManager() {
//        return gameManager;
//    }
//
//    public void setGameManager(Map<String,GameManager> gameManager) {
//        this.gameManager = gameManager;
//    }
//
//    public GameManagerDTO() {
////        this.user = new User("coucou","heyhey");
////        this.player = new Player("player1",new Deck(),"pic1");
//        Deck d = new Deck();
//        d.setName("d1");
//        BaseEffect baseEffect = new BaseEffect();
//        baseEffect.setDescription("desc");
//        baseEffect.setEffectIdentifier(1);
//
//        Classes classes = new Classes();
//        classes.setName("clases1");
//        classes.setPicture("picclasse");
//        d.getCards().add(new Card("card","pic",12,3,1,baseEffect,classes));
//        this.gameManager = new HashMap<String, GameManager>(){{
//            put("uuidkey02616516954",new GameManager("p1","p2",d,d,"pic1","pic2"));
//            put("uuid1846489484",new GameManager("p1","p2",d,d,"pic1","pic2"));
//            put("uuidkey561651",new GameManager("p1","p2",d,d,"pic1","pic2"));
//        }};
//    }
//}
