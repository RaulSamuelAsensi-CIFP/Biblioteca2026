/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fhu86918.educastur.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Clase
 */
public class Prestamo {
      private static ArrayList <PrestamosHist> prestamosHist=new ArrayList();

    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Usuario UsuarioPrestamo;
    private Libro libroPrestamo;

    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Usuario usuarioPrest, Libro libroPrest) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.UsuarioPrestamo = usuario;
        this.libroPrestamo = libro;
    }
    
    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }
        public Libro getLibro() {
            return libro;
        }
        public void setLibro(Libro libro) {
            this.libro = libro;
        }

        public Usuario getUsuario() {
            return usuario;
        }
        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public LocalDate getFechaPrestamo() {
            return fechaPrestamo;
        }
        public void setFechaPrestamo(LocalDate fechaPrestamo) {
            this.fechaPrestamo = fechaPrestamo;
        }

        public LocalDate getFechaDevolucion() {
            return fechaDevolucion;
        }

        public void setFechaDevolucion(LocalDate fechaDevolucion) {
            this.fechaDevolucion = fechaDevolucion;
        }

        public Usuario getUsuarioPrestamo() {
            return UsuarioPrestamo;
        }       
        public void setUsuarioPrestamo(Usuario UsuarioPrestamo) {
            this.UsuarioPrestamo = UsuarioPrestamo;
        }   

        public Libro getLibroPrestamo() {
            return libroPrestamo;
        }
        public void setLibroPrestamo(Libro libroPrestamo) {
            this.libroPrestamo = libroPrestamo;
        }


    

    
        

    @Override
    public String toString() {
        return "Préstamo del libro: " + libro.getTitulo()+ "; al usuario: " + usuario.getNombre() +
               ", desde " + fechaPrestamo + " hasta " + fechaDevolucion;
    }

}


