import java.util.*;

public class testSesion{
    public static void main(String[] args){
        
        System.out.println("=== CLASE SESION TESTING ===");
        System.out.println("Creando sesion con los siguientes datos:");
        System.out.println("Fecha -> 22-03-2018 a las 22:15");
        System.out.println("Sala con ID=1000, nFilas = 50 y nCols = 50");
        System.out.println("Numero de butacas disponibles iniciales = 50x50 = 2500");
        System.out.println("Precio = 10.00");
        Pelicula pel = new Pelicula("Pelicula de prueba", "Probador", 2018, "Una sinopsis cualquiera", Genero.SUSPENSE);
        System.out.println(pel);
        Sala sal = new Sala(1000, 50, 50);
        
    
        Sesion ses = new Sesion(new GregorianCalendar(2018, 02, 22, 22, 15), pel, sal, 10.00f);
        if(ses == null){
            System.err.println("OBJETO SESION IGUAL A NULL");
            return;
        }
        
        System.out.println("Objeto Sesion creado con exito\n");
        
        System.out.println("Comprobando el correcto funcionamiento del contructor y de los getters");
        
        System.out.println("¿Fecha sala introducida igual a la obtenida con el getter? --> "+ses.getFecha().equals(new GregorianCalendar(2018, 02, 22, 22, 15)));
        System.out.println("¿Pelicula introducida igual a la obtenida con el getter? --> "+ses.getPelicula().equals(pel));
        System.out.println("¿Sala introducida igual a la obtenida con el getter? --> "+ses.getSala().equals(sal));
        System.out.println("¿Precio base introducido igual al obtenido con el getter? --> "+(ses.getPrecioBase() == 10.00f));
        System.out.println("¿Numero de butacas disponibles iniciales igual a 2500? --> "+(ses.getButacasDisponibles() == 2500));
        System.out.println("¿Numero de butacas vendidas iniciales igual a cero? --> "+(ses.getNumeroButacasVendidas() == 0));
        System.out.println("\nSI TODO LO ANTERIOR ES IGUAL A true, ENTONCES COMPROBACION SUPERADA CON EXITO\n");
        
        System.out.println("Creando otra sesion con diferentes parametros para comprobar el funcionamiento de equals()");
        Sesion ses2 = new Sesion(new GregorianCalendar(2018, 02, 22, 22, 30), pel, sal, 10.00f);
        
        if(ses.equals(ses2)){
            System.err.println("Error de funcionamiento de la funcion equals()");
            System.err.println("Deberian ser sesiones distintas e equals() marca"+ses.equals(ses2));
            return;
        }
        
        System.out.println("¿Son iguales las dos sesiones creadas? --> "+ses.equals(ses2));
        System.out.println("Correcto");
        System.out.println("Comprobando que equals() devuelve true cuando se le pasa dos sesiones iguales...");
        System.out.println("¿Es igual una sesion consigo misma? --> "+ses.equals(ses));
        
        System.out.println("Funcionamiento correcto\n");
        
        System.out.println("Comprobando el funcionamiento de la compra de entradas. Vamos a comprar 500 entradas");
        if(!ses.actualizarButacasVendidas(500)){
            System.err.println("Funcion actualizarButacasVendidas() ha fracasado");
            return;
        }
        
        int disp = ses.getButacasDisponibles();
        int vend = ses.getNumeroButacasVendidas();
        
        if(disp != 2000 || vend != 500){
            System.err.println("Funcion actualizarButacasVendidas() ha funcionado incorrectamente");
            System.err.println("Numero de butacas disponibles despues de la compra = "+disp);
            System.err.println("Numero de butacas vendidas despues de la compra = "+vend);
            return;
        }
        
        System.out.println("Numero de butacas disponibles despues de la compra = "+disp);
        System.out.println("Numero de butacas vendidas despues de la compra = "+vend);
        
        System.out.println("\nFuncionamiento correcto");
        
        System.out.println("\n == COMPROBACIONES DE LA CLASE SESION SUPERADAS CON EXITO ==\n");
        
        System.out.println("A continuacion, se intenta comprar un numero negativo de entradas");
        System.out.println("El CORRECTO funcionamiento seria el lanzamiento de una EXCEPCION\n");
        ses.actualizarButacasVendidas(-100);
    
    }
}