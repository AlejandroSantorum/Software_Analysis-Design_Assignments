import java.util.*;
import java.io.*;

public class TesterCrearIndividuoAleatorio{ 
    
    public static void main(String[] args) throws ProfundidadInvalidaException, MaximosDescendientesException{
        if(args.length < 1){
            System.err.println("Error: numero de parámetros de entrada insuficiente. Introduzca profundidad");
            return;
        }
        
        Terminal x = new TerminalAritmetico("x");
        Funcion suma = new FuncionSuma("+", 2);
        Funcion resta = new FuncionResta("-", 2);
        Funcion multi = new FuncionMultiplicacion("*", 2);
        
        Funcion nodoInd = new FuncionSuma("+", 2);
        
        List<Terminal> conjuntoTerminales = new ArrayList<Terminal>();
        conjuntoTerminales.add(x);
        
        List<Funcion> conjuntoFunciones = new ArrayList<Funcion>();
        conjuntoFunciones.add(suma);
        conjuntoFunciones.add(resta);
        conjuntoFunciones.add(multi);
        
        IIndividuo prog1 = new Individuo();
        prog1.setExpresion(nodoInd);
        System.out.println();
        System.out.println("PROGENITOR");
        prog1.writeIndividuo();
    
        prog1.crearIndividuoAleatorio(Integer.parseInt(args[0]), conjuntoTerminales, conjuntoFunciones);
        System.out.println("INDIVIDUO ALEATORIO CREADO:");
        prog1.writeIndividuo();
    }
}