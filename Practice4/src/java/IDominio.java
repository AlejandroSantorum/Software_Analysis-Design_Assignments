import java.io.*;

public interface IDominio {
    /*
    public List<Terminal> definirConjuntoTerminales(String... terminales); 
    public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException; 
    */
    public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;    
    public double calcularFitness(IIndividuo individuo); 
}