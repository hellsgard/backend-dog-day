package com.bae.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.domain.Dog;
import com.bae.repo.DogRepo;

//test

@Service
public class DogServiceDB {

	private DogRepo repo;

	@Autowired
	public DogServiceDB(DogRepo repo) {
		super();
		this.repo = repo;
	}

	public Dog createDog(Dog dogg) {
		Dog created = this.repo.save(dogg);
		return created;
	}

	public List<Dog> getAllDogs() {
		return this.repo.findAll();
	}

	public List<Dog> getDogByName(String name) {
		List<Dog> found = this.repo.findByNameIgnoreCase(name);
		return found;
	}

	public List<Dog> getDogByBreed(String breed) {
		List<Dog> found = this.repo.findByBreedIgnoreCase(breed);
		return found;
	}

	public List<Dog> getDogByFriendly(String friendly) {
		List<Dog> found = this.repo.findByFriendlyIgnoreCase(friendly);
		return found;
	}

	public Dog getDogById(Integer id) {
		Optional<Dog> found = this.repo.findById(id);
		return found.get();
	}

	public Dog replaceDog(Integer id, Dog newDog) {
		Dog current = this.repo.findById(id).get();

		current.setName(newDog.getName());
		current.setBreed(newDog.getBreed());
		current.setFriendly(newDog.getFriendly());
		current.setFee(newDog.getFee());

		Dog updated = this.repo.save(current);
		return updated;
	}

	public void removeDog(Integer id) {
		this.repo.deleteById(id);
	}

}
