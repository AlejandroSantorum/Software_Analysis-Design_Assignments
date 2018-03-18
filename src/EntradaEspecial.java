public class EntradaEspecial extends Entrada{
  private float descuento;

  public EntradaEspecial(Sesion sesion, float descuento){
    super(sesion);
    this.descuento = descuento;
  }

  public float getPrecio(){
    return (super.getPrecio() * descuento);
  }

  public float getDescuento(){
    return descuento;
  }

  public void setDescuento(float descuento){
    this.descuento = descuento;
  }

}
