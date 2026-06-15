package com.commerce.model;

/* Representa a un tema de una lista de temas de un disco */

public class Track {
    // Propidedes de un tema.
    private int id;
    private int pista; // Número de tema dentro de la lista.
    private String nombre; // Nombre del tema.
    private String duracion; // Tiempo de duración del tema.
    private String compositor; // Autor del tema.
    private String letra; // Letra de la canción.

    // Métodos de un tema.
    public Track(int pista, String titulo, String tiempo, String autor, String letra){
        this.pista = pista;
        this.nombre = titulo;
        this.duracion = tiempo;
        this.compositor = autor;
        this.letra = letra;
    }

    // Métodos accesores.
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getPista(){
        return this.pista;
    }
    public void setPista(int pista){
        this.pista = pista;
    }

    public String getNombre(){
        return this.nombre;
    } 
    public void setNombre(String titulo){
        this.nombre = titulo;
    }

    public String getDuracion(){
        return this.duracion;
    }
    public void setDuracion(String tiempo){
        this.duracion = tiempo;
    }

    public String getCompositor(){
        return this.compositor;
    } 
    public void setCompositor(String autor){
        this.compositor = autor;
    }

    public String getLetra(){
        return this.letra;
    }
    public void setLetra(String letra){
        this.letra = letra;
    }

    @Override
    public String toString(){
        return "[ " + this.id +
               " - " + this.pista +
               " - " + this.nombre +
               " - " + this.duracion +
               " - " + this.compositor +
               " - " + this.letra +
               " ]";
    }
}
