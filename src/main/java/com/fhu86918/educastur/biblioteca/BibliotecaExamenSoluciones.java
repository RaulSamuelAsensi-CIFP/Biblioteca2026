/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fhu86918.educastur.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 1dawd
 */
public class BibliotecaExamenSoluciones {
    
    static Scanner sc = new Scanner(System.in);
    static List<Libro> libros = new ArrayList<>();
    static List<Prestamo> prestamos = new ArrayList<>();
    static List<Prestamo> prestamosHist = new ArrayList<>();
    static List<Usuario> usuarios = new ArrayList<>();
    
    public static void uno() {
        System.out.print("ISBN LIBRO para consultar prestamos: ");
        String isbn = sc.next();
        int pos = buscaIsbn(isbn);
        if (pos == -1) {
            System.out.println("Ese ISBN no existe en la biblioteca");
        } else {
            System.out.println("Prestamos activos de el libro:  " + libros.get(pos).getTitulo());
            int contador = 0;
            for (Prestamo p : prestamos) {
                if (p.getLibroPrest().equals(libros.get(isbn))) {
                    System.out.println(p);
                    contador++;
                }
            }
            System.out.println("\n" + libros.get(pos).getTitulo() + " tiene " + contador + " prestamos actualmente");
        }
    }

    public static void dos() {
        System.out.println("\nLibros NUNCA prestados:\n");
        for (Libro l : libros) {
            int cont=0;
            for (Prestamo p : prestamos) {
                if (p.getLibroPrest() == l) {
                    cont++;
                    break;
                }
            }
            if (cont==0){
                for (Prestamo p : prestamosHist) {
                    if (p.getLibroPrest() == l) {
                        cont++;
                        break;
                    }
                }
            }
            if (cont==0) {
                System.out.println(l);
            }
        }
    }

    public static void tres() {
        System.out.println("Usuarios que tiene al menos 1 prestamo ACTIVO:\n"); 
        for(Usuario u : usuarios) {
            int cont=0;
            for(Prestamo p : prestamos) {
                    if(p.getUsuarioPrest() == u) {
                        cont++;
                        break;
                    }
            }
            if (cont>0){
               System.out.println(u.getNombre());
            }
	}
    }

    public static void cuatro() {
         /* Se podría resolver con un contador (cont) al igual que los ejercicios
            anteriores, pero en este caso utilizamos una variable booleana (true/false).
            Es otra forma de resolver la lógica de este tipo de ejercicios
         */
        System.out.println("Usuarios que tiene PRESTAMOS FUERA DE PLAZO:\n"); 
        for(Usuario u : usuarios) {
            boolean tieneFueraPlazo = false;
            for(Prestamo p : prestamos) {
                    if(p.getUsuarioPrest().equals(u) && p.getFechaDev().isBefore(LocalDate.now())) {
                        tieneFueraPlazo = true;
                        break;
                    }
            }
            if(tieneFueraPlazo == true) {
                    System.out.println(u);
            }
	}
    }

    public static void cinco() {
        System.out.println("PRESTAMOS realizados en el mes de NOVIEMBRE:\n"); 
        for(Prestamo p : prestamos) {
            if(p.getFechaPrest().getMonthValue()==11) {// 11 es noviembre, getMonthValue devuelve el mes en formato numérico
                System.out.println(p);
            }
        }
        for(Prestamo p : prestamosHist) {
            if(p.getFechaPrest().getMonthValue()==11) {
                System.out.println(p);
            }
        }
    }
    
    
    
}
