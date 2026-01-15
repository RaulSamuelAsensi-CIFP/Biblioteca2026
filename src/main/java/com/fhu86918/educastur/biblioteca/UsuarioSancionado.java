/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fhu86918.educastur.biblioteca;

/**
 *
 * @author 1dawd
 */

public class UsuarioSancionado extends Exception {
        public UsuarioSancionado(String cadena){
                    super(cadena); //Llama al contructor de Exception y le pasa el contenido
    }
}
