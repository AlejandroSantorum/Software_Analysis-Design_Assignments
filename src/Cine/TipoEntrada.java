/**
 * Implementacion de la enumeracion TipoEntrada, que facilitara la implementacion
 * de Cine y la Aplicacion, pues permitira preestablecer un descuento determinado
 * a cada tipo de descuento.
 * 
 * @author Alejandro Santorum Varela y David Cabornero Pascual - alejandro.santorum@estudiante.uam.es / david.cabornero@estudiante.uam.es
 *
 */

public enum TipoEntrada{
    /**
    * Valores internos de la enumeracion TipoEntrada:
    */
    ESTUDIANTE(0.7f),
    FIESTA(0.8f),
    MAYORES(0.7f),
    MINUSVALIDO(0.5f),
    NORMAL(1f);
    
    /**
     * Atributos de la enumeracion TipoEntrada:
     */
    private float descuento;
    
    /**
     * Constructor de la enumeracion TipoEntrada, a la que se le pasa un cierto
     * descuento.
     * @param descuento Descuento asociado (entre 0 y 1)
     */
    TipoEntrada(float descuento){
        if(descuento < 0){
            throw new IllegalArgumentException("Descuento menor que cero = " + descuento); 
        }
        this.descuento = descuento;
    }
    /**
     * Devuelve el descuento correspondiente
     * @return Descuento asociado (entre 0 y 1)
     */
    public float getDescuento(){
        return descuento;
    }
    /**
     * Permite modificar el descuento
     * @param descuento El nuevo descuento (entre 0 y 1)
     */
    public void setDescuento(float descuento){
        if(descuento < 0){
            throw new IllegalArgumentException("Descuento menor que cero = " + descuento); 
        }
        this.descuento = descuento;
    }
}
