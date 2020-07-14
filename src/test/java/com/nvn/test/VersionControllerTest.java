package com.nvn.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VersionControllerTest {

	@Autowired
	private MockMvc mvc;

//	@Autowired
//	private TestRestTemplate template;

	@Test
	public void getVersion() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/version").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}


	@Autowired
	private VersionController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
