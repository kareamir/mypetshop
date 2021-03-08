package com.shop.mypetshop.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PetDto {

	private final Long id;

	private final String name;

	private final String breed;

	private final String specie;

	@JsonCreator
	public PetDto(
			@JsonProperty("id") Long id,
			@JsonProperty("name") String name,
			@JsonProperty("breed") String breed,
			@JsonProperty("specie") String specie) {
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.specie = specie;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public String getSpecie() {
		return specie;
	}
}
