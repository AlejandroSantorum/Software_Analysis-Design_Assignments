import java.io.*;
import java.util.*;

public class TesterAlgoritmoGenetico{
    
    public static void main(String[] args) throws IOException, MaximosDescendientesException, CruceNuloException, FileNotFoundException, ParametroNoInicializadoException, ProfundidadInvalidaException, ArgsDistintosFuncionesException{
        IDominio dominio = new DominioAritmetico();
        dominio.definirValoresPrueba("valores.txt");
        
        int[] intArray = {2, 2, 2};
        
        dominio.definirConjuntoFunciones(intArray, "+", "-", "*");
        dominio.definirConjuntoTerminales("x");
        
        IAlgoritmo algGen = new AlgoritmoGenetico(20, 5, 8, 0.9, 1000);
        algGen.ejecutar(dominio);
    }
    
}