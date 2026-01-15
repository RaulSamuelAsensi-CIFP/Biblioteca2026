package com.fhu86918.educastur.biblioteca;

import java.util.ArrayList;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Clase
 */
    
    public class PrestamosHist {
      private static ArrayList <Prestamo> prestamos=new ArrayList();

    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Usuario UsuarioPrestamo;
    private Libro libroPrestamo;
    
    public PrestamosHist(Libro libro, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.UsuarioPrestamo = UsuarioPrestamo;
        this.libroPrestamo = libroPrestamo;    
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
            return "Préstamo de " + libro.getTitulo()+ " a " + usuario.getNombre() +
                   ", desde " + fechaPrestamo + " hasta " + fechaDevolucion;
        }
    }
