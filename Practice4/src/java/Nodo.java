import java.util.*;

public abstract class Nodo implements INodo, Cloneable{
    int id;
    private String simbolo;
    private INodo padre;
    private int maxDescendientes;
    private ArrayList<INodo> descendientes;
    
    public Nodo(String simbolo, int maxDescendientes){
        if(maxDescendientes < 0){
		      throw new IllegalArgumentException("maxDescendientes es menor que cero: " + maxDescendientes); 
		}
        descendientes = new ArrayList<INodo>();
        this.simbolo = simbolo;
        this.maxDescendientes = maxDescendientes;
        this.id = -1;
    }
    
    
    public int getId(){
        return id;
    }
    
    
    public void setId(int id){
        this.id = id;
    }
    
    
    public String getRaiz(){
        return simbolo;
    }
    
    
    public INodo getPadre(){
        return padre;
    }
    
    
    public void setPadre(INodo padre){
        this.padre = padre;
    }
    
    
    public ArrayList<INodo> getDescendientes(){
        return descendientes;
    }
    
    public int getNumDescendientes(){
        return descendientes.size();
    }
    
    
    public int getMaxDescendientes(){
        return maxDescendientes;
    }
    
    
    public void incluirDescendiente(INodo nodo){
        if(this.descendientes.size() == maxDescendientes){
            //---> excepcion <--- 
            System.out.println("ERROROROROROROROOROROORORO MAXDESCENDIENTES");
        }
        
        INodo copia = nodo.copy();
        this.descendientes.add(copia);
        ((Nodo) copia).padre = this;
    }
    
    
    public abstract double calcular();
    
    
    public abstract INodo copy();
    
    
    // Esta funcion devuelve todos los descendientes del nodo MÁS EL PROPIO NODO
    public ArrayList<INodo> getAllDescendientes(){
        ArrayList<INodo> arrayAuxiliar = new ArrayList<INodo>();
        ArrayList<INodo> ret = new ArrayList<INodo>();
        
        arrayAuxiliar.add(this);
        while(!arrayAuxiliar.isEmpty()){
            arrayAuxiliar.addAll(arrayAuxiliar.get(0).getDescendientes());
            ret.add(arrayAuxiliar.get(0));
            arrayAuxiliar.remove(0);
        }
        
        return ret;
    }
    
    
    public void etiquetarDescendientes(){
        ArrayList<INodo> array = this.getAllDescendientes();
        
        for(int i=0; i< array.size(); i++){
            ((Nodo) array.get(i)).setId(i+1);
        }
    }
    
    
    public INodo getDescendienteById(int id){
        ArrayList<INodo> arrayDes = this.getAllDescendientes();
        
        for(INodo n: arrayDes){
            if(((Nodo) n).getId() == id){
                return n;
            }
        }
        return null;
    }
    
    
    public String mostrarDescendientesIds(){
        String aux = "";
        
        if(this.descendientes.size() == 0){
            return " "+id+" ";
        }
        else{
            for(INodo n: descendientes){
                aux += ((Nodo) n).mostrarDescendientesIds();
            }
        }
        
        return aux+" "+id+" ";
    }
    
}
