package com.shop.mypetshop.utils;

import java.util.function.Supplier;

public class ValidationUtils {

	public static <E extends Exception> void validateNotNull(Object object, Supplier<E> exceptionSupplier) throws E {
		if (object == null) {
			throw exceptionSupplier.get();
		}
	}
}
