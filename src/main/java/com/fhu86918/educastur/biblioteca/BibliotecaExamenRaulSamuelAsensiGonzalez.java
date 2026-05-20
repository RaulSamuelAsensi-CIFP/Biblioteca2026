/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fhu86918.educastur.biblioteca;

/**
 *
 * @author 1dawd
 */
public class BibliotecaExamenRaulSamuelAsensiGonzalez {
        public static void uno () {
        
        System.out.print("Isbn Libro para consultar prestamos:");
        String isbn=sc.next();
        int pos=buscaLibro(isbn);
        if (pos==-1){
            System.out.println("Ese libro no existe en la biblioteca"); 
        }else{
            System.out.println("Prestamos activos de " + libros.get(pos).getTitulo());
            int cuentaActivos=0;
            for (Prestamo p : prestamos) {
                if(p.getLibroPrestamo().equals(usuarios.get(pos))){
                    System.out.println(p);
                    cuentaActivos++;
                }
            }
            System.out.println(libros.get(pos).getTitulo() + " tiene " + cuentaActivos + " prestamos actualmente");
            
            libros.get(pos).getTitulo();
            prestamos.get(pos).getUsuarioPrestamo();
            prestamos.get(pos).getFechaPrestamo();
            prestamos.get(pos).getFechaDevolucion();
            usuarios.get(pos)
            
    }
}
    public static void dos() {
        
    }

    public static void tres() {
        
    }

    public static void cuatro() {
        
    }

    public static void cinco() {
        
    }

}
