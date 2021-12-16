package com.bae.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.domain.Dog;

@Repository
public interface DogRepo extends JpaRepository<Dog, Integer> {

	List<Dog> findByNameIgnoreCase(String name);

	List<Dog> findByBreedIgnoreCase(String breed);

	List<Dog> findByFriendlyIgnoreCase(String friendly);

}
