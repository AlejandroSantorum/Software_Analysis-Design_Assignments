public class Entrada{
  private float precio;
  private Sesion sesion;

  public Entrada(Sesion sesion){
    this.precio = sesion.getPrecioBase();
    this.sesion = sesion;
  }

  public float getPrecio(){
    return precio;
  }
  
  public Sesion getSesion(){
    return sesion;
  }

  public void setPrecio(float precio){
    this.precio = precio;
  }

}
