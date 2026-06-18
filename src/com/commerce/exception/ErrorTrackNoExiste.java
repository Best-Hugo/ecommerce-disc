package com.commerce.exception;

/* Excepción que se lanza cuando no se encuentra el Tema slicitado (id). */

public class ErrorTrackNoExiste extends RuntimeException {
    public ErrorTrackNoExiste(String sms){ // Constructor de la clase.
        super(sms); // Invoca al constructor de su clase padre.
    }
}
