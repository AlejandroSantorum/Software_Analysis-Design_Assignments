public class Vertice<T>{
    private final int id; // identificador del vertice dentro del grafo
    private T datos; // datos almacenados en el vertice
    private Map<Vertice<T>, Double> conexionesOut;
    private Map<Vertice<T>, Double> conexionesIn;;
    
    public Vertice<T>(int id, T datos){
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
    
    public Boolean equals(Vertice<T> v){
        if(this.id == v.id{
            return true;
        }
        return false;
    }
    
    public void addAristaOut(Vertice<T> v, Double peso){
        conexionesOut.put(v, peso);
    }
    
    public void addAristaIn(Vertice<T> v, Double peso){
        conexionesIn.add(v, peso);
    }
    
    public Boolean existeAristaOut(Vertice<T> v){
        return conexionesOut.containsKey(v);
    }

    public Boolean existeAristaIn(Vertice<T> v){
        return conexionesIn.containsKey(v);
    }
    
    public Double getPesoArista(Vertice<T> v){
        if(!conexionesOut.containsKey(v)){
            throw new AristaInvalidaException("No existe un arco entre el vertice "+this.id+" y el vertice "+v.id);
        }
        else{
            return conexionesOut.get(v);
        }
    }
}