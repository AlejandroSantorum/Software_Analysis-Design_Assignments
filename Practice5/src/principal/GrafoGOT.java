import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GrafoGOT extends GrafoNoDirigido{

    public GrafoGOT(String ficheroVertices, String ficheroArcos) throws IOException, VerticeIdException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroVertices)));
		String line;
		String[] items = new String[] {};
		while ((line = reader.readLine()) != null) {
			items = line.split(",");
			if (items.length != 3) {
				throw new IOException("Una linea del fichero de vertices no tiene tres argumentos.\n");
			}
			this.addVertice(new PersonajeGOT(items[1], items[2]));
		}
            
        
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroArcos)));
		while ((line = reader.readLine()) != null) {
			items = line.split(",");
			if (items.length != 3) {
				throw new IOException("Una linea del fichero de arcos no tiene tres argumentos.\n");
			}
			this.addArco((Vertice<PersonajeGOT>) this.vertices.get(Integer.parseInt(items[0])),
					(Vertice<PersonajeGOT>) this.vertices.get(Integer.parseInt(items[1])), Integer.parseInt(items[2]));
		}
    }
    
    Vertice<PersonajeGOT> getVertice(String nombre) throws PersonajeNoExisteException{
    	List<Vertice<PersonajeGOT>> personajes = new ArrayList(this.vertices.values());
            
        List<Vertice<PersonajeGOT>> elegidos= personajes.stream().filter(p -> 
            p.getDatos().getNombre().equals(nombre)).collect(Collectors.toList());
        
        if(elegidos.size() == 0){
            throw new PersonajeNoExisteException("No hay ningun personaje llamado " + nombre);
        }
        
        return elegidos.get(0);
    }
    
    public List<String> casas(){
        List<Vertice<PersonajeGOT>> personajes = new ArrayList(this.vertices.values());
        
        Set<String> elegidos = personajes.stream().map(Vertice<PersonajeGOT>::getDatos).map(
            PersonajeGOT::getCasa).filter(c -> (c.equals("null") == false)).collect(Collectors.toSet());
        List<String> aux = new ArrayList<>();
        aux.addAll(elegidos);
        aux.sort(null);
        return aux;
    }
    
    public List<String> miembrosCasa(String casa){
        List<Vertice<PersonajeGOT>> personajes = new ArrayList(this.vertices.values());

    	Predicate<String> pertenece = x -> x.equals(casa);
    	
    	List<String> elegidos = (personajes.stream().map(Vertice<PersonajeGOT>::getDatos).filter(
    			c -> pertenece.test(c.getCasa()))).map(PersonajeGOT::getNombre).collect(Collectors.toList());
    	
    	return elegidos;
    }
    public Map<String, Integer> gradoPersonajes(){
    	Map<String, Integer> mapa = new HashMap<String, Integer>();
        List<Vertice<PersonajeGOT>> personajes = new ArrayList(this.vertices.values());
    	
    	List<String> nombres = personajes.stream().map(Vertice<PersonajeGOT>::getDatos).map(
    			PersonajeGOT::getNombre).collect(Collectors.toList());
    	List<Integer> grados = personajes.stream().map(Vertice<PersonajeGOT>::getConexionesIn).map(
    			p -> p.size()).collect(Collectors.toList());
    	
    	for(int i=0; i<nombres.size(); i++) {
    		mapa.put(nombres.get(i), grados.get(i));
    	}
    	return mapa;
    }
    public Map<String, Integer> gradoPonderadoPersonajes(){
    	Map<String, Integer> mapa = new HashMap<String, Integer>();
        List<Vertice<PersonajeGOT>> personajes = new ArrayList(this.vertices.values());
    	
    	List<String> nombres = personajes.stream().map(Vertice<PersonajeGOT>::getDatos).map(
    			PersonajeGOT::getNombre).collect(Collectors.toList());
    	/*List<Integer> gradosNum = personajes.stream().map(Vertice<PersonajeGOT>::getConexionesIn).map(
    			p -> p.size()).collect(Collectors.toList());*/
    	List<Double> gradosSum = personajes.stream().map(Vertice<PersonajeGOT>::getConexionesIn).map(
    			p -> p.values().stream().reduce(0.0,(x,y)->x+y)).collect(Collectors.toList());
    	
    	for(int i=0; i<nombres.size(); i++) {
    		mapa.put(nombres.get(i), gradosSum.get(i).intValue());
    	}
    	return mapa;
    }
    public Map<String, Integer> personajesRelevantes(){
    	Map<String,Integer> gradosPonderados = gradoPonderadoPersonajes();
    	
    	int suma = gradosPonderados.values().stream().reduce(0,(x,y)->x+y);
    	double media = suma/gradosPonderados.size();
    	System.out.println(media);
    	
    	Set<String> nombres = gradosPonderados.keySet();
    	Map<String,Integer> relevantes = new HashMap<String,Integer>();
    	int aux;
    	for(String n: nombres) {
    		aux = gradosPonderados.get(n);
    		if(aux > media) {
    			relevantes.put(n, aux);
    		}
    	}
    	
    	return relevantes;
    }
    
    public static void main(String[] args) throws AristaInvalidaException, VerticeIdException, IOException{
        GrafoGOT grafo = new GrafoGOT("vertices.csv","arcos.csv");
        System.out.println("\nResultado de llamar a casas():");
        System.out.println(grafo.casas());
        System.out.println("\nResultado de llamar a miembrosCasa(null):");
        System.out.println(grafo.miembrosCasa("null"));
        System.out.println("\nResultado de llamar a gradoPersonajes():");
        System.out.println(grafo.gradoPersonajes());
        System.out.println("\nResultado de llamar a gradoPonderadoPersonajes():");
        System.out.println(grafo.gradoPonderadoPersonajes());
        System.out.println("\nResultado de llamar a personajesRelevantes():");
        System.out.println(grafo.personajesRelevantes());
    }
}