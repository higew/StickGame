package com.imie.stickgame.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import com.imie.stickgame.utils.ClassUtils;


class IndexControllerTest {

	@Autowired
	private IndexController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void navigation() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void canLogout() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("<a href=\"/logout\">Logout<a/>")));
	}
	
	@Test
	public void canRegister() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("<a href=\"/registration\">Register<a/>")));
	}
	
	@Test
	public void canNavigateToAdminModels() throws Exception {
		
		for (Class<?> klazz : ClassUtils.getClasses("com.example.demo.models")) {
			this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("<a href=\"/"+klazz.getSimpleName().toLowerCase()+"s")));
		}
		
	}
	
	@Test
	public void cookieGenerated() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(cookie().exists("myCookie"));
	}

}
