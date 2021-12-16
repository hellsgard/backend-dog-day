package com.bae.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.domain.Dog;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:dog-schema.sql",
		"classpath:dog-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

@ActiveProfiles("test")
public class DogControllerIntegrationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Dog testDog = new Dog("Gerald", "kelpie", "yes", 200D);
		String testDogAsJSON = this.mapper.writeValueAsString(testDog);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testDogAsJSON);

		Dog testCreatedDog = new Dog(2, "Gerald", "kelpie", "yes", 200D);
		String testCreatedDogAsJSON = this.mapper.writeValueAsString(testCreatedDog);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedDogAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void getAllTest() throws Exception {
		List<Dog> testDogs = List.of(new Dog(1, "Testdog", "Boxer", "yes", 100D));
		String json = this.mapper.writeValueAsString(testDogs);

		RequestBuilder req = get("/getAll");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void getByIdTest() throws Exception {
		Dog testDog = new Dog(1, "Testdog", "Boxer", "yes", 100D);
		String json = this.mapper.writeValueAsString(testDog);

		RequestBuilder req = get("/getById/1");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void getByNameTest() throws Exception {
		List<Dog> testDogs = List.of(new Dog(1, "Testdog", "Boxer", "yes", 100D));
		String json = this.mapper.writeValueAsString(testDogs);
		RequestBuilder req = get("/getByName/Testdog");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void getByBreedTest() throws Exception {
		List<Dog> testDogs = List.of(new Dog(1, "Testdog", "Boxer", "yes", 100D));
		String json = this.mapper.writeValueAsString(testDogs);

		RequestBuilder req = get("/getByBreed/Boxer");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void updateTest() throws Exception {
		Dog updateDog = new Dog(1, "Gerald", "Pug", "no", 150D);
		String json = this.mapper.writeValueAsString(updateDog);

		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(json);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {

		RequestBuilder req = delete("/remove/1");

		ResultMatcher checkStatus = status().isNoContent();

		this.mvc.perform(req).andExpect(checkStatus);

	}

}
