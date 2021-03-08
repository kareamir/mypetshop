package com.shop.mypetshop.usecase;

import com.shop.mypetshop.domain.Pet;

import static com.shop.mypetshop.utils.ValidationUtils.validateNotNull;

public interface PetInsertUseCase {

	Response insertPet(Request request);

	class Request {
		private final String name;

		private final Long breedId;

		public Request(String name, Long breedId) {
			validateNotNull(name, () -> new IllegalArgumentException("The pet name should not be null"));

			this.name = name;
			this.breedId = breedId;
		}

		public String getName() {
			return name;
		}

		public Long getBreedId() {
			return breedId;
		}
	}

	class Response {
		private final Pet pet;

		public Response(Pet pet) {
			this.pet = pet;
		}

		public Pet getPet() {
			return pet;
		}
	}
}
