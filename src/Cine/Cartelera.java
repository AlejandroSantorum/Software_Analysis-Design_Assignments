import java.util.*;

public class Cartelera{
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Sesion> sesiones;
    
    public Cartelera(){
        this.peliculas = new ArrayList<Pelicula>();
        this.sesiones = new ArrayList<Sesion>();
    }
    
    public void addPelicula(Pelicula peli){
        /* Las comprobaciones de errores se realizan antes
         * de llamar a esta funcion */
        peliculas.add(peli);
    }
    
    public void addSesion(Sesion ses){
        /* Las comprobaciones de errores se realizan antes
         * de llamar a esta funcion */
        sesiones.add(ses);
    }
    
    public void deletePelicula(Pelicula peli){
        peliculas.remove(peli);
    }
    
    public void deleteSesion(Sesion ses){
        sesiones.remove(ses);
    }
    
    public ArrayList<Sesion> getSesionesPorPelicula(Pelicula peli){
        ArrayList<Sesion> auxiliar = new ArrayList<Sesion>();
        int flag = 0;
        
        for(Sesion ses: sesiones){
            if(ses.getPelicula().equals(peli)){
                auxiliar.add(ses);
                flag = 1;
            }
        }
        if(flag==0){
            System.err.println("Error. La pelicula no existe en la cartelera");
            return null;
        }
        return auxiliar;
    }
    
    public void mostrarCartelera(){
        ArrayList<Sesion> auxiliar = new ArrayList<Sesion>();
        
        for(Pelicula p: peliculas){
            auxiliar = getSesionesPorPelicula(p);
            
            Collections.sort(auxiliar);
            
            System.out.println("=== SESIONES DE "+p.getTitulo() +" ===\n");
            for(Sesion s: auxiliar){
                System.out.println(s);
                System.out.println(" ");
            }
        }
    }
    
}