import java.util.*;

public abstract class Terminal extends Nodo{
    
    public Terminal(String simbolo){
        super(simbolo, 0);
    }
    
    public abstract double calcular();
    
    public abstract INodo copy();
    
    public String toString(){
        return this.getRaiz();
    }
}