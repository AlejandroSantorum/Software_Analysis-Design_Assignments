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
    
    public double calcularExpresion(){
        return this.raiz.calcular();
    }
    
    public int getNumeroNodos(){
        return ((Nodo) this.raiz).getAllDescendientes().size();
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
    
    public void etiquetaNodos(){
        ((Nodo) this.raiz).etiquetarDescendientes();
    }
    
    public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) throws ProfundidadInvalidaException{
        if(profundidad <= 1){
            throw new ProfundidadInvalidaException("crearIndividuoAleatorio: no se admite una profundidad menor o igual a uno");
        }
        
        if(profundidad==2){
            int max = terminales.size()-1;
            int ini = ((Nodo) this.raiz).getNumDescendientes();
            int total = ((Nodo) this.raiz).getMaxDescendientes();
            
            for(int i=ini; i<total; i++){
                int rand = PruebaCruce.aleat_num(0, max);
                Terminal term = terminales.get(rand);
                ((Nodo) this.raiz).incluirDescendiente((INodo) term);
            }
            return;
        }
        
        if(profundidad > 2){
            int max = funciones.size()-1;
            int ini = ((Nodo) this.raiz).getNumDescendientes();
            int total = ((Nodo) this.raiz).getMaxDescendientes();
            
            for(int i=ini; i<total; i++){
                int rand = PruebaCruce.aleat_num(0, max);
                Funcion func = funciones.get(rand);
                ((Nodo) this.raiz).incluirDescendiente((INodo) func);
            }
            
            ArrayList<INodo> hijos = ((Nodo) this.raiz).getDescendientes();
            System.out.println("Numero descendientes = "+hijos.size());
            
            for(INodo hijo: hijos){
                Individuo ind = new Individuo();
                ind.setExpresion(hijo);
                ind.crearIndividuoAleatorio(profundidad-1, terminales, funciones);
            }
        }
        return;
    }    
    
}