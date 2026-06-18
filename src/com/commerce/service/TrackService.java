package com.commerce.service;

import java.util.ArrayList;
import java.util.List;

import com.commerce.exception.ErrorTrackNoExiste;
import com.commerce.model.Track;
import com.commerce.util.Validador;

/* Contiene la lógica de negocio de sistema. Asigna id, realiza validaciones y el CRUD. */
public class TrackService {
    // Propiedades del servicio.
    private List<Track> tracks = new ArrayList<>(); // Almacena la lista de temas. Emula la B.D.
    private static int contId = 1; // Contador de ids para los nuevos temas.

    // Métodos del servicio.

    public void valCamForm(Track track){ // Valida los campos del tema.
        // Validación del número de track.
        Validador.valCamInt(track.getPista(), "El campo Pista no puede estar vacío."); // Verifica que el campo no esté vacío.
        Validador.valStock(track.getPista(), "No se permiten números negativos. Debe ingresar un número positivo."); // Valida que el número de pista sea positivo o 0.

        // Validación del título del tema.
        Validador.valCampTex(track.getNombre(), "El campo Nombre no puede estar vacío"); // Validad que el campo no esté vacío
        Validador.valTexto(track.getNombre(), "No se permiten caracteres especiales."); // Verifica que no se ingrese caracteres especiales.

        // Validación del tiempo de duración del tema.
        Validador.valCampTex(track.getDuracion(), "El campo Duración no puee estar vacío."); // Verifica que el campo no esté vacío.
        Validador.valDuracion(track.getDuracion(), "El formato es incorrecto. Debe ser mm:ss"); // Verifica el formato del tiempo.

        // Validación del nombre del compositor o autor del tema.
        Validador.valCampTex(track.getCompositor(), "El campo Autor no debe estar vacío."); // Verifica que el campo no esté vacío.
        Validador.valTexto(track.getCompositor(), "No se permiten caracteres especiales."); // Verifica que no se ingresen caracteres especiales.

        // Validación del texto de la letra del tema.
        Validador.valCampTex(track.getLetra(), "El compo Letra no puede estar vacío"); // Verifica que el campo no esté vacío.
        Validador.valTexto(track.getLetra(), "No se permiten caracteres especiales."); // Verifica que no se ingres caracteres especiales.
        
    }

    public Track nuevoTrack(Track track){ // Crea un nuevo tema.
        valCamForm(track); // Valida los campos del nuevo disco.
        track.setId(contId); // Asigna el Id al nuevo tema.
        contId++; // Incrementa el id. 
        tracks.add(track); // Almacena el nuevo tema en la B.D.
        return track; // Retorna el nuevo tema creado.
    }

    public List<Track> listarTracks(){ // Buscar todos los temas.
        return tracks; // Retorna toda la lista de temas.
    }

    public Track buscarTrack(int id){ // Busca un tema específico.
        for(Track track : tracks){ // Recorre toda la lista de temas.
            if(track.getId() == id){ // Cuando encuentra el tema por su id.
                return track; // Retorna dicho tema.
            }
        }
        throw new ErrorTrackNoExiste("No se encontró el tema con ID: " + id); 
    }

    public Track actualizarTrack(int id, Track datos){ // Actualiza los datos de un tema.
        Track track = buscarTrack(id); // Busca el tema por id y lo almacena.
        valCamForm(datos); // Valida los datos del formulario actualizar datos del tema.

        // Actualiza los nuevos datos sobre el tema en cuestión.
        track.setPista(datos.getPista()); // Actualiza el número de pista.
        track.setNombre(datos.getNombre()); // Actualiza el nombre del tema.
        track.setDuracion(datos.getDuracion()); // Actualiza la nueva duración.
        track.setCompositor(datos.getCompositor()); // Actualiza el nombre del compositor.
        track.setLetra(datos.getLetra()); // Atualiza la letra del tema.

        return track; // Retorna el tema actualizado.
    }

    public void eliminarTrack(int id){ // Elimina un tema.
        Track track = buscarTrack(id); // Busca el tema por id.
        tracks.remove(track); // Elimina el tema de la B.D.
    }
    
}