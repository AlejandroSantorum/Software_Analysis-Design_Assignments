import java.util.*;

public class testEntradas{
    public static void main(String[] args){
        
        System.out.println("=== CLASES DE ENTRADAS TESTING ===");
        System.out.println("Creando una entrada normal a partir de una sesion con un precio base de 10.00");
        
        Pelicula pel = new Pelicula("Pelicula de prueba", "Probador", 2018, "Una sinopsis cualquiera", Genero.SUSPENSE);
        Sala sal = new Sala(1000, 50, 50);
        Sesion ses = new Sesion(new GregorianCalendar(2018, 02, 22, 22, 15), pel, sal, 10.00f);
        
        /* -------------------------------------- ENTRADA ---------------------------------------------- */
        
        Entrada entr = new Entrada(ses);
        if(entr==null){
            System.err.println("OBJETO ENTRADA IGUAL A NULL");
            return;
        }
        
        System.out.println("Objeto Entrada creado con exito\n");
        
        System.out.println("Comprobando las metodos de la clase Entrada...");
        
        System.out.println("¿Es la sesion utilizada igual a la devuelta por el getter? --> "+entr.getSesion().equals(ses));
        System.out.println("¿Es el precio de la entrada igual a 10.00? --> "+(entr.getPrecio() == 10.00f));
        System.out.println("Cambiamos el precio por 7.50 por cualquier causa...");
        entr.setPrecio(7.5f);
        System.out.println("¿Es el precio de la entrada igual a 7.50? --> "+(entr.getPrecio() == 7.50f));
        System.out.println("\nSI TODO LO ANTERIOR ES IGUAL A true, ENTONCES COMPROBACION SUPERADA CON EXITO\n");
        
        /* ----------------------------------------------------------------------------------------------- */
        
        /* ----------------------------------- ENTRADA DIA ESPECTADOR ------------------------------------ */
         
        System.out.println("Creando una entrada del dia del espectador...");
        
        Entrada entrDE = new EntradaDiaEspectador(ses, 0.75f);
        if(entrDE==null){
            System.err.println("OBJETO EntradaDiaEspectador IGUAL A NULL");
            return;
        }
        
        System.out.println("Objeto EntradaDiaEspectador creado con exito\n");
        
        System.out.println("Comprobando las metodos de la clase EntradaDiaEspectador...");
        
        System.out.println("¿Es la sesion utilizada igual a la devuelta por el getter? --> "+entrDE.getSesion().equals(ses));
        System.out.println("¿Es el precio de la entrada igual a 7.50 (75% de 10.00)? --> "+(entrDE.getPrecio() == 7.5f));
        System.out.println("Cambiamos el precio por 8.00 por cualquier causa...");
        entrDE.setPrecio(8.0f);
        System.out.println("¿Es el precio de la entrada igual a 6.0 (75% de 8.0)? --> "+(entrDE.getPrecio() == 6.0f));
        System.out.println("\nSI TODO LO ANTERIOR ES IGUAL A true, ENTONCES COMPROBACION SUPERADA CON EXITO\n");
        
        /* ----------------------------------------------------------------------------------------------- */
        
        /* --------------------------------------- ENTRADA ESPECIAL -------------------------------------- */
        
        System.out.println("Creando una entrada especial...");
        System.out.println("En este caso de tipo FIESTA pero las comprobaciones son analogas para los demas tipos");
        
        Entrada entrESP = new EntradaEspecial(ses, TipoEntrada.FIESTA);
        if(entrESP==null){
            System.err.println("OBJETO EntradaEspecial IGUAL A NULL");
            return;
        }
        
        System.out.println("Objeto EntradaEspecial creado con exito\n");
        
        System.out.println("Comprobando las metodos de la clase EntradaDiaEspecial...");
    
        System.out.println("¿Es la sesion utilizada igual a la devuelta por el getter? --> "+entrESP.getSesion().equals(ses));
        System.out.println("¿Es el precio de la entrada igual a 8.0 (80% de 10.00)? --> "+(entrESP.getPrecio() == 8.0f));
        System.out.println("Cambiamos el precio por 5.00 por cualquier causa...");
        entrESP.setPrecio(5.0f);
        System.out.println("¿Es el precio de la entrada igual a 4.0 (80% de 5.0)? --> "+(entrESP.getPrecio() == 4.0f));
        System.out.println("\nSI TODO LO ANTERIOR ES IGUAL A true, ENTONCES COMPROBACION SUPERADA CON EXITO\n");
        
        System.out.println("\n == COMPROBACIONES DE LAS CLASES ENTRADAS SUPERADAS CON EXITO ==\n");
    }
}