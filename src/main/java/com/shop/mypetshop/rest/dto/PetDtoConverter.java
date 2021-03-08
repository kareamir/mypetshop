package com.shop.mypetshop.rest.dto;

import com.shop.mypetshop.domain.Breed;
import com.shop.mypetshop.domain.Pet;
import com.shop.mypetshop.domain.Specie;

import java.util.Optional;

public class PetDtoConverter {

	public static PetDto toPetDto(Pet pet) {
		return new PetDto(
				pet.getId(),
				pet.getName(),
				getBreed(pet),
				getSpecie(pet)
		);
	}

	private static String getSpecie(Pet pet) {
		return Optional.ofNullable(pet.getBreed())
				.map(Breed::getSpecie)
				.map(Specie::getName)
				.orElse(null);
	}

	private static String getBreed(Pet pet) {
		return Optional.ofNullable(pet.getBreed())
				.map(Breed::getName)
				.orElse(null);
	}
}
