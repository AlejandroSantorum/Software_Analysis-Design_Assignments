import java.util.*;

public class Individuo implements IIndividuo{
    private INodo raiz;
    private double fitness=-1;
    
    public INodo getExpresion(){
        return raiz;
    }
    
    public void setExpresion(INodo expresion){
        raiz = expresion;
    }
    
    public void writeIndividuo(){
        System.out.println(this.raiz);
    }
    
    public double getFitness(){
        return fitness;
    }
    
    public void setFitness(double fitness){
        this.fitness = fitness;
    }
    /*
    public abstract void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones);
    public abstract double calcularExpresion();
    public abstract int getNumeroNodos();*/
}