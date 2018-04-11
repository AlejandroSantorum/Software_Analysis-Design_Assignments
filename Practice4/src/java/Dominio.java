import java.io.*;

public abstract class Dominio implements IDominio{
    /*
    public abstract List<Terminal> definirConjuntoTerminales(String... terminales);
    public abstract List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException; 
    */
    public abstract void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;    
    public abstract double calcularFitness(IIndividuo individuo); 
}