/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fhu86918.educastur.biblioteca;

/**
 *
 * @author Clase
 */

public class Libro {
    private String Isbn;
    private String titulo;
    private String autor;
    private String genero;
    private int ejemplares;

        public Libro (String id, String titulo, String autor, String genero, int ejemplares) {
            this.Isbn = Isbn;
            this.titulo = titulo;
            this.autor = autor;
            this.genero = genero;
            this.ejemplares = ejemplares;
        }

        public String getIsbn() {
            return Isbn;
        }

        public void setIsbn(String Isbn) {
            this.Isbn = Isbn;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public int getEjemplares() {
            return ejemplares;
        }

        public void setEjemplares(int ejemplares) {
            this.ejemplares = ejemplares;
        }
        
        
        
    @Override
    public String toString() {
        return Isbn + "-" + titulo + "-" + autor + "-" + genero + "-" + ejemplares;
    }        

}  
