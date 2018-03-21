import java.util.*;

public class testSala{
    public static void main(String[] args){
        
        System.out.println("=== CLASE SALA TESTING ===");
        System.out.println("Creando sala con ID=1000, con 50 filas y con 50 columnas de butacas...");
        
    
        Sala sal = new Sala(1000, 50, 50);
        if(sal == null){
            System.err.println("OBJETO SALA IGUAL A NULL");
            return;
        }
        
        System.out.println("Objeto Sala creado con exito\n");
        
        System.out.println("Comprobando que la sala tiene ID=1000, 50 filas y 50 columnas...");
        int row = sal.getFilasTotales();
        int col = sal.getColumnasTotales();
        int id = sal.getId();
        if(row != 50 || col != 50 || id!=1000){
            System.err.println("FILAS, COLUMNAS o ID INCORRECTOS");
            System.err.println("Filas = "+row+" Columnas = "+col+" ID = "+id);
            return;
        }
        System.out.println("Filas de la sala = "+row+ ", Columnas de la sala = "+col+" y id de la sala = "+id);
        System.out.println("Comprobacion pasada con exito\n");
        
        System.out.println("Creando una sala adicional para probar el metodo equals...");
        Sala sal2 = new Sala(100, 50, 50);
        if(sal.equals(sal2)){
            System.err.println("Una sala con ID=1000 es igual a otra con ID=100");
            System.err.println("METODO equals() INCORRECTO. Deberian ser salas distintas");
            return;
        }
        System.out.println("¿Sala con ID=1000 igual a otra con ID=100? --> "+sal.equals(sal2));
        System.out.println("\nComprobando que la primera sala comparada con si misma es considerada igual...");
        System.out.println("¿Sala con ID=1000 igual a otra con ID=1000 --> "+sal.equals(sal));
        System.out.println("CORRECTO. Esto es debido a que dos salas no pueden tener el mismo ID.");
        System.out.println("Estas comprobaciones son realizadas en otra clase\n");
        
        System.out.println("Creando una pelicula y una sesion(que contedra la pelicula) para asignar a esta sala...");
        
        Pelicula pel = new Pelicula("Pelicula de prueba", "Probador", 2018, "Una pelicula que no vale para nada", Genero.SUSPENSE);
        
        Sesion ses = new Sesion(new GregorianCalendar(2018, 02, 21, 12, 12), pel, sal, 10);
        
        System.out.println("Intentando añadir la sesion creada a la lista de sesiones de la sala...");
        if(!sal.addSesion(ses)){
            System.err.println("PROCESO FALLIDO. No se ha podido añadir la sesion a la sala");
            return; 
        }
        System.out.println("Sesion añadida con exito\n");
        
        System.out.println("Comprobando el funcionamiento del metodo contieneSesion() sobre la sala que le acabamos de añadir una sesion...");
        if(!sal.contieneSesion(ses)){
            System.err.println("PROCESO FALLIDO. Se ha determinado que la sala no contiene una sesion que SI QUE CONTIENE");
            System.err.println("Metodo contieneSesion() incorrecto");
            return; 
        }
        System.out.println("¿Contiene la sala la sesion introducida? --> "+sal.contieneSesion(ses));
        System.out.println("Funcionamiento del metodo correcto\n");
        
        
        System.out.println("Comprobando el funcionamiento del metodo getSesiones() y del eliminarPelicula()...");
        ArrayList<Sesion> arraySes = sal.getSesiones();
        System.out.println("Numero de sesiones en esta sala = " +arraySes.size());
        
        System.out.println("Eliminando sesiones en la sala que emiten la pelicula creada anteriormente");
        sal.deletePelicula(pel);
        
        if(arraySes.size() != 0){
            System.err.println("Funcion deletePelicula() ha fracaso. Funcionamiento indebido.");
            return;
        }
        System.out.println("Numero de sesiones en esta sala despues de la eliminacion = "+arraySes.size());
        System.out.println("Funcionamiento de deletePelicula y getSesiones CORRECTO");
        
        System.out.println("\n == COMPROBACIONES DE LA CLASE BUTACA SUPERADAS CON EXITO ==");
        
        System.out.println("A continuacion, se intenta crear una sala con numero de filas negativo");
        System.out.println("El CORRECTO funcionamiento seria el lanzamiento de una EXCEPCION\n");
        Sala sala = new Sala(1, -50, 50);
        
    }
}