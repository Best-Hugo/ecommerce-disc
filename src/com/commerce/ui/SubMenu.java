package com.commerce.ui;

import java.util.Scanner;
import java.util.List;

//import com.commerce.model.Disc;
import com.commerce.model.Track;
import com.commerce.service.TrackService;
import com.commerce.util.Validador;

/* Interactua con el usuario a través del submenu de tema. */
public class SubMenu {
    // Propiedades de la clase.
    private final Scanner sc;
    private final TrackService service;

    // Métodos de la clase.
    private Track valDatCmd(){ // Valida los datos ingresados por consola.
        int pista = Validador.leeEntero(sc, "Pista: ");
        String nom = Validador.leeTexto(sc, "Nombre del tema: ");
        String dur = Validador.leeTexto(sc, "Duración: ");
        String comp = Validador.leeTexto(sc, "Autor: ");
        String let = Validador.leeTexto(sc, "Letra: ");

        Track track = new Track(pista, nom, dur, comp, let); // Crea una instancia de un tema.
        return track;
    }

    public SubMenu(Scanner scan, TrackService serv){ // Constructor de la clase.
        this.sc = scan;
        this.service = serv;
    }

    public void mostrarSubMenu(){ // Sub menú.
        System.out.println("===== ServerDisc - Gestión de temas =====");
        System.out.println("1) Agregar un tema.");
        System.out.println("2) Listar todos los temas.");
        System.out.println("3) Buscar tema por ID.");
        System.out.println("4) Actualizar tema.");
        System.out.println("5) Eliminar tema.");
        System.out.println("6) Salir.");
        System.out.println("=========================================");
    }

    public void crearTrack(){ // Crea y almacena un nuevo tema a la B.D.
        System.out.println("--- Nuevo tema ---"); // Muestra encabezado.
        Track track = valDatCmd(); // Valida los datos ingresados por consola.
        Track newTrack = service.nuevoTrack(track); // Almacena el nuevo tema en la B.D.
        System.out.println("✔ El tema " + newTrack.getNombre() + " se creó correctamente.");
    }

    public void mostrarTemas(){ // Visualiza todos los temas de la B.D.
        List<Track> tracks = service.listarTracks(); // Obtiene todos los temas de la B.D.

        if(tracks.isEmpty()){ // Si la lista está vacía.
            System.out.println("No hay temas cargados en la B.D.");
        }

        System.out.println("--- Catálogo de temas ---"); // Muestra encabezado.
        for(Track tema : tracks){ // Recorre toda la lista de temas.
            System.out.println(tema); // Java, automáticamente invoca al método toStrign() de track.
        }
    }

    public void buscarTema(){ // Visualiza un tema en particular.
        int id = Validador.leeEntero(sc, "Ingrese el ID del tema: "); // Muetra diálogo.
        Track track = service.buscarTrack(id); // Busca el tema por id.
        System.out.println("Encontrado: " + track);
    }

    public void actualizarTema(){ // Actualiza los datos de un tema en particular.
        int id = Validador.leeEntero(sc, "Ingrese el ID del tema a modificar."); // Muestra diálogo.
        Track traAct = service.buscarTrack(id); // Obtiene el disco en cuestión.
        System.out.println("Tema actual: " + traAct); // Visualiza los datos del tema en cuestrión.

        System.err.println("--- Ingrese los nuevos datos del tema ---"); // Muestra diálogo.
        Track track = valDatCmd(); // Valida los datos ingresados por consola.
        Track traMod = service.actualizarTrack(id, track); // Actualiza los datos en la B.D.
        System.out.println("Tema actualizado: " + traMod); // Visualiza los cambios.
    }

    public void eliminarTema(){ // Elimina un tema de la B.D.
        int id = Validador.leeEntero(sc, "Ingrese el ID del tema a eliminar: "); // Muestra diálogo.
        service.eliminarTrack(id); // Elimina el tema de la B.D.
        System.out.println("✔ Tema, con ID: " + id + ", se eliminó correctamente."); // Confirmación de acción.
    }

}