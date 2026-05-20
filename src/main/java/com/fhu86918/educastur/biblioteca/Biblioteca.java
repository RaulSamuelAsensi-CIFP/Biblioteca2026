/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.fhu86918.educastur.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

        
/**
 *
 * @author Clase
 */
public class Biblioteca { private static Scanner sc = new Scanner(System.in);
    
    private ArrayList<Libro> libros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
private ArrayList<Prestamo> prestamosHist = new ArrayList<>();
    private Object isbn;

    public Biblioteca(){
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.prestamosHist = new ArrayList<>();

    
}
     public static void main(String[] args) {
            Biblioteca b = new Biblioteca();
                b.cargaDatos();
                b.menuPrincipal();
            }
    public void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Gestion de Libros");
            System.out.println("2. Gestion de Usuarios");
            System.out.println("3. Gestion de Prestamos");
            System.out.println("4. Listados");
            System.out.println("5. Streams");
            System.out.println("9. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    menuLibros();
                    break;
                case 2:
                    menuUsuarios();
                    break;
                case 3:
                    menuPrestamos();
                    break;
                case 4:
                    menuListados();
                    break;
                case 5:
                    menuStreams();
            }
        } while (opcion != 9);
        sc.close();
    }

    public void menuLibros() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU LIBROS ---");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Eliminar Libro");
            System.out.println("3. Modificar Libro");
            System.out.println("4. Lista de Libros");
            System.out.println("9. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    nuevoLibro();
                    break;
                case 2:
                    eliminarLibro();
                    break;
                case 3:
                    modificarLibro();
                    break;
                case 4:
                    listaLibro();
                    break;
            }
        } while (opcion != 9);
    }

    public void menuUsuarios() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU USUARIOS ---");
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Eliminar Usuario");
            System.out.println("3. Modificar Usuario");
            System.out.println("4. Lista de Usuarios");
            System.out.println("9. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    nuevoUsuario();
                    break;
                case 2:
                    eliminarUsuario();
                    break;
                case 3:
                    modificarUsuario();
                    break;
                case 4:
                    listaUsuario();
                    break;
            }
        } while (opcion != 9);
    }
    public void menuPrestamos() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU PRESTAMOS ---");
            System.out.println("1. Agregar Prestamo");
            System.out.println("2. Devolver Prestamo");
            System.out.println("3. Prorrogas");
            System.out.println("4. Listar Prestamos");
            System.out.println("9. Salir");
            opcion = sc.nextInt();
            try{
                switch (opcion) {
                    case 1:
                        nuevoPretamo();
                        break;
                    case 2:
                        devolucionPrest();
                        break;
                    case 3:
                        prorrogaPrest();
                        break;
                    case 4:
                        listaPrestamo();
                        break;
                }
        } catch(LibroNoExiste e){
            System.out.println(e.getMessage());
            
        } catch(LibroNoDisponible e){
           System.out.println(e.getMessage());
           
        }
        } while (opcion != 9);
    }
    public void menuListados() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU LISTADOS ---");
            System.out.println("1. Listado genreral de Prestamos");
            System.out.println("2. Listado prestamos usuario");
            System.out.println("3. Listado prestamos libros (usuarios que lo leen)");
            System.out.println("4. Libro mas leido");
            System.out.println("5. Usuario mas lector");
            System.out.println("9. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    listaPrestamo();
                    break;
                case 2:
                    listaPrestamosUsu();
                    break;
                case 3:
                    listaPrestamosLibro();
                    break;
                case 4:
                    libroMasLeido();
                    break;
                case 5:
                    usuarioMasLector();
                    break;

            }
        } while (opcion != 9);
    }
    public void menuStreams() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU LISTADOS ---");
            System.out.println("1. Listados");
            System.out.println("2. Ordenaciones");
            System.out.println("9. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    listadosStreams();
                    break;
                case 2:
                    ordenacionesStreams();
                    break;
            }
        } while (opcion != 9);
    }

    private void nuevoLibro() {
       Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el isbn del libro:");
        String isbn = sc.nextLine();
        System.out.println("Introduce el titulo del libro:");
        String titulo = sc.nextLine();
        System.out.println("Introduce el autor del libro:");
        String autor = sc.nextLine();
        System.out.println("Introduce el genero del libro:");
        String genero = sc.nextLine();
        System.out.println("Introduce el numero de ejemplares:");
        int ejemplares = sc.nextInt();
        libros.add(new Libro(isbn, titulo, autor, genero, ejemplares));
        System.out.println("Libro agregado correctamente.");
    }

    private void eliminarLibro() {
         Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el isbn del libro a eliminar:");
        String isbn = sc.nextLine();
        int pos = buscaIsbn(isbn);
        if (pos != -1) {
            libros.remove(pos);
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.out.println("El libro no existe.");
        }
    }

    private void modificarLibro() {
         Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el isbn del libro a modificar:");
        String isbn = sc.nextLine();
        int pos = buscaIsbn(isbn);
        if (pos != -1) {
            Libro libro = libros.get(pos);

            System.out.println("Introduce el nuevo titulo (actual: " + libro.getTitulo() + "):");
            libro.setTitulo(sc.nextLine());
            System.out.println("Introduce el nuevo autor (actual: " + libro.getAutor() + "):");
            libro.setAutor(sc.nextLine());
            System.out.println("Introduce el nuevo genero (actual: " + libro.getGenero() + "):");
            libro.setGenero(sc.nextLine());

            System.out.println("Libro modificado correctamente.");
        } else {
            System.out.println("ISBN no encontrado.");
        }
    }

    private void listaLibro() {
        for (Libro l : libros) {
            System.out.println(l);
        }
    }

    private void nuevoUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el DNI del usuario:");
        String dni = sc.nextLine();
        System.out.println("Introduce el nombre del usuario:");
        String nombre = sc.nextLine();
        System.out.println("Introduce el email del usuario:");
        String email = sc.nextLine();
        System.out.println("Introduce el telefono del usuario:");
        String telefono = sc.nextLine();
        usuarios.add(new Usuario(dni, nombre, email, telefono));
        System.out.println("Usuario agregado correctamente.");
    }

    private void eliminarUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el DNI del usuario a eliminar:");
        String dni = sc.nextLine();
        int pos = buscaDni(dni);
        if (pos != -1) {
            usuarios.remove(pos);
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    private void modificarUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el DNI del usuario a modificar:");
        String dni = sc.nextLine();
        int pos = buscaDni(dni);
        if (pos != -1) {
            Usuario usuario = usuarios.get(pos);
            System.out.println("Introduce el nuevo email (actual: " + usuario.getEmail() + "):");
            usuario.setEmail(sc.nextLine());
            System.out.println("Introduce el nuevo teléfono (actual: " + usuario.getTelefono() + "):");
            usuario.setTelefono(sc.nextLine());
            System.out.println("Usuario modificado correctamente.");
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    private void listaUsuario() {
       for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    private void nuevoPretamo() throws LibroNoDisponible, LibroNoExiste {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el DNI del usuario:");
        String dni = sc.nextLine();
        int pos = buscaDni(dni);
        if (pos == -1) {
            System.out.println("El usuario no existe.");
            return;
        }
        System.out.println("Introduce el ISBN del libro:");
        String isbn = sc.nextLine();
        int posLibro = buscaIsbn(isbn);
        if (posLibro == -1 || libros.get(posLibro).getEjemplares() <= 0) {
            throw new LibroNoExiste("El libro no existe");
          
        }
        if (libros.get(posLibro).getEjemplares() <= 0){
            throw new LibroNoDisponible("no hay ejemplares disponibles");
        }
        LocalDate hoy = LocalDate.now();
        prestamos.add(new Prestamo(libros.get(posLibro), usuarios.get(pos), hoy, hoy.plusDays(15)));
        libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares() - 1);
        System.out.println("Prestamo creado correctamente.");
    }

    private void devolucionPrest() {
         Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el DNI del usuario:");
        String dni = sc.nextLine();
        System.out.println("Introduce el ISBN del libro:");
        String isbn = sc.nextLine();
        int pos = buscaPrestamo(dni, isbn);
        if (pos == -1) {
            System.out.println("No se encontro el prestamo");
            return;
        }
 
        Prestamo p = prestamos.get(pos);
        prestamosHist.add(prestamos.get(pos));
        prestamos.remove(pos);
        p.setFechaDevolucion(LocalDate.now());
        p.getLibroPrestamo().setEjemplares(p.getLibroPrestamo().getEjemplares() + 1);
        System.out.println("Devolucion realizada correctamente");
    }

    private void prorrogaPrest() {
         Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el DNI del usuario:");
        String dni = sc.nextLine();
        System.out.println("Introduce el ISBN del libro:");
        String isbn = sc.nextLine();
        int pos = buscaPrestamo(dni, isbn);
        if (pos == -1) {
            System.out.println("No se encontro el prestamo");
            return;
        }
        Prestamo p = prestamos.get(pos);
        LocalDate fechaPrest = LocalDate.now();
        LocalDate fechaDev = fechaPrest.plusDays(15);
        p.setFechaPrestamo(fechaPrest);
        p.setFechaDevolucion(fechaDev);
        System.out.println("Prorroga realizada correctamente. Nueva fecha de inicio: " + fechaPrest + ", nueva fecha de devolucion: " + fechaDev);
    }

  

    private int buscaDni(String dni) {
      int pos = -1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDni().equals(dni)) {
                pos = i;
                break;
            }
        }
        return pos;  
    }

    private int buscaIsbn(String bn) {
      int pos = -1;
        for (int i = 0; i < usuarios.size(); i++) {
          Object isbn = null;
            if (libros.get(i).getIsbn().equals(isbn)) {
                pos = i;
                break;
            }
        }
        return pos;  
    }

    private int buscaPrestamo(String dni, String bn) {
         for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getUsuarioPrestamo().getDni().equals(dni)
                    && prestamos.get(i).getLibroPrestamo().getIsbn().equals(isbn)) {
                return i;
            }
        }
        return -1;
    }
    
      private void listaPrestamo() {
         LocalDate hoy = LocalDate.now();
        System.out.println("=== LISTADO DE PRESTAMOS ACTIVOS ===");
        if (prestamos.isEmpty()) {
            System.out.println("No hay prestamos activos");
        } else {
            for (Prestamo p : prestamos) {
                System.out.println(p);
            }
        }

        System.out.println("\n=== LISTADO DE PRESTAMOS HISTORICOS ===");
        if (prestamosHist.isEmpty()) {
            System.out.println("No hay prestamos historicos.");
        } else {
            for (Prestamo p : prestamosHist) {
                System.out.println(p);
            }
        }

        System.out.println();
        fueraPlazo();
    }

    private void listaPrestamosUsu() {
        
        String dni = solicitaDni();
        int pos = buscaDni(dni);

        if (pos == -1) {
            System.out.println("No tengo a nadie con ese DNI");
            return;
        }
        LocalDate hoy = LocalDate.now();
        Usuario u = usuarios.get(pos);
        //Activos en plazo
        System.out.println("Prestamos ACTIVOS en plazo de: " + u.getNombre());
        for (Prestamo p : prestamos) {
            if (p.getUsuarioPrestamo().getDni().equals(dni)
                    && !p.getFechaDevolucion().isBefore(hoy)) {
                System.out.println(p);
            }
        }
        //Activos fuera de plazo
        System.out.println("\nPrestamos FUERA DE PLAZO de: " + u.getNombre());
        for (Prestamo p : prestamos) {
            if (p.getUsuarioPrestamo().getDni().equals(dni)
                    && p.getFechaDevolucion().isBefore(hoy)) {
                System.out.println(p);
            }
        }
        //Ya devueltos (históricos)
        System.out.println("\nPrestamos YA DEVUELTOS por: " + u.getNombre());
        for (Prestamo p : prestamosHist) {
            if (p.getUsuarioPrestamo().getDni().equals(dni)) {
                System.out.println(p);
            }
        }
    }
    
     public String solicitaIsbn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Teclea el Isbn del libro");
        String isbn = sc.nextLine();
        return isbn;
    }
        

    private void listaPrestamosLibro() {
        String isbn = solicitaIsbn();
        int pos = buscaIsbn(isbn);
        if (pos == -1) {
            System.out.println("No tengo ningún libro con ese ISBN");
        } else {
            System.out.println("Usuarios/as que lo estan leyendo");
            for (Prestamo p : prestamos) {
                if (p.getLibroPrestamo().getIsbn().equals(isbn)) {
                    System.out.println(p.getUsuarioPrestamo());
                }
            }

            System.out.println("Usuarios/as que ya lo han leido");
            for (Prestamo p : prestamosHist) {
                if (p.getLibroPrestamo().getIsbn().equals(isbn)) {
                    System.out.println(p.getUsuarioPrestamo());
                }
            }
        }
    }

    private void libroMasLeido() {
         int max = 0;
        int pos = -1;

        for (int i = 0; i < libros.size(); i++) {
            Libro l = libros.get(i);
            int c = 0;

            for (Prestamo p : prestamos) {
                if (p.getLibroPrestamo().getIsbn().equals(l.getIsbn())) {
                    c++;
                }
            }

            for (Prestamo p : prestamosHist) {
                if (p.getLibroPrestamo().getIsbn().equals(l.getIsbn())) {
                    c++;
                }
            }

            if (c > max) {
                max = c;
                pos = i;
            }
        }

        if (max == 0) {
            System.out.println("No hay préstamos.");
        } else {
            System.out.println("Libro mas leido: '" + libros.get(pos).getTitulo() + "' con " + max + " prestamos");
        }
    }
       

    private void usuarioMasLector() {
        
    }

    private void listadosStreams() {
        libros.stream().forEach(l -> System.out.println(l));
        System.out.println("");
        libros.stream().filter(l->l.getGenero().equalsIgnoreCase("Aventuras")).forEach(System.out::println);
        System.out.println("");
        libros.stream().filter(l->l.getGenero().equalsIgnoreCase("Aventuras")).forEach(l->System.out.println(l));
        System.out.println("");
        libros.stream().filter(l->l.getGenero().equalsIgnoreCase("Aventuras") && l.getAutor().equalsIgnoreCase("JRR TOLKIEN")).forEach(System.out::println);
        System.out.println("");
        libros.stream().filter(l->l.getGenero().equalsIgnoreCase("Novela negra") || l.getAutor().equalsIgnoreCase("JRR TOLKIEN")).forEach(System.out::println);
        System.out.println("");
        
        String nombre = sc.nextLine();
        prestamos.stream().filter(p->p.getUsuarioPrestamo().getNombre().equalsIgnoreCase(nombre)).forEach(p->System.out.println(p));
        System.out.println("");
        prestamosHist.stream().filter(p->p.getUsuarioPrestamo().getNombre().equalsIgnoreCase(nombre)).forEach(p->System.out.println(p));
        System.out.println("");
        prestamos.stream().filter(p->p.getLibroPrestamo().getGenero().equalsIgnoreCase("aventuras")).forEach(p->System.out.println(p));
        System.out.println("");
    }

    private void ordenacionesStreams() {
       libros.stream().sorted().forEach(l->System.out.println(l));
        System.out.println("");
        libros.stream().sorted(Comparator.comparing(Libro::getTitulo)).forEach(l->System.out.println(l));
        System.out.println("");
        libros.stream().sorted(Comparator.comparing(Libro::getTitulo).reversed()).forEach(l->System.out.println(l));
        System.out.println("");
        libros.stream().sorted(Comparator.comparing(l->numPrestamosLibro(l.getIsbn())))
                .forEach(l->System.out.println(l + " - unidades prestadas: " + numPrestamosLibro(l.getIsbn())));
    }
     public void cargaDatos() {
        libros.add(new Libro("1-11", "El Hobbit", "JRR Tolkien", "Aventuras", 3));
        libros.add(new Libro("1-22", "El Silmarillon", "JRR Tolkien", "Aventuras", 3));
        libros.add(new Libro("1-33", "El Medico", "N. Gordon", "Aventuras", 4));
        libros.add(new Libro("1-44", "Chaman", "N. Gordon", "Aventuras", 3));
        libros.add(new Libro("1-55", "Momo", "M. Ende", "Aventuras", 2));
        libros.add(new Libro("1-66", "Paraiso inhabitado", "A.M.Matute", "Aventuras", 2));
        libros.add(new Libro("1-77", "Olvidado Rey Gudu", "A.M.Matute", "Aventuras", 0));
        libros.add(new Libro("1-88", "El ultimo barco", "D.Villar", "Novela Negra", 3));
        libros.add(new Libro("1-99", "Ojos de agua", "D.Villar", "Novela Negra", 0));
        
        usuarios.add(new Usuario("11", "Ana", "ana@email.com", "621111111"));
        usuarios.add(new Usuario("22", "David", "david@email.com", "622222222"));
        usuarios.add(new Usuario("33", "Bea", "bea@email.com", "623333333"));
        usuarios.add(new Usuario("44", "Lucas", "lucas@email.com", "624444444"));
        usuarios.add(new Usuario("55", "Carlota", "carlota@email.com", "625555555"));
        usuarios.add(new Usuario("66", "Juan", "juan@email.com", "626666666"));
        
        LocalDate hoy = LocalDate.now();
        //PRESTAMOS "NORMALES" REALIZADOS HOY Y QUE SE HAN DE DEVOLVER EN 15 DÍAS
	prestamos.add(new Prestamo(libros.get(0),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(1),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(4), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(1), hoy,hoy.plusDays(15)));
	//PRESTAMOS QUE YA TENIAN QUE HABER SIDO DEVUELTOS PORQUE SU FECHA DE DEVOLUCIÓN ES ANTERIOR A HOY
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(1), hoy.minusDays(17),hoy.minusDays(2)));
        prestamos.add(new Prestamo(libros.get(1),usuarios.get(4), hoy.minusDays(18),hoy.minusDays(3)));
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(3),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        //PRESTAMOS HISTORICOS QUE YA HAN SIDO DEVUELTOS Y POR TANTO ESTÁN EN LA COLECCION prestamosHist
	prestamosHist.add(new Prestamo(libros.get(0),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(2),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(7),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(5),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(1),usuarios.get(1), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(7),usuarios.get(2), hoy.minusDays(15),hoy));
        prestamosHist.add(new Prestamo(libros.get(6),usuarios.get(3), hoy.minusDays(15),hoy));      
    }

    private String solicitaDni() {
         Scanner sc = new Scanner(System.in);
        System.out.println("Teclea el DNI del usuario");
        String dni = sc.nextLine();
        return dni;
    }

    private void fueraPlazo() {
          System.out.println("Prestamos fuera de plazo:");
        for (Prestamo p : prestamos) {
            if (p.getFechaDevolucion().isBefore(LocalDate.now())) {
                System.out.println(p.getLibroPrestamo().getIsbn() + " - " + p.getUsuarioPrestamo().getNombre() + ": " + p.getLibroPrestamo().getTitulo() 
                        + " - Fecha de devolucion: " + p.getFechaDevolucion());
            }
        }
    }

    private int numPrestamosLibro(String isbn) {
         int cont = 0;
        for (Prestamo p : prestamos) {
            if (p.getLibroPrestamo().getIsbn().equalsIgnoreCase(isbn)) {
                cont++;
            }
        }
        for (Prestamo p : prestamosHist) {
            if (p.getLibroPrestamo().getIsbn().equalsIgnoreCase(isbn)) {
                cont++;
            }
        }
        return cont;
    }

    

    

}