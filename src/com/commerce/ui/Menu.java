package com.commerce.ui;

import java.util.Scanner;
import java.util.List;

import com.commerce.model.Disc;
import com.commerce.service.DiscService;
import com.commerce.util.Validador;

/* Interactua con el usuario a través del menú de disco. */
public class Menu {
    // Propiedades de la clase

    private final Scanner sc; 
    private final DiscService service; 

    // Método de la clase.
    public Disc valDatCmd(){ // Valida los datos ingresados por consola.
        String tit = Validador.leeTexto(sc, "Título: ");
        String front = Validador.leeTexto(sc, "Tapa: ");
        String back = Validador.leeTexto(sc, "Contra tapa: ");
        String disc = Validador.leeTexto(sc, "Disco: ");
        String prod = Validador.leeTexto(sc, "Productora: ");
        String gru = Validador.leeTexto(sc, "Grupo: ");
        String anio = Validador.leeTexto(sc, "Año: ");
        String desc = Validador.leeTexto(sc, "Descripción: ");
        double prec = Validador.leeDouble(sc, "Precio: ");
        int stoc = Validador.leeEntero(sc, "Stock: ");
        String cate = Validador.leeTexto(sc, "Categoría: ");
        
        Disc disco = new Disc(tit, front, back, disc, prod, gru, anio, desc, prec, stoc, cate); // Crea una instancia de un disco.
        return disco;
    }

    public Menu(Scanner scan, DiscService serv){ // Contructor de la clase.
        this.sc = scan;
        this.service = serv;
    }

    public void mostrarMenu(){ // Menú principal.
        System.out.println("===== ServerDisc - Gestión de discos =====");
        System.out.println("1) Agregar un disco.");
        System.out.println("2) Listar todos los discos.");
        System.out.println("3) Buscar disco por ID.");
        System.out.println("4) Actualizar disco.");
        System.out.println("5) Eliminar disco.");
        System.out.println("6) Salir.");
        System.out.println("==========================================");
    }

    public void crearDisco(){ // Crea y agrega un nuevo disco a la B.D.
        System.out.println("--- Nuevo disco ---");
        Disc disco = valDatCmd(); // Valida el ingreso por consola.
        
        Disc newDisc = service.nuevoDisc(disco); // Almacena el nuevo discon en la B.D.
        System.out.println("✔ El disco " + newDisc.getTitulo() + ", se creó correctamente.");
    }

    public void mostrarDiscos(){ // Visualiza todos los discos de la B.D.
        List<Disc> discs = service.listarDiscs(); // Obtiene todos los discos de la B.D.  

        if(discs.isEmpty()){ // Si la lista está vacía.
            System.out.println("No hay discos cargados en la B.D.");
        }

        System.out.println("--- Catálogo de discos ---");
        for(Disc disc : discs){ // Recorre toda la lista de discos.
            System.out.println(disc); // Java, automáticamente invoca al método toString() de disc.
        }
    }

    public void buscarDisco(){ // Visualiza un disco en particular.
        int id = Validador.leeEntero(sc, "Ingrese el ID del disco: "); // Muestra diálogo.
        Disc disc = service.buscarDisc(id); // Busca el disco por id.
        System.out.println("Encontrado: " + disc);
    }

    public void actualizarDisco(){ // Actualiza los datos de un disco.
        int id = Validador.leeEntero(sc, "Ingrese el ID del disco a actualizar: "); // Muestra diálogo.
        Disc disAct = service.buscarDisc(id); // Obtiene el discon en cuestión.
        System.out.println("Disco actual: " + disAct); // Visualiza los datos del disco en cuestión.

        System.out.println("--- Ingrese los nuevos datos del disco ---"); // Muestra diálogo.
        Disc disco = valDatCmd(); // Valida los datos ingresados por consola.
        Disc disMod = service.actualizarDisc(id, disco); // Actualiza los datos
        System.out.println("Disco actualizado: " + disMod); // Muestra mensaje.
    }

    public void eliminarDisco(){ // Elimina un disco de la B.D.
        int id = Validador.leeEntero(sc, "Ingrese el ID del disco a eliminar: "); // Muestra diálogo.
        service.eliminarDisc(id); // Elimina el disco de la B.D.
        System.out.println("✔ Disco, con ID: " + id + ", se eliminó correctamente."); // Confirmación de borrado.
    }
}
