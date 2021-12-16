package com.bae.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.domain.Dog;
import com.bae.service.DogServiceDB;

@CrossOrigin

@RestController
public class DogController {

	private DogServiceDB service;

	@Autowired
	public DogController(DogServiceDB service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Dog> createDog(@RequestBody Dog dogg) {
		Dog created = this.service.createDog(dogg);
		ResponseEntity<Dog> response = new ResponseEntity<Dog>(created, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getAll") // 200
	public ResponseEntity<List<Dog>> getAllDogs() {
		return ResponseEntity.ok(this.service.getAllDogs());
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Dog> getDogById(@PathVariable Integer id) {
		Dog found = this.service.getDogById(id);
		return ResponseEntity.ok(found);
	}

	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Dog>> getDogByName(@PathVariable String name) {
		List<Dog> found = this.service.getDogByName(name);
		return ResponseEntity.ok(found);
	}

	@GetMapping("/getByBreed/{breed}")
	public ResponseEntity<List<Dog>> getDogByBreed(@PathVariable String breed) {
		List<Dog> found = this.service.getDogByBreed(breed);
		return ResponseEntity.ok(found);
	}

	@PutMapping("/replace/{id}") // 202 - accepted
	public ResponseEntity<Dog> replaceDog(@PathVariable Integer id, @RequestBody Dog newDog) {
		Dog body = this.service.replaceDog(id, newDog);
		System.out.println("ID: " + id);
		System.out.println("Dog: " + newDog);
		ResponseEntity<Dog> response = new ResponseEntity<Dog>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{id}") // 204
	public ResponseEntity<Dog> removeDog(@PathVariable Integer id) {
		System.out.println("ID: " + id);
		this.service.removeDog(id.intValue());

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
