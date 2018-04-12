import java.io.*;
import java.util.*;

public class TesterEtiquetarDescendientes{
    
    public static void main(String[] args) throws CloneNotSupportedException, IOException{
        Terminal x = new TerminalAritmetico("x");
        Funcion suma = new FuncionSuma("+", 2);
        Funcion resta = new FuncionResta("-", 2);
        Funcion multi = new FuncionMultiplicacion("*", 2); 
        
        multi.incluirDescendiente(x);
        multi.incluirDescendiente(x);
        suma.incluirDescendiente(multi);
        suma.incluirDescendiente(x);
        resta.incluirDescendiente(suma);
        resta.incluirDescendiente(multi);
        
        resta.setId(1);
        
        ((Nodo) resta).etiquetarDescendientes();
        System.out.println("Etiquetas: "+((Nodo) resta).mostrarDescendientesIds());
        
        System.out.println("Resta: " + resta.getId());
        System.out.println("Suma: " + suma.getId());
        System.out.println("Multi: " + multi.getId());
        System.out.println("X: " + x.getId());
        
        INodo nodo = ((Nodo) resta).getDescendienteById(7);
        
        System.out.println("Id del buscado: "+ ((Nodo) nodo).getId());
        System.out.println("Expresion del nodo encontrado: "+nodo);
        System.out.println("Id del padre: " + ((Nodo) ((Nodo) nodo).getPadre()).getId());
        System.out.println("Expresion del padre del nodo: "+((Nodo) nodo).getPadre());
        
    }
}