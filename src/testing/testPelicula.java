import java.util.*;

/**
   * Tester de la clase Pelicula
   *
   * <p>Este tester comprueba que todos los métodos de la clase Pelicula
   * han sido creados sin errores.</p>
   *
   * @param args No se espera que se pase ningun argumento de entrada
   */
   
public class testPelicula{
    public static void main(String[] args){
        
        System.out.println("=== CLASE PELICULA TESTING ===");
        System.out.println("Creando pelicula con");
        System.out.println("Titulo: Un dia explosivo en la vida de Bin Laden");
        System.out.println("Director: Christopher Nolan");
        System.out.println("Año: 2019");
        System.out.println("Sinopsis: Una pelicula emocionante autobiografica sobre la vida de Bin Landen");
        System.out.println("Genero: Historico");
        
        Pelicula peli = new Pelicula("Un dia explosivo en la vida de Bin Laden", "Christopher Nolan", 2019, "Una pelicula emocionante autobiografica sobre la vida de Bin Landen", Genero.HISTORICO);
        if(peli == null){
            System.err.println("OBJETO PELICULA IGUAL A NULL");
            return;
        }
        
        System.out.println("Objeto Pelicula creado con exito\n");
        
        System.out.println("Comprobando que la pelicula tiene los campos predefinidos");
        String name = peli.getTitulo();
        String direct = peli.getDirector();
        int anno = peli.getAnno();
        String sinop = peli.getSinopsis();
        Genero gen = peli.getGenero();
        if(!name.equals("Un dia explosivo en la vida de Bin Laden") || !direct.equals("Christopher Nolan") || anno!=2019){
            System.err.println("FALLO DEL SISTEMA. Hay una correspondencia fallida:");
            System.err.println("Titulo = "+name);
            System.err.println("Director = "+direct);
            System.err.println("Anno = "+anno);
            System.err.println("Sinopsis = "+sinop);
            System.err.println("Genero = "+gen);
            return;
        }
        if(!sinop.equals("Una pelicula emocionante autobiografica sobre la vida de Bin Landen") || !gen.equals(Genero.HISTORICO)){
            System.err.println("FALLO DEL SISTEMA. Hay una correspondencia fallida:");
            System.err.println("Titulo = "+name);
            System.err.println("Director = "+direct);
            System.err.println("Anno = "+anno);
            System.err.println("Sinopsis = "+sinop);
            System.err.println("Genero = "+gen);
            return;
        }
        System.out.println("Titulo = "+name);
        System.out.println("Director = "+direct);
        System.out.println("Anno = "+anno);
        System.out.println("Sinopsis = "+sinop);
        System.out.println("Genero = "+gen);
        
        System.out.println("Comprobacion superada con exito\n");
        
        System.out.println("Creando otra pelicula con diferentes parametros para comprobar el funcionamiento de equals()");
        
        Pelicula pel2 = new Pelicula("Una pelicula", "Christopher Nolan", 2000, "Una sinopsis", Genero.TERROR);
        
        if(peli.equals(pel2)){
            System.err.println("Error de funcionamiento de la funcion equals()");
            System.err.println("Deberian ser peliculas distintas e equals() marca"+peli.equals(pel2));
            return;
        }
        
        System.out.println("¿Son iguales las dos peliculas creadas? --> "+peli.equals(pel2));
        System.out.println("Correcto");
        System.out.println("Comprobando que equals() devuelve true cuando se le pasa dos peliculas iguales...");
        System.out.println("¿Es igual una pelicula consigo misma? --> "+peli.equals(peli));
        
        System.out.println("Funcionamiento correcto\n");
        
        System.out.println("Comprobando el metodo toString()");
        System.out.println(peli);
        System.out.println("\nFuncionamiento correcto");
        
        System.out.println("\n == COMPROBACIONES DE LA CLASE PELICULA SUPERADAS CON EXITO ==\n");
        
        System.out.println("A continuacion, se intenta crear una pelicula con un anno negativo");
        System.out.println("El CORRECTO funcionamiento seria el lanzamiento de una EXCEPCION\n");
        Pelicula aux = new Pelicula("Una peli", "Un dire", -100, "Sinopsis", Genero.TERROR);
    }
}