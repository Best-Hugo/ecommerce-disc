package com.commerce.service;



import java.util.ArrayList;
import java.util.List;

import com.commerce.exception.ErrorDiscNoExiste;
import com.commerce.model.Disc;
import com.commerce.util.Validador;

/* Contiene la lógica de negocio de sistema. Asigna id, realiza validaciones y el CRUD. */
public class DiscService {
    // Propiedades del servicio.
    private List<Disc> discs = new ArrayList<>(); // Almacena la lista de discos. Emula la B.D.
    private static int contId = 1; // Contador de ids para los nuevos discos.

    // Métodos del servicio.

    public void valCamFor(Disc disco){ // Valida los datos del disco.
        // Validar nombre del disco.
        Validador.valCampTex(disco.getTitulo(), "El campo título no puedes estar vacío."); // Verifica que no esté vacío.
        Validador.valTexto(disco.getTitulo(), "No se permiten caracteres especiales."); // Verifica que no se ingrese caracteres especiales.

        // Validar URL de la imagen de la tapa.
        Validador.valCampTex(disco.getImgFront(), "Debe ingresar la tapa del disco."); // Verifica que el campo no esté vacío.
        Validador.valUrl(disco.getImgFront(), "Debe ingresar una imagen permitida, png, jpg o jpeg."); // Valida el tipo de archivo o extensión. 

        // Validar URL de la imagen de la contra tapa.
        Validador.valCampTex(disco.getImgBack(), "Debe ingresar la contra tapa del disco."); // Verifica que el campo no esté vacío.
        Validador.valUrl(disco.getImgFront(), "Debe ingresar una imagen permitida, png, jpg o jpeg."); // Valida el tipo de archivo o extensión. 
        
        // Validar URL de la imagen del disco.
        Validador.valCampTex(disco.getImgDisc(), "Debe ingresar la imagen del disco."); // Verifica que el campo no esté vacío.
        Validador.valUrl(disco.getImgDisc(), "Debe ingresar una imagen permitida, png, jpg o jpeg."); // Valida el tipo de archivo o extensión. 
        
        // Valida el nombre de la productora.
        Validador.valCampTex(disco.getProductor(), "El campo Productor no puedes estar vacío."); // Verifica que no esté vacío.
        Validador.valTexto(disco.getProductor(), "No se permiten caracteres especiales."); // Verifica que no se ingrese caracteres especiales.

        // Valida el nombre de la banda.
        Validador.valCampTex(disco.getGrupo(), "El campo Grupo no puedes estar vacío."); // Verifica que no esté vacío.
        Validador.valTexto(disco.getGrupo(), "No se permiten caracteres especiales."); // Verifica que no se ingrese caracteres especiales.

        // Valida el año de edición.
        Validador.valCampTex(disco.getAnio(), "El campo Año no puedes estar vacío."); // Verifica que no esté vacío.
        Validador.valAnio(disco.getAnio(), "Formato de fecha incorrecto, debe ser del tipo dd/mm/yyyy."); // Verifica el formato del año.

        // Valida la lista de temas. 
        // Se valida en la clase TrackService

        // Valida el texto de la descripción del disco.
        Validador.valCampTex(disco.getDescripcion(), "El campo Descripción no puedes estar vacío."); // Verifica que no esté vacío.
        Validador.valTexto(disco.getDescripcion(), "No se permiten caracteres especiales."); // Verifica que no se ingrese caracteres especiales.

        // Valida el precio del disco.
        Validador.valCamNum(disco.getPrecio(), "El campo Precio no puede estar vacío. "); // Verifica que no esté vacío.
        Validador.valPrecio(disco.getPrecio(), "No se permiten números negativos o nulos."); // Valida que el precio sea positivo o 0.

        // Valida la cantidad de copias del disco.
        Validador.valCamInt(disco.getStock(), "El campo Stock no puede estar vacío."); // Verifica que no esté vacío.
        Validador.valStock(disco.getStock(), "No se permiten números negativos. Debe ingresar un número entero."); // Valida que sea un número entero positivo.

        // Valida el genero del disco.
        Validador.valCampTex(disco.getCategoria(), "El campo Categoría no puedes estar vacío."); // Verifica que no esté vacío.
        Validador.valTexto(disco.getCategoria(), "No se permiten caracteres especiales."); // Verifica que no se ingrese caracteres especiales.

    }

    public Disc nuevoDisc(Disc disco){ // Crea un nuevo disco.
        valCamFor(disco); // Validar los datos del formulario.
        disco.setId(contId); // Asigna el id al nuevo disco.
        contId++; // Incrementa el id.
        discs.add(disco); // Almacena el nuevo disco en la B.D.

        return disco; // Retorna el nuevo disco.
    }

    public List<Disc> listarDiscs(){ // Busca todos los discos.
        return discs; // Retorna toda la lista de discos.
    }

    public Disc buscarDisc(int id){ // Busca un disco en particular, si no lo encuentra arroja una excepción.
        for(Disc disco : discs){ // Recorre toda la lista de discos.
            if(disco.getId() == id){ // Cuando encuentre el disco por su id.
                return disco; // retrona dicho disco.
            }
        }
        throw new ErrorDiscNoExiste("No se encontró el disco con id: "+ id); // Muestra un mensaje de error.
    }

    public Disc actualizarDisc(int id, Disc datos){ // Acutaliza los datos de un disco.
        Disc disco = buscarDisc(id); // Busca el disco por id y lo almacena.
        valCamFor(datos); // Valida los datos del formulario para los datos modificados.

        // Actualiza los nuevos datos sobre el disco en cuestión.
        disco.setTitulo(datos.getTitulo());
        disco.setImgFront(datos.getImgFront());
        disco.setImgBack(datos.getImgBack());
        disco.setImgDisc(datos.getImgDisc());
        disco.setProductor(datos.getProductor());
        disco.setGrupo(datos.getGrupo());
        disco.setAnio(datos.getAnio());
        disco.setDescripcion(datos.getDescripcion());
        disco.setPrecio(datos.getPrecio());
        disco.setStock(datos.getStock());
        disco.setCategoria(datos.getCategoria());

        return disco;
    }

    public void eliminarDisc(int id){ // Elimina un disco.
        Disc disco = buscarDisc(id); // Busca el disco por id.
        discs.remove(disco); // Elimina el disco de la B.D.
    }
    
}