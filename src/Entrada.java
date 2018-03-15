public class Entrada{
  private float precio;
  private Pelicula pelicula;

  public Entrada(float precio, Pelicula pelicula){
    this.precio = precio;
    this.pelicula = pelicula;
  }

  public float getPrecio(){
    return precio;
  }

  public void setPrecio(float precio){
    this.precio = precio;
  }

}
