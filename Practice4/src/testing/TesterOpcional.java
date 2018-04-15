import java.io.*;
import java.util.*;

public class TesterOpcional{
    
    public static void main(String[] args) throws IOException, MaximosDescendientesException, CruceNuloException, FileNotFoundException, ParametroNoInicializadoException, ProfundidadInvalidaException, ArgsDistintosFuncionesException{
        IDominio dominio = new DominioBooleano();
        dominio.definirValoresPrueba("valoresOpcional.txt");
        
        int[] intArray = {2, 2, 2, 2};
        
        dominio.definirConjuntoFunciones(intArray, "and", "or", "nand", "nor");
        dominio.definirConjuntoTerminales("d0", "d1", "d2");
        
        IAlgoritmo algGen = new AlgoritmoGenetico(20, 3, 8, 0.9, 2000);
        algGen.ejecutar(dominio);
    }
    
}