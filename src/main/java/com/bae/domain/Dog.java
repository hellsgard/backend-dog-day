package com.bae.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String breed;

	@Column(nullable = false)
	private String friendly;

	@Column(nullable = false)
	private Double fee;

	public Dog() {
		super();
	}

	public Dog(String name, String breed, String friendly, Double fee) {
		super();
		this.name = name;
		this.breed = breed;
		this.friendly = friendly;
		this.fee = fee;
	}

	public Dog(int id, String name, String breed, String friendly, Double fee) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.friendly = friendly;
		this.fee = fee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getFriendly() {
		return friendly;
	}

	public void setFriendly(String friendly) {
		this.friendly = friendly;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}


	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", breed=" + breed + ", friendly=" + friendly + ", fee=" + fee
				+ "]";
	}

}
