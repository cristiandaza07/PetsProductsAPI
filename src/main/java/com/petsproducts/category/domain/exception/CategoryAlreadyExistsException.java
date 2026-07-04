package com.petsproducts.category.domain.exception;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String nameCategory) {
        super("La categoria con nombre " + nameCategory + " ya existe");
    }
}
