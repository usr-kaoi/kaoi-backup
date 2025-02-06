package com.gft.api.exception;

public class GatoNotFoundException extends RuntimeException {
    public GatoNotFoundException(Long id) {
        super("Gato com ID " + id + " nao encontrado.");
    }
}
