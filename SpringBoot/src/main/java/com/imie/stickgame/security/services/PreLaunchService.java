package com.imie.stickgame.security.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Autowired
	private DataSource dataSource;
	
	/**
	 * Creation Role_Admin ainsi qu'un administrateur par default.
	 */
	public void createFirstAdmin() {
	
		User user = new User("admin@admin.fr", "admin", 1, "myAdmin", "forSite");
		createUserWithRole(user,"ROLE_ADMIN");	
	}
	
	@Transactional()
	public void createUserWithRole(User user, String roleName)  {

		Role role = null;
		if ((role = this.serviceRole.findByName(roleName)) == null) {
			role = new Role(roleName);
			this.serviceRole.save(role);
		}
		
		User userTest = null;
		if ((userTest = this.serviceUser.findByEmail(user.getEmail())) == null
				|| userTest.getRoles().size() == 0) {
			user.getRoles().add(role);
			this.serviceUser.save(user);
		}
	}
	
	public void createRoleUser() {
		
		if ((this.serviceRole.findByName("ROLE_USER")) == null) {
		Role role = new Role("ROLE_USER");		
		this.serviceRole.save(role);
		}
	}
	
	/**
	 * Creation d'une liste de 30 cartes et d'un deck par default.
	 */
	@Transactional()
	public void createFirstCardsDeck()  {
		
		if ((this.serviceCard.findByName("card1")) == null) {
		//(name, picture, hp, atk, inCost, baseEffect, classes)
	    List<Card> cards = new ArrayList<>();
		cards.add(new Card ("card1","/media/stickfighter2.png", 6,2,3, null, null));
		cards.add(new Card ("card2","/media/stickfighter3.png", 6,3,5, null, null));
		cards.add(new Card ("card3","/media/stickfighter4.png", 6,2,3, null, null));
		cards.add(new Card ("card4","/media/stickfighter5.png", 6,2,3, null, null));
		cards.add(new Card ("card5","/media/stickfighter6.png", 6,2,3, null, null));
		cards.add(new Card ("card6","/media/stickfighter7.png", 6,2,3, null, null));
		cards.add(new Card ("card7","/media/stickfighter8.png", 6,2,3, null, null));
		cards.add(new Card ("card8","/media/stickfighter9.png", 6,2,3, null, null));
		cards.add(new Card ("card9","/media/stickfighter10.png", 6,2,3, null, null));
		cards.add(new Card ("card10","/media/stickfighter11.png", 6,2,3, null, null));
		cards.add(new Card ("card11","/media/stickfighter12.png", 6,2,3, null, null));
		cards.add(new Card ("card12","/media/stickfighter13.png", 6,2,3, null, null));
		cards.add(new Card ("card13","/media/stickfighter14.png", 6,2,3, null, null));
		cards.add(new Card ("card14","/media/stickfighter15.png", 6,2,3, null, null));
		cards.add(new Card ("card15","/media/stickfighter16.png", 6,2,3, null, null));
		cards.add(new Card ("card16","/media/stickfighter17.png", 6,2,3, null, null));
		cards.add(new Card ("card17","/media/stickfighter18.png", 6,2,3, null, null));
		cards.add(new Card ("card18","/media/stickfighter2.png", 6,2,3, null, null));
		cards.add(new Card ("card19","/media/stickfighter3.png", 6,2,3, null, null));
		cards.add(new Card ("card20","/media/stickfighter4.png", 6,2,3, null, null));
		cards.add(new Card ("card21","/media/stickfighter5.png", 6,2,3, null, null));
		cards.add(new Card ("card22","/media/stickfighter6.png", 6,2,3, null, null));
		cards.add(new Card ("card23","/media/stickfighter7.png", 6,2,3, null, null));
		cards.add(new Card ("card24","/media/stickfighter8.png", 6,2,3, null, null));
		cards.add(new Card ("card25","/media/stickfighter9.png", 6,2,3, null, null));
		cards.add(new Card ("card26","/media/stickfighter10.png", 6,2,3, null, null));
		cards.add(new Card ("card27","/media/stickfighter11.png", 6,2,3, null, null));
		cards.add(new Card ("card28","/media/stickfighter12.png", 6,2,3, null, null));
		cards.add(new Card ("card29","/media/stickfighter13.png", 6,2,3, null, null));
		cards.add(new Card ("card30","/media/stickfighter14.png", 6,2,3, null, null));

		cards.forEach((i) -> this.serviceCard.save(i)); 
	
		Deck deck = new Deck();
		deck.setName("Elf");
		deck.setCards(cards);
		this.serviceDeck.save(deck);
		}			
	}
	
	@Transactional()
	public void insertSessionDatabase() throws SQLException {
		Connection connection = dataSource.getConnection();
		
		ResultSet rs = connection.prepareStatement("SHOW TABLES").executeQuery();
		
		Boolean haveTable = false;
		while (rs.next()) {
			if (rs.getString(1).equals("spring_session")) {
				haveTable = true;
			}
		}

		if (!haveTable) {
			connection.createStatement()
					.execute("CREATE TABLE SPRING_SESSION (" +
							"	PRIMARY_ID CHAR(36) NOT NULL," + 
							"	SESSION_ID CHAR(36) NOT NULL," + 
							"	CREATION_TIME BIGINT NOT NULL," + 
							"	LAST_ACCESS_TIME BIGINT NOT NULL," + 
							"	MAX_INACTIVE_INTERVAL INT NOT NULL," + 
							"	EXPIRY_TIME BIGINT NOT NULL," + 
							"	PRINCIPAL_NAME VARCHAR(100)," + 
							"	CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)" + 
							") ENGINE=InnoDB ROW_FORMAT=DYNAMIC;");
					connection.createStatement()
					.execute("CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);"); 
							connection.createStatement()
					.execute("CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);");
							connection.createStatement()
					.execute("CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);");
					connection.createStatement()
						.execute("CREATE TABLE SPRING_SESSION_ATTRIBUTES (" + 
							"	SESSION_PRIMARY_ID CHAR(36) NOT NULL," + 
							"	ATTRIBUTE_NAME VARCHAR(200) NOT NULL," + 
							"	ATTRIBUTE_BYTES BLOB NOT NULL," + 
							"	CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME)," + 
							"	CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE" + 
							") ENGINE=InnoDB ROW_FORMAT=DYNAMIC;");
		}
		connection.close();
	}
}
