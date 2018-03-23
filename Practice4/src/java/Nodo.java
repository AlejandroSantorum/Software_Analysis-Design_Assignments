public abstract class Nodo implements INodo{
    private String simbolo;
    private int maxDescendientes;
    private ArrayList<Nodo> descendientes;
    
    public Nodo(String simbolo, int maxDescendientes){
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
            excepcion 
        }
        this.descendientes.add(nodo);
    }
    
    public abstract double calcular();
    
    public INodo copy() throws CloneNotSupportedException{
        return (INodo) this.clone();
    }
}
