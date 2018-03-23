/**
 * Implementacion de la clase EntradaDiaEspectador, heredada de Entrada, pues
 * esta es un tipo de entrada especial que crearemos el dia del espectador y 
 * que tendra su propio descuento.
 *
 * @author Alejandro Santorum Varela y David Cabornero Pascual - alejandro.santorum@estudiante.uam.es / david.cabornero@estudiante.uam.es
 *
 */

public class EntradaDiaEspectador extends Entrada{
  /**
   * Atributos de la clase EntradaDiaEspectador:
   */
  private float descuento;

  /**
   * Constructor de la clase EntradaDiaEspectador, a la que le pasamos la sesion
   * a la que queremos acceder con esta pelicula y el descuento que queremos aplicar
   * @param sesion Sesion a la que queremos acceder
   * @param descuento Descuento aplicado a la entrada (entre 0 y 1)
   */
  public EntradaDiaEspectador(Sesion sesion, float descuento){
    super(sesion);
    if(descuento < 0){
      throw new IllegalArgumentException("Descuento menor que cero = " + descuento); 
    }
    this.descuento = descuento;
  }

  /**
   * Devuelve el precio de la entrada
   * @return Precio de la entrada
   */
  public float getPrecio(){
    return (super.getPrecio() * descuento);
  } 

  /**
   * Devuelve el descuento aplicado a la entrada
   * @return Descuento de la entrada(entre 0 y 1)
   */
  public float getDescuento(){
    return descuento;
  }
  
  /**
   * Permite cambiar el descuento aplicado a la entrada
   * @param descuento Nuevo descuento de la entrada(entre 0 y 1)
   */
  public void setDescuento(float descuento){
    if(descuento < 0){
      throw new IllegalArgumentException("Descuento menor que cero = " + descuento); 
    }
    this.descuento = descuento;
  }

}
