import java.util.*;

/**
 * Implementacion de la clase Cartelera, clase opcional en la que se guaradan las
 * peliculas que emite el cine, junto a sus sesiones.
 *
 * @author Alejandro Santorum Varela y David Cabornero Pascual - alejandro.santorum@estudiante.uam.es / david.cabornero@estudiante.uam.es
 *
 */
public class Cartelera{
    /**
     * Atributos de la clase Cartelera:
     */
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Sesion> sesiones;
    
    /**
     * Constructor de la clase Cartelera, a la que no debemos pasarle ningun argumento,
     * ya que tanto las peliculas como las sesiones se iran anyadiendo
     */
    public Cartelera(){
        this.peliculas = new ArrayList<Pelicula>();
        this.sesiones = new ArrayList<Sesion>();
    }
    
    /**
     * Anyade una pelicula ya instanciada al array de peliculas de la cartelera
     * del cine.
     * @param peli Pelicula que anyadimos a la cartelera
     */
    public void addPelicula(Pelicula peli){
        /* Las comprobaciones de errores se realizan antes
         * de llamar a esta funcion */
        peliculas.add(peli);
    }
    
    /**
     * Anyade una sesion ya instanciada que se va a anyadir al array de sesiones
     * de la cartelera.
     * @param ses Sesion que se va a anyadir a la cartelera
     */
    public void addSesion(Sesion ses){
        /* Las comprobaciones de errores se realizan antes
         * de llamar a esta funcion */
        sesiones.add(ses);
    }
    
    /**
     * Borra la pelicula que se le pase como argumento del array de peliculas.
     * @param peli Pelicula que se va a borrar del array
     */
    public void deletePelicula(Pelicula peli){
        peliculas.remove(peli);
    }
    
    /**
     * Borra la sesion que se le pase como argumento del array de sesiones.
     * @param ses Sesion que se va a eliminar
     */
    public void deleteSesion(Sesion ses){
        sesiones.remove(ses);
    }
    
    /**
     * Devuelve el array de sesiones que tiene cierta pelicula en la cartelera.
     * @param peli Pelicula de la que se quieren obtener las sesiones
     * @return Array de sesiones que emiten la pelicula dada
     */
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
    
    /**
     * Devuelve en formato String  todas las sesiones, ordenadas por peliculas
     * @return String con toda la informacione acerca de las sesiones ordenadas
     * por pelicula
     */
    public String toString(){
        ArrayList<Sesion> auxiliar = new ArrayList<Sesion>();
        String aux;
        aux = "\t===== C A R T E L E R A =====\n";
        
        for(Pelicula p: peliculas){
            auxiliar = getSesionesPorPelicula(p);
            
            Collections.sort(auxiliar);
            
            aux += "\n--- SESIONES DE "+p.getTitulo() +" ---\n";
            for(Sesion s: auxiliar){
                aux += ""+s;
            }
        }
        return aux;
    }
    
}