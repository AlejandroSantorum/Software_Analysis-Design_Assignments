import java.util.*;

public class Sesion{
  private Calendar fecha;
  private Pelicula pelicula;
  private ArrayList<Butaca> butacas;
  private int butacasDisponibles;
  private Sala sala;

  public Sesion(Calendar fecha, Pelicula pelicula, Sala sala){
    this.fecha = fecha;
    this.pelicula = pelicula;
    this.sala = sala;
    butacas = new ArrayList<Butaca>();
    butacasDisponibles = 0;

    for(int i=0; i<sala.getFilasTotales(); i += 1){
      for(int j=0; j<sala.getColumnasTotales(); j += 1){
        butacas.add(new Butaca(i+1, j+1)); /* Las filas van de 1 a n_filas */
                                           /* las columnas van de 1 a n_columnas */
        butacasDisponibles += 1;
      }
    }
  }

  public Calendar getFecha(){
    return fecha;
  }
  public Pelicula getPelicula(){
    return pelicula;
  }
  public Sala getSala(){
    return sala;
  }
  public int getButacasDisponibles(){
    return butacasDisponibles;
  }
  public ArrayList getButacas(){
    return butacas;
  }
  public Boolean equals(Sesion sesion){
    if(this.fecha==sesion.fecha && this.pelicula.equals(sesion.pelicula) && this.sala.equals(sesion.sala)) return true;
    return false;
  }





  public Boolean actualizarButacasVendidas(int fila, int columna){
    for(Butaca b: butacas){
      if(b.getFila()==fila && b.getColumna==columna){
        if(b.estaDisponible()){
          b.ocuparButaca();
          butacasDisponibles -= 1;
          return true;
        }else{
          return false;
        }
      }
      return false;
    }
  }

  public Boolean actualizarButacasVendidas(){
    for(Butaca b: )
  }




  /* ¿ public ArrayList getButacasDisponibles ? */

}
