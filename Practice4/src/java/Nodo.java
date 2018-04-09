import java.util.*;

public abstract class Nodo implements INodo, Cloneable{
    private String simbolo;
    private int maxDescendientes;
    private ArrayList<INodo> descendientes;
    
    public Nodo(String simbolo, int maxDescendientes){
        descendientes = new ArrayList<INodo>();
        this.simbolo = simbolo;
        this.maxDescendientes = maxDescendientes;
    }
    
    public String getRaiz(){
        return simbolo;
    }
    
    public ArrayList<INodo> getDescendientes(){
        return descendientes;
    }
    
    public void incluirDescendiente(INodo nodo){
        if(this.descendientes.size() == maxDescendientes){
            //---> excepcion <--- 
            System.out.println("ERROROROROROROROOROROORORO MAXDESCENDIENTES");
        }
        this.descendientes.add(nodo);
    }
    
    public abstract double calcular();
    
    public INodo copy() throws CloneNotSupportedException{
        return (INodo) this.clone();
    }
    
}
