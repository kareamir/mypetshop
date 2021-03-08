package com.shop.mypetshop.usecase.impl;

import com.shop.mypetshop.domain.Breed;
import com.shop.mypetshop.domain.Pet;
import com.shop.mypetshop.repo.BreedRepository;
import com.shop.mypetshop.repo.PetRepository;
import com.shop.mypetshop.usecase.PetInsertUseCase;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.shop.mypetshop.utils.ValidationUtils.validateNotNull;

@Service
public class PetInsertUseCaseImpl implements PetInsertUseCase {

	private final PetRepository petRepository;

	private final BreedRepository breedRepository;

	public PetInsertUseCaseImpl(PetRepository petRepository, BreedRepository breedRepository) {
		this.petRepository = petRepository;
		this.breedRepository = breedRepository;
	}

	@Override
	@Transactional
	public Response insertPet(Request request) {
		validateNotNull(request, () -> new IllegalArgumentException("The request should not be null"));

		Breed breed = breedRepository.getOne(request.getBreedId());

		Pet pet = new Pet(request.getName(), breed);

		return new Response(petRepository.save(pet));
	}
}
