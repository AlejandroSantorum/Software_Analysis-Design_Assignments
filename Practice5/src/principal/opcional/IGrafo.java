package opcional;

import java.util.*;

public interface IGrafo<T> {
	public Vertice<T> addVertice(T datos) throws VerticeIdException;
	public List<Vertice<T>> getVertices(); 
	public int getNumVertices();
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	public boolean existeArco(Vertice<T> v1, Vertice<T>v2); 
	public int getNumArcos(); 
	public abstract Double getPesoDe(Vertice<T> v1, Vertice<T> v2) throws AristaInvalidaException; 
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); 
	public String toString();
}
