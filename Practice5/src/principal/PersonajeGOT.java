public class PersonajeGOT implements Comparable{
    private String nombre;
    private String casa;
    
    public PersonajeGOT(String nombre, String casa){
        this.nombre = nombre;
        this.casa = casa;
    }
    
    public PersonajeGOT(String nombre){
        this(nombre, null);
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getCasa(){
        return casa;
    }
    public String toString() {
    	return "Nombre: " + nombre + "Casa: " + casa + "\n";
    }

	@Override
	public int compareTo(Object pers) {
		PersonajeGOT p = (PersonajeGOT) pers;
		if(p.getNombre().equals(nombre) && p.getCasa().equals(casa)) {
			return 0;
		}
		return -1;
	}
}