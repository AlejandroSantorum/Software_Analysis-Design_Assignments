import java.io.*;
import java.util.*;

public abstract class Dominio implements IDominio{
    private double fitnessMaximo=-1.0;
    
    public abstract List<Terminal> definirConjuntoTerminales(String... terminales);
    public abstract List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException; 
    public abstract void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;    
    public abstract double calcularFitness(IIndividuo individuo, int flag); 
    public abstract List<Terminal> getTerminalesDefinidos();
    public abstract List<Funcion> getFuncionesDefinidas();
    
    public double getFitnessMaximo(){
        return fitnessMaximo;
    }
    public void setFitnessMaximo(double fitness){
        this.fitnessMaximo = fitness;
    }
}