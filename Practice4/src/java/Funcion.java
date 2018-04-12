import java.util.*;

public abstract class Funcion extends Nodo{
    
    public Funcion(String simbolo, int maxDescendientes){
        super(simbolo, maxDescendientes);
    }
    
    
    public abstract double calcular();
    
    public abstract INodo copy();
    
    
    public String toString(){
        String aux;
        ArrayList<INodo> descendientes = this.getDescendientes();
        
        aux = "( "+this.getRaiz();
        
        for(INodo n: descendientes){
            aux += " "+n.toString()+" ";
        }
        
        aux += " )";
        
        return aux;
    }
    
}