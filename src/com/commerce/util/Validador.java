package com.commerce.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.commerce.exception.ErrorStockInsuficiente;

public class Validador {
    public static void  valCampTex(String campo, String msgEro){ // Valida que el campo no esté vacío.
        if(campo == null || campo.trim().isEmpty()){ // Si el campo es nulo o no se ingresó nada.
            throw new IllegalArgumentException(msgEro); 
        }
    }

    public static void valCamNum(double campo, String msgEro){ // Valida que el campo no esté vacio.
        String nueVal = String.valueOf(campo); // Convierte el número en un string.
        if(nueVal == null || nueVal.trim().isEmpty()){ // Si el campo es nulo o no se ingresó nada.
            throw new IllegalArgumentException(msgEro); 
        }
    }

    public static void valCamInt(int campo, String msgEro){ // Valida que el campo no esté vacio.
        String nueVal = String.valueOf(campo); // Convierte el número en un string.
        if(nueVal == null || nueVal.trim().isEmpty()){ // Si el campo es nulo o no se ingresó nada.
            throw new IllegalArgumentException(msgEro); 
        }
    }
    public static void valUrl(String url, String msgEro){ // Valida la URL de almacenamiento.
        if(!(url.matches("^/uploads/img/.+\\.(png|jpg|jpeg)$"))){ // Si la url no coincide con la expresión regular.
            throw new IllegalArgumentException(msgEro); // Muestra el mensaje de error.
        }
    }

    public static boolean valFecha(String fecha){ // Valida el formato de fecha.
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(fecha, formato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void valAnio(String anio, String msgEro){ // Valida el año.
        if(!(valFecha(anio))){ // Si no tiene el formato correcto.
            throw new IllegalArgumentException(msgEro); // Muestra el mensaje de error.
        }
    }

    public static void valTexto(String texto, String msgEro){ // Valida el texto.
        if(!(texto.matches("^[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$"))){ // Si el texto tiene caracteres no permitidos.
            throw new IllegalArgumentException(msgEro); // Muestra el mensaje de error.
        }
    }

    public static void valPrecio(double precio, String msgEro){ // 
        if(precio < 0){ // Si el precio es negativo.
            throw new IllegalArgumentException(msgEro); // Muestra el mensaje de error.
        }
    }

    public static void valStock(int stock, String msgEro){ // Comprueba el stock.
        if(stock < 0){ // Si el stock es negativo.
            throw new ErrorStockInsuficiente(msgEro); // Muestra el mensaje de error.
        }
    }

    public static void valDuracion(String tiempo, String msgEro){ // Vlida el tiempo de duración del tema.
        if(!tiempo.matches("^[0-5][0-9]:[0-5][0-9]$")){ // Si el tiempo no coicide con este patrón.
            throw new IllegalArgumentException(msgEro); // Muestra el mensaje de error.
        }
    }

    // Lectura segura desde consola.

    public static int leeEntero(Scanner sc, String msg){ // Controla el ingreso de un entero.
        while(true){ // Loop infinito que espera el correcto ingreso de datos.
            System.out.print(msg);
            try {
                int num = sc.nextInt();
                sc.nextLine();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Deve ingresar un número entero. Intentelo nuevamente.");
                sc.nextLine();
            }
        }
    }

    public static double leeDouble(Scanner sc, String msg){ // Controla el ingreso de un número digital. 
        while(true){ // Loop infinito que espera el correcto ingreso de datos.
            System.out.println(msg); // Muestra el mensaje.
            try {
                double num = sc.nextDouble();
                sc.nextLine();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número decimal (Utilize cama o punto).");
                sc.nextLine();
            }
        }
    }

    public static String leeTexto(Scanner sc, String msg){ // Controla el ingreso de texto.
        System.out.println(msg); //  Muestra el mensaje solicitando datos.
        return sc.nextLine();
    }

}
