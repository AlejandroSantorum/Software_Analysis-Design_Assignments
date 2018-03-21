import java.util.*;

public class testButaca{
    public static void main(String[] args){
        
        System.out.println("=== CLASE BUTACA TESTING ===");
        System.out.println("Creando butaca con fila 5 y columna 5...");
        
    
        Butaca but = new Butaca(5, 5);
        if(but == null){
            System.err.println("OBJETO BUTACA IGUAL A NULL");
            return;
        }
        
        System.out.println("Objeto Butaca creado con exito\n");
        
        System.out.println("Comprobando que la butaca tiene fila 5 y columna 5...");
        int row = but.getFila();
        int col = but.getColumna();
        
        if(row != 5 || col != 5){
            System.err.println("FILA O COLUMNA INCORRECTAS");
            System.err.println("Fila = "+row+" Columna = "+col);
            return;
        }
        System.out.println("Fila de la butaca = "+row+ " y Columna de la butaca = "+col);
        System.out.println("Comprobacion pasada con exito\n");
        
        System.out.println("Comprobando que la butaca esta libre por defecto...");
        
        if(but.estaDisponible() != true){
            System.err.println("ESTADO DE LA BUTACA INCORRECTO, DEBERIA ESTAR LIBRE");
            return;
        }
        System.out.println("¿Esta la butaca libre? --> "+but.estaDisponible());
        System.out.println("Ocupando butaca...");
        
        but.ocuparButaca();
        if(but.estaDisponible() == true){
            System.err.println("ESTADO DE LA BUTACA INCORRECTO, DEBERIA ESTAR OCUPADA");
            return;
        }
        System.out.println("¿Esta la butaca libre? --> "+but.estaDisponible());
        
        System.out.println("\n == COMPROBACIONES DE LA CLASE BUTACA SUPERADAS CON EXITO ==\n");
        
        System.out.println("A continuacion, se intenta crear una butaca con numero de fila negativo");
        System.out.println("El CORRECTO funcionamiento seria el lanzamiento de una EXCEPCION\n");
        Butaca but2 = new Butaca(-5, 5);
    }
}