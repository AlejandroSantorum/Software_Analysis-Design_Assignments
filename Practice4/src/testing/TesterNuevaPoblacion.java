import java.util.*;
import java.io.*;

public class TesterNuevaPoblacion{ 
    
    public static void main(String[] args) throws IOException, CruceNuloException, FileNotFoundException, ParametroNoInicializadoException, ProfundidadInvalidaException, MaximosDescendientesException, ArgsDistintosFuncionesException{
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
        
        AlgoritmoGenetico algGen = new AlgoritmoGenetico(10, 4, 5, 0.9, 1000);
        IDominio domAritm;
        domAritm = new DominioAritmetico();
        domAritm.definirValoresPrueba("valoresReducido.txt");
        
        algGen.defineConjuntoFunciones(conjuntoFunciones);
        algGen.defineConjuntoTerminales(conjuntoTerminales);
        
        
        algGen.crearPoblacion();
        List<IIndividuo> pobl = algGen.getPoblacion();
        
        for(IIndividuo ind: pobl){
            System.out.println("Individuo ==>");
            domAritm.calcularFitness(ind, 0);
            ind.writeIndividuo();
            System.out.println();
        }
        
        System.out.println(" ========================================= ");
        
        algGen.crearNuevaPoblacion();
        pobl = algGen.getPoblacion();
        
        for(IIndividuo ind: pobl){
            System.out.println("Individuo ==>");
            ind.writeIndividuo();
            System.out.println();
        }
    }
}