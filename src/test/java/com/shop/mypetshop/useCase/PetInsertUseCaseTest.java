package com.shop.mypetshop.useCase;

import com.shop.mypetshop.usecase.PetInsertUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PetInsertUseCaseTest {

	private static final Long A_BREED_ID = 4314L;

	@Test
	void throwsIllegalArgumentExceptionIfNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			// When
			new PetInsertUseCase.Request(null, A_BREED_ID);
		});
	}
}
