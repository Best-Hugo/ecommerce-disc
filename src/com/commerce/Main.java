package com.commerce;

import java.util.Scanner;

import com.commerce.exception.ErrorDiscNoExiste;
import com.commerce.exception.ErrorStockInsuficiente;
import com.commerce.service.DiscService;
import com.commerce.service.TrackService;
import com.commerce.ui.Menu;
import com.commerce.ui.SubMenu;
import com.commerce.util.Validador;
import com.commerce.dataExample.listDiscs;

/* Punto de entrada del programa. */

public class Main {
    public static void main(String[] args){
        // Inicializa los valores útiles para el programa.
        DiscService serDisc = new DiscService(); // Para validar datos de un disco y realizar el CRUD.
        TrackService serTrack = new TrackService(); // Para validar datos de un tema y realizar el CRUD.

        Scanner scDisc = new Scanner(System.in); // Para leer valores de consola.
        Scanner scTrack = new Scanner(System.in); // Para leer valores de consola.

        Menu menuDisc = new Menu(scDisc, serDisc); // Define el menú para interactuar con los discos.
        SubMenu menuTrack = new SubMenu(scTrack, serTrack); // Define el menú para interactuar con los temas.

        listDiscs.cargarDiscosPrueba(serDisc); // Carga de discos de prueba.

        int opcion; // Almacena la opción del menú seleccionada.

        do { // maneja todo el flujo de la app.
            menuDisc.mostrarMenu(); // Visualiza las distintas opciones del menú de discos.

            opcion = Validador.leeEntero(scDisc, "Elija una opción: "); // Muestra diálogo y valida la entrada.

            try { // Intenta realizar una de las operaciones validas para manipular un disco.
                switch (opcion) {
                    case 1 -> menuDisc.crearDisco();
                    case 2 -> menuDisc.mostrarDiscos();
                    case 3 -> menuDisc.buscarDisco();
                    case 4 -> menuDisc.actualizarDisco();
                    case 5 -> menuDisc.eliminarDisco();
                    case 6 -> System.out.println("Hasta luego!");
                    default -> System.out.println("Opción inválida. Elija un número del 1 al 6.");
                }
            } catch (ErrorDiscNoExiste | ErrorStockInsuficiente e) { // Si ocurre un error, muestra excepciones personalizadas.
                System.out.println(e.getMessage());
            } catch(IllegalArgumentException e){ // Para excepciones genéricas.
                System.out.println("Dato invalido: " + e.getMessage());
            }

            System.out.println(); // Imprime línea en blanco entre operaciones.
        } while (opcion != 6); // Mientras se seleccione una opción de 6.

        scDisc.close(); // Cierra el recurso.
    }
}