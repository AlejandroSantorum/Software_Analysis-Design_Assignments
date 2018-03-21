import java.util.*;

/**
 * Implementacion de la clase Sesion, que contendra toda la informacion relativa
 * a su fecha, su sala, su aforo, sus butacas ocupadas, la pelicula que se va a 
 * ver o el precio. Ademas, hemos visto oportuno incluir las butacas que estan ocupadas
 * o no segun su fila y columna.
 *
 * @author Alejandro Santorum Varela y David Cabornero Pascual - alejandro.santorum@estudiante.uam.es / david.cabornero@estudiante.uam.es
 *
 */
public class Sesion{
  /**
   * Atributos de la clase Sesion:
   */
  private GregorianCalendar fecha;
  private Pelicula pelicula;
  private ArrayList<Butaca> butacas;
  private int butacasDisponibles;
  private Sala sala;
  private float precioBase;

  /**
   * Constructor de la clase sesion, que la inicializa segun su fecha, su pelicula,
   * su sala y su precio estandar.
   * @param fecha Dia y hora de la sesion.
   * @param pelicula Pelicula que se va a emitir
   * @param sala Sala en la que se emite la pelicula
   * @param precioBase Precio sin descuentos de una entrada
   */
  public Sesion(GregorianCalendar fecha, Pelicula pelicula, Sala sala, float precioBase){
    if(precioBase <= 0){
      throw new IllegalArgumentException("Precio base menor o igual a cero --> precioBase = " + precioBase); 
    }
    this.fecha = fecha;
    this.pelicula = pelicula;
    this.sala = sala;
    this.precioBase = precioBase;
    butacas = new ArrayList<Butaca>();
    butacasDisponibles = 0;

    for(int i=0; i<sala.getFilasTotales(); i += 1){
      for(int j=0; j<sala.getColumnasTotales(); j += 1){
        butacas.add(new Butaca(i+1, j+1)); /* Las filas van de 1 a n_filas */
                                           /* las columnas van de 1 a n_columnas */
        butacasDisponibles += 1;
      }
    }
  }
  
  /**
   * Devuelve la fecha y hora en la que la sesion se lleva a cabo
   * @return Fecha y hora de la sesion
   */
  public GregorianCalendar getFecha(){
    return fecha;
  }
  /**
   * Devuelve la pelicula que se emite en la sesion
   * @return Pelicula de la sesion
   */
  public Pelicula getPelicula(){
    return pelicula;
  }
  /**
   * Devuelve la sala en la que la sesion va a ser llevada a cabo
   * @return Sala de la sesion
   */
  public Sala getSala(){
    return sala;
  }
  /**
   * Devuelve el precio que cuesta la sesion sin ningun descuento
   * @return Precio sin descuentos de la pelicula
   */
  public float getPrecioBase(){
    return precioBase;
  }
  /**
   * Devuelve las butacas que quedan disponibles para la sesion
   * @return Butacas disponibles para el aforo completo de la sesion
   */
  public int getButacasDisponibles(){
    return butacasDisponibles;
  }
  /**
   * Devuelve el array de butacas que tiene la sesion. La sesion es la que dispone
   * del array de butacas y no la sala en si, pues lo que nos interesa es si estan
   * ocupadas o no para cierta sesion.
   * @return Array de butacas de la sesion
   */
  public ArrayList getButacas(){
    return butacas;
  }
  /**
   * Devuelve el numero de butacas vendidas para la sesion
   * @return Butacas vendidas para la sesion
   */
  public int getNumeroButacasVendidas(){
    return butacas.size()-butacasDisponibles;
  }
  /**
   * Muestra si una sesion es igual a otra sesion ya creada.
   * @param sesion Sesion con la que queremos comparar nuestra sesion
   * @return True si las sesiones son iguales, False si son distintas
   */
  public Boolean equals(Sesion sesion){
    if(this.fecha==sesion.fecha && this.pelicula.equals(sesion.pelicula) && this.sala.equals(sesion.sala)) return true;
    return false;
  }

  /**
   * Se dan el numero de entradas que se van a vender en cierto momento,
   * y se marcan como ocupadas las butacas contiguas a las ultimas ocupadas.
   * @param nEntradas numero de entradas que se van a vender
   * @return True si hay butacas disponibles, False si no ha sido posible llevar 
   * a cabo la operacion por limite de aforo.
   */
  public Boolean actualizarButacasVendidas(int nEntradas){
    if(nEntradas <= 0){
      throw new IllegalArgumentException("Numero de entradas menor o igual que cero --> nEtradas = "+nEntradas); 
    }
    
    if(butacasDisponibles < nEntradas) return false;
    
    int i;
    
    for(i=0; i<nEntradas; i++){
      for(Butaca b: butacas){
        if(b.estaDisponible()){
          b.ocuparButaca();
          butacasDisponibles -= 1;
          break;
        }
      }
    }
    return true;
  }

}
