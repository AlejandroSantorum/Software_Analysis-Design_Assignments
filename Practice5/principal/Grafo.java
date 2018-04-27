public abstract class Grafo<T>{
    private int verticeId = 0;
    private int nAristas = 0;
    protected Map<Integer, Vertice<T>> vertices = new HashMap<Integer, Vertice<T>>();
    
    public Vertice<T> addVertice(T datos){
        verticeId += 1;
        return this.addVertice(verticeId, datos);
    }
    
    protected Vertice<T> addVertice(int id, T datos) throws VerticeIdException{
        if(vertices.containsKey(id)){
            throw new VerticeIdException("Intentando introducir un vertice con un ID repetido");
        }
        Vertice<T> v = new Vertice(id, datos);
        vertices.put(id, v);
        return v;
    }
    
    public List<Vertice<T>> getVertices(){
        return vertices.values();
    }
    
    public int getNumVertices(){
        return verticeId;
    }
    
    public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
    
    protected void incrementarAristas(){
        nAristas += 1;
    }
    
    public boolean existeArco(Vertice<T> v1, Vertice<T> v2){
        return v1.existeAristaOut(v2);
    }
    
    
    public int getNumArcos(){
        return nAristas;
    }
    
    public Double getPesoDe(Vertice<T> v1, Vertice<T> v2){
        return v1.getPesoArista(v2);
    }
    
    public List<Vertice<T>> getVecinosDe(Vertice<T> v){     // devuelve los vértices que tienen un arco con v
        List<Vertice<T>> auxiliar = new ArrayList<>();      // (en grafo dirigido, v ha de ser origen de los arcos)
        auxiliar = addAll(v.getConexionesOut().keySet());                        
        return auxiliar;
    }                                                            
                                                                
    public String toString(); // los vértices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
    
}