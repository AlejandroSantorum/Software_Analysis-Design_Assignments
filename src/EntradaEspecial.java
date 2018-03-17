public class EntradaEspecial extends Entrada{
  private float descuento;

  public EntradaEspecial(float precio, Sesion sesion, float descuento){
    super(precio, sesion);
    this.descuento = descuento;
  }

  public float getPrecio(){
    return descuento * this.super();
  }

  public getDescuento(){
    return descuento;
  }

  public setDescuento(float descuento){
    this.descuento = descuento;
  }

}
