import java.util.*;

public class Individuo implements IIndividuo{
    private INodo raiz;
    
    public INodo getExpresion(){
        return raiz;
    }
    
    public void setExpresion(INodo expresion){
        raiz = expresion;
    }
    
    public void writeIndividuo(){
        System.out.println(this.raiz);
    }
    
    /*
    public abstract double getFitness();
    public abstract void setFitness(double fitness);
    public abstract void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones);
    public abstract double calcularExpresion();
    public abstract int getNumeroNodos();*/
}