package com.petsproducts.category.domain.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String nameCategory) {
        super("La categoria " + nameCategory + " no existe");
    }
}
