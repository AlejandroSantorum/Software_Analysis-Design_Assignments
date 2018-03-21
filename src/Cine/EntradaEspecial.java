/**
 * Implementacion de la clase EntradaEspecial, heredada de Entrada. Permite aplicar
 * descuentos a cierto tipo de personas, como jubilados o discapacitados, especificando
 * la sesion a la que se quiere acceder, el precio base y el descuento que se quiere realizar.
 *
 * @author Alejandro Santorum Varela y David Cabornero Pascual - alejandro.santorum@estudiante.uam.es / david.cabornero@estudiante.uam.es
 *
 */

public class EntradaEspecial extends Entrada{
  /**
   * Atributos de la clase EntradaEspecial:
   */
  private float descuento;
  private TipoEntrada tipoEntrada;
  
  /**
   * Constructor de EntradaEspecial, al que le debemos especificar la sesion 
   * a la que queremos acceder y el tipo de entrada que contiene el descuento
   * a aplicar, pues su precio estandar viene ya determinado por la sesion
   */
  public EntradaEspecial(Sesion sesion, TipoEntrada tipoEntrada){
    super(sesion);
    if(descuento < 0){
      throw new IllegalArgumentException("Descuento menor que cero = " + descuento); 
    }
    this.descuento = tipoEntrada.getDescuento();
  }
  
  /**
   * Devuelve el precio de la entrada, con el descuento aplicado
   * @return Precio de la entrada con el descuento aplicado
   */
  public float getPrecio(){
    return (super.getPrecio() * descuento);
  }
  /**
   * Devuelve el descuento de la entrada (entre 0 y 1)
   * @return Descuento de la entrada (entre 0 y 1)
   */
  public float getDescuento(){
    return descuento;
  }

}
