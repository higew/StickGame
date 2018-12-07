package com.imie.stickgame.database;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Conversation;
import com.imie.stickgame.models.Message;

@Repository
public interface ConversationRepository extends BaseCRUDRepository<Conversation> {
	
	List<Conversation> findByName(String name);
	List<Conversation> findByDate(Date date);
	List<Message> findBylabe(String label);

}
