package com.shop.mypetshop.rest.dto;

public class PetInsertDto {

	private final Long id;

	private final String name;

	private final Long breedId;

	public PetInsertDto(
			Long id,
			String name,
			Long breedId) {
		this.id = id;
		this.name = name;
		this.breedId = breedId;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getBreedId() {
		return breedId;
	}
}
