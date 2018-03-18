public class Butaca{

  private int fila;
  private int columna;
  private Boolean disponible;

  public Butaca(int fila, int columna){
    this.fila = fila;
    this.columna = columna;
    this.disponible = true;
  }

  public int getFila(){
    return fila;
  }
  public int getColumna(){
    return columna;
  }
  public Boolean estaDisponible(){
    return disponible;
  }

  public void ocuparButaca(){
    disponible = false;
  }

}
