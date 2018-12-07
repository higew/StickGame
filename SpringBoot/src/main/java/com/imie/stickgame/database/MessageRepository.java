package com.imie.stickgame.database;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Message;

@Repository
public interface MessageRepository extends BaseCRUDRepository<Message> {
	
	List<Message> findByConversationName(String name);
	List<Message> findByDate(Date date);
	List<Message> findByLabel(String label);

}
