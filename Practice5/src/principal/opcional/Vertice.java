package opcional;
import java.util.*;

public class Vertice<T>{
    private int id; // identificador del vertice dentro del grafo
    private T datos; // datos almacenados en el vertice
    private Map<Vertice<T>, Double> conexionesOut;
    private Map<Vertice<T>, Double> conexionesIn;;
    
    public Vertice(int id, T datos){
        this.id = id;
        this.datos = datos;
        conexionesOut = new HashMap<Vertice<T>, Double>();
        conexionesIn = new HashMap<Vertice<T>, Double>();
    }
    
    public int getId(){
        return id;
    }
    
    public T getDatos(){
        return datos;
    }
    
    public Map<Vertice<T>, Double> getConexionesOut(){
        return conexionesOut;
    }
    
    public Map<Vertice<T>, Double> getConexionesIn(){
        return conexionesIn;
    }
    
    public String toString(){
        String aux;
        aux = "Vertice con ID = "+id+" y con dato = "+datos;
        return aux;
    }
    
    public String imprimirConexiones(){
        String aux;
        Set<Vertice<T>> out = conexionesOut.keySet();
        Set<Vertice<T>> in = conexionesIn.keySet();
        aux = "-Conectado a:\n";
        for(Vertice<T> v: out){
            aux += "\t--> "+v+"\n";
        }
        aux += "-Conectado desde:\n";
        for(Vertice<T> v: in){
            aux += "\t--> "+v+"\n";
        }
        return aux;
        
    }
    
    public Boolean equals(Vertice<T> v){
        if(this.id == v.id){
            return true;
        }
        return false;
    }
    
    public void addAristaOut(Vertice<T> v, Double peso){
        conexionesOut.put(v, peso);
    }
    
    public void addAristaIn(Vertice<T> v, Double peso){
        conexionesIn.put(v, peso);
    }
    
    public Boolean existeAristaOut(Vertice<T> v){
        return conexionesOut.containsKey(v);
    }

    public Boolean existeAristaIn(Vertice<T> v){
        return conexionesIn.containsKey(v);
    }
    
    public Double getPesoArista(Vertice<T> v) throws AristaInvalidaException{
        if(!conexionesOut.containsKey(v)){
            throw new AristaInvalidaException("No existe un arco entre el vertice "+this.id+" y el vertice "+v.id);
        }
        else{
            return conexionesOut.get(v);
        }
    }
}