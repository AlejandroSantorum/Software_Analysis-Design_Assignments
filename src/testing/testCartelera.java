import java.util.*;

/**
   * Tester de la clase Cartelera
   *
   * <p>Este tester comprueba que todos los métodos de la clase Cartelera
   * han sido creados sin errores.</p>
   *
   * @param args No se espera que se pase ningun argumento de entrada
   */
public class testCartelera{
    public static void main(String[] args){
        
        System.out.println("=== CLASE CARTELERA TESTING ===");
        System.out.println("Creando varias salas, sesiones y peliculas...");
        
        Pelicula pel1 = new Pelicula("Harry Potter y las practicas aprobadas", "Director 1", 2018, "Sinopsis 1", Genero.TERROR);
        Pelicula pel2 = new Pelicula("El Señor de los Suspensos", "Director 2", 2019, "Sinopsis 2", Genero.AVENTURAS);
        Pelicula pel3 = new Pelicula("Fast and Furious 24", "Director 3", 2020, "Sinopsis 3", Genero.ACCION);
        
        Sala sala1 = new Sala(1, 10, 10);
        Sala sala2 = new Sala(2, 20, 20);
        Sala sala3 = new Sala(3, 30, 30);
        
        
        Sesion ses1 = new Sesion(new GregorianCalendar(2018, 02, 21, 22, 40), pel1, sala1, 10.00f);
        Sesion ses2 = new Sesion(new GregorianCalendar(2018, 02, 21, 23, 30), pel1, sala2, 11.00f);
        Sesion ses3 = new Sesion(new GregorianCalendar(2018, 02, 22, 21, 20), pel2, sala3, 12.00f);
        Sesion ses4 = new Sesion(new GregorianCalendar(2018, 02, 23, 22, 10), pel1, sala1, 14.00f);
        Sesion ses5 = new Sesion(new GregorianCalendar(2018, 02, 21, 12, 30), pel2, sala2, 15.00f);
        Sesion ses6 = new Sesion(new GregorianCalendar(2018, 03, 24, 17, 45), pel3, sala2, 16.00f);
        Sesion ses7 = new Sesion(new GregorianCalendar(2019, 01, 15, 20, 30), pel3, sala3, 17.00f);
        
        sala1.addSesion(ses1);
        sala1.addSesion(ses4);
        sala2.addSesion(ses2);
        sala2.addSesion(ses5);
        sala2.addSesion(ses6);
        sala3.addSesion(ses3);
        sala3.addSesion(ses7);
        
        Cartelera cartelera = new Cartelera();
        
        cartelera.addPelicula(pel1);
        cartelera.addPelicula(pel2);
        cartelera.addPelicula(pel3);
        
        cartelera.addSesion(ses1);
        cartelera.addSesion(ses2);
        cartelera.addSesion(ses3);
        cartelera.addSesion(ses4);
        cartelera.addSesion(ses5);
        cartelera.addSesion(ses6);
        cartelera.addSesion(ses7);
        
        System.out.println("Objetos creados con exito\n");
        
        System.out.println("Imprimiendo cartelera...");
        
        System.out.println(cartelera);
        
        System.out.println("Testing clase Cartelera superado con EXITO");
        
    }
}