/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fhu86918.educastur.biblioteca;

/**
 *
 * @author 1dawd
 */

public class LibroNoDisponible extends Exception {//El método extension sirve para las herencias en Java, para que cualquier excepción de Java la pueda utilizar también la mía, en este caso LibroNoDisponible
    public LibroNoDisponible(String cadena){
                    super(cadena);//Llama al contructor de Exception y le pasa el contenido
    }
}
