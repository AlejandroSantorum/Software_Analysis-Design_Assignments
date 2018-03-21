import java.util.*;

/**
 * Implementacion de la clase Sala, donde guardaremos la informacion relativa a cada
 * una de las salas que componen el cine, indexandolas y mostrando tanto sus
 * filas como sus columnas, asi como las sesiones que son llevadas a cabo en ella.
 *
 * @author Alejandro Santorum Varela y David Cabornero Pascual - alejandro.santorum@estudiante.uam.es / david.cabornero@estudiante.uam.es
 *
 */
public class Sala{
  /**
   * Atributos de la clase Sala:
   */
  private final int id;
  private int filasTotales;
  private int columnasTotales;
  private ArrayList<Sesion> sesiones;

  /**
   * Constructor de la clase Sala, al que se le pasa su identificador, su numero de
   * filas y su numero de columnas. En el momento de su creacion no hay ninuna sesion
   * vinculada a esta sala.
   * @param id Identificador de la sala en el cine
   * @param filas Filas de la sala
   * @param columnas Columnas de la sala
   */
  public Sala(int id, int filas, int columnas){
    if(filas <= 0 || columnas <= 0){
      throw new IllegalArgumentException("Numero de filas o columnas menor que cero-> Numero Filas = "+filas+" Numero Columnas = "+columnas); 
    }
    this.id = id;
    filasTotales = filas;
    columnasTotales = columnas;
    sesiones = new ArrayList<Sesion>();
  }

  /**
   * Devuelve el identificador de la sala
   * @return Identificador de la sala
   */
  public int getId(){
    return id;
  }
  /**
   * Devuelve el numero de filas de la sala
   * @return Numero de filas de la sala
   */
  public int getFilasTotales(){
    return filasTotales;
  }
  /**
   * Devuelve el numero de columnas de la sala
   * @return Numero de columnas de la sala
   */
  public int getColumnasTotales(){
    return columnasTotales;
  }
  /**
   * Devuelve el numero total de butacas de la sala
   * @return Numero total de butacas de la sala
   */
  public int getNumeroButacas(){
    return filasTotales * columnasTotales;
  }
  /**
   * Devuelve el array de sesiones llevadas a cabo en esta sala
   * @return Sesiones llevadas a cabo en esta sala
   */
  public ArrayList<Sesion> getSesiones(){
    return sesiones;
  }
  /**
   * Permite saber si la sala es igual a otra sala dada.
   * @param sala Sala con la que se pretende comparar nuestra sala
   * @return true si las salas son la misma, false si son distintas
   */
  public Boolean equals(Sala sala){
    if(this.id == sala.id) return true;
    return false;
  }
  
  /**
   * Permite anyadir una nueva sesion a nuestra sala
   * @param sesion Sesion a anyadir en la sala
   * @return false si ya existe otra sesion con la misma fecha y hora en esta sala
   * true en caso contrario (no hay mas errores posibles)
   */
  public Boolean addSesion(Sesion sesion){
    for(Sesion s: sesiones){
      if(s.getFecha() == sesion.getFecha()){
        return false;
      }
    }
    sesiones.add(sesion);
    return true;
  }
  
  /**
   * Permite averiguar si nuestra sala contiene en su array cierta sesion
   * @param sesion Sesion que queremos saber si pertenece al array de sesiones de la sala
   * @return true si la sesion ya esta contenida en el array, false en caso contrario
   */
  public Boolean contieneSesion(Sesion sesion){
    for(Sesion s: sesiones){
      if(s.equals(sesion)){
        return true;
      }
    }
    return false;
  }

  /**
   * Borramos todas las sesiones del array de sesiones que emitan cierta pelicula
   * @param pelicula Pelicula de la que se quieren eliminar todas sus sesiones
   */
  public void deletePelicula(Pelicula pelicula){
    Iterator<Sesion> iter = sesiones.iterator();

    /* Comprobamos si en alguna sesion de la sala
    * se emite la pelicula a eliminar.
    * Si existe, es eliminada */
    while(iter.hasNext()){
      if(pelicula.equals(iter.next().getPelicula())) {
        iter.remove();
      }
    }

    return;
  }

  /**
   * Borramos cierta sesion del array de sesiones
   * @param sesion Sesion a borrar del array
   */
  public void deleteSesion(Sesion sesion){
    sesiones.remove(sesion);
  }

}
