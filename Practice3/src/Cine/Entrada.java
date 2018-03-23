/**
 * Implementacion de la clase Entrada, donde se reflejara a que sesion 
 * esta destinada tal entrada y el precio estandar correspondiente a esa sesion.
 *
 * @author Alejandro Santorum Varela y David Cabornero Pascual - alejandro.santorum@estudiante.uam.es / david.cabornero@estudiante.uam.es
 *
 */

public class Entrada{
  /**
   * Atributos de la clase Entrada:
   */
  private float precio;
  private Sesion sesion;
  
  /**
   * Constructor de la clase entrada, a la que unicamente la pasamos la sesion
   * correpondiente, pues el precio base viene determinado por defecto por la propia sesion.
   * @param sesion Sesion a la que accederemos con la entrada
   */
  public Entrada(Sesion sesion){
    this.precio = sesion.getPrecioBase();
    this.sesion = sesion;
  }

  /**
   * Devuelve el precio de la entrada
   * @return Precio de la entrada
   */
  public float getPrecio(){
    return precio;
  }
  
  /**
   * Devuelve la sesion a la que se puede acceder con la entrada
   * @return Sesion de la entrada
   */
  public Sesion getSesion(){
    return sesion;
  }
  
  /**
   * Permite modificar el precio establecido para la entrada
   * @param precio Nuevo precio de la entrada
   */
  public void setPrecio(float precio){
    if(precio < 0){
      throw new IllegalArgumentException("Precio menor que cero = " + precio); 
    }
    this.precio = precio;
  }

}
