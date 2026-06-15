package com.commerce.exception;

/* Excepcipon que se lanza cuando el stock es insuficiente o no hay. */
public class ErrorStockInsuficiente extends RuntimeException {
    public ErrorStockInsuficiente(String sms){
        super(sms); // Invoca al constructor de su super clase.
    }
}
