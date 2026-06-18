package com.commerce.model;

import java.util.List;
/* Representa un disco del catálogo. */
public class Disc {
    // Propiedades de disc
    private int id;
    private String titulo; // Nombre del disco.
    private String imgFront; // Url de la imagen de la tapa.
    private String imgBack; // Url de la imagen de la contra tapa.
    private String imgDisc; // Url de la imagen del disco.
    private String productor; // Empresa productora. EMI, Poligram, etc.
    private String grupo; // Nombre de la banda.
    private String anio; // Año de edición.
    private List<Track> tracks; // Lista de temas del disco.
    private String descripcion; // Descripción del disco.
    private double precio; // Pecio del disco.
    private int stock; // Cantidad de copias.
    private String categoria;  // Genero del disco. Ej.: Rock, Heavy meta, etc.

    // Métodos de disc.
    public Disc(){
        // Constructor sin valores, útil para Spring/JPA
    }

    public Disc(String tit, String front, String back, String disc, String prod, String grup, String anio, List<Track> list, String desc, double prec, int stoc, String cat){
        this.titulo = tit;
        this.imgFront = front;
        this.imgBack = back;
        this.imgDisc = disc;
        this.productor = prod;
        this.grupo = grup;
        this.anio = anio;
        for(Track track : list){
            this.tracks.add(track);
        }
        this.descripcion = desc;
        this.precio = prec;   
        this.stock = stoc;
        this.categoria = cat;
    }

    // Métodos accesores.

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String tit) {
        this.titulo = tit;
    }

    public String getImgFront(){
        return this.imgFront;
    }
    public void setImgFront(String front){
        this.imgFront = front;
    }

    public String getImgBack(){
        return this.imgBack;
    }
    public void setImgBack(String back) {
        this.imgBack = back;
    }

    public String getImgDisc(){
        return this.imgDisc;
    }
    public void setImgDisc(String disc){
        this.imgDisc = disc;
    }

    public String getProductor(){
        return this.productor;
    }
    public void setProductor(String prod){
        this.productor = prod;
    }

    public String getGrupo(){
        return this.grupo;
    }
    public void setGrupo(String grupo){
        this.grupo = grupo;
    }

    public String getAnio(){
        return this.anio;
    }
    public void setAnio(String anio){
        this.anio = anio;
    }

    public List<Track> getTracks(){
        return this.tracks;
    }
    public void setTracks(List<Track> list){
        this.tracks = list;
    }

    public String getDescripcion(){
        return this.descripcion;
    }
    public void setDescripcion(String desc){
        this.descripcion = desc;
    }

    public double getPrecio(){
        return this.precio;
    }
    public void setPrecio(double prec){
        this.precio = prec;
    }

    public int getStock(){
        return this.stock;
    }
    public void setStock(int stoc){
        this.stock = stoc;
    }

    public String getCategoria(){
        return this.categoria;
    }
    public void setCategoria(String cat){
        this.categoria = cat;
    }

    // Método que muestra resultado por consola.
    @Override
    public String toString(){
        return "ID: " + this.id +
               " | " + this.titulo +
               " | Tapa: " + this.imgFront +
               " | Contratapa: " + this.imgBack +
               " | Disco: " + this.imgDisc +
               " | Productor" + this.productor +
               " | Grupo: " + this.grupo +
               " | Edición: " + this.anio +
               " | Temas: " + this.tracks +
               " | Descripción" + this.descripcion +
               " | $ " + this.precio +
               " | Stock: " + this.stock +
               " | Categoría: " + this.categoria;  
    }
}