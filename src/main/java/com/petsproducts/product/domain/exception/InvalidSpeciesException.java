package com.petsproducts.product.domain.exception;

public class InvalidSpeciesException extends RuntimeException {
    public InvalidSpeciesException(String species) {
        super("La especie ´" + species + "´ no es valida, tiene que ser 'DOG' o 'CAT'");
    }
}
