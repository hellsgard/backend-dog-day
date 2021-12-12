package com.bae.domain;

public class Dog {

	private int id;

	private String name;

	private String breed;

	private Boolean friendly;

	private Double fee;

	public Dog() {
		super();
	}

	public Dog(String name, String breed, Boolean friendly, Double fee) {
		super();
		this.name = name;
		this.breed = breed;
		this.friendly = friendly;
		this.fee = fee;
	}

	public Dog(int id, String name, String breed, Boolean friendly, Double fee) {
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

	public Boolean getFriendly() {
		return friendly;
	}

	public void setFriendly(Boolean friendly) {
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
