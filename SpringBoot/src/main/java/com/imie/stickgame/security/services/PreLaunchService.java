package com.imie.stickgame.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imie.stickgame.models.Card;
import com.imie.stickgame.models.Deck;
import com.imie.stickgame.models.Role;
import com.imie.stickgame.models.User;
import com.imie.stickgame.services.CardService;
import com.imie.stickgame.services.DeckService;
import com.imie.stickgame.services.RoleService;
import com.imie.stickgame.services.UserService;


@Service
public class PreLaunchService {
	
	@Autowired
	private RoleService serviceRole;
	
	@Autowired
	private UserService serviceUser;
	
	@Autowired
	private CardService serviceCard;
	
	@Autowired
	private DeckService serviceDeck;
	
	//Modif en cours
//	
//	public Role RoleTableExist (EntityManager em, String name) {
//	    TypedQuery<Role> query = em.createQuery(
//	        "SELECT c FROM Role c WHERE c.name = :name", Role.class);
//	    return query.setParameter("name", name).getSingleResult();
//	  } 
	
	/**
	 * Creation Role_Admin ainsi qu'un administrateur par default.
	 */
	public void createFirstAdmin() {
		
		Role role = new Role("ROLE_ADMIN");
		
		this.serviceRole.save(role);

		
		User user = new User("admin@admin.admin", "admin", 1, "stick", "game");
		user.getRoles().add(role);
		this.serviceUser.save(user);
	
	}

	/**
	 * Creation du role utilisateur
	 */
	public void createRoleUser() {
		Role role = new Role("ROLE_USER");
		
		this.serviceRole.save(role);
		
		//Ajout d'un utilisateur pour les tests
		User user = new User("user@user.fr", "user", 1, "user", "user");
		user.getRoles().add(role);
		this.serviceUser.save(user);
		
	}
	
	/**
	 * Creation d'une liste de 30 cartes et d'un deck par default.
	 */
	public void createFirstCardsDeck() {
		
		//(name, picture, hp, atk, inCost, baseEffect, classes)
	    List<Card> cards = new ArrayList<>();
		cards.add(new Card ("card1","src/main/resources/static/media/card1.png", 6,2,3, null, null));		
		cards.add(new Card ("card2","src/main/resources/static/media/card2.png", 6,3,5, null, null));
		cards.add(new Card ("card3","src/main/resources/static/media/card3.png", 6,2,3, null, null));
		cards.add(new Card ("card4","src/main/resources/static/media/card4.png", 6,2,3, null, null));
		cards.add(new Card ("card5","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card6","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card7","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card8","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card9","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card10","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card11","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card12","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card13","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card14","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card15","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card16","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card17","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card18","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card19","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card20","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card21","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card22","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card23","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card24","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card25","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card26","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card27","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card28","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card29","src/main/resources/static/media/card5.png", 6,2,3, null, null));
		cards.add(new Card ("card30","src/main/resources/static/media/card5.png", 6,2,3, null, null));

		cards.forEach((i) -> this.serviceCard.save(i)); 
	
		Deck deck = new Deck();
		deck.setName("Elf");
		deck.setCards(cards);
		this.serviceDeck.save(deck);
	}

}
