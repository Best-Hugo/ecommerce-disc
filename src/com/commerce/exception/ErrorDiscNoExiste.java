package com.commerce.exception;

/* Excepción que se lanza cuando no se encuentra el disco slicitado (id). */

public class ErrorDiscNoExiste extends RuntimeException {
    public ErrorDiscNoExiste(String sms){ // Constructor de la clase.
        super(sms); // Invoca al constructor de su clase padre.
    }
}
