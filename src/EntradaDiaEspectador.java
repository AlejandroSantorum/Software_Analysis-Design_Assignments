public class EntradaDiaEspectador extends Entrada{
  private float descuento;

  public EntradaDiaEspectador(float precio, Pelicula pelicula, float descuento){
    super(precio, pelicula);
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
