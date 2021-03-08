package com.shop.mypetshop.useCase.impl;

import com.shop.mypetshop.repo.BreedRepository;
import com.shop.mypetshop.repo.PetRepository;
import com.shop.mypetshop.usecase.impl.PetInsertUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class PetInsertUseCaseImplTest {

	private static final Long A_BREED_ID = 413431L;

	@Mock
	private PetRepository petRepository;

	@Mock
	private BreedRepository breedRepository;

	@InjectMocks
	private PetInsertUseCaseImpl useCase;

	@Test
	void insertThrowsIllegalArgumentExceptionIfRequestIsNull() {
		// When
		assertThrows(IllegalArgumentException.class, () -> {
			useCase.insertPet(null);
		});
	}
}