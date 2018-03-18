import java.util.*;

public class Sesion{
  private Calendar fecha;
  private Pelicula pelicula;
  private ArrayList<Butaca> butacas;
  private int butacasDisponibles;
  private Sala sala;
  private float precioBase;

  public Sesion(Calendar fecha, Pelicula pelicula, Sala sala, float precioBase){
    this.fecha = fecha;
    this.pelicula = pelicula;
    this.sala = sala;
    this.precioBase = precioBase;
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
  public float getPrecioBase(){
    return precioBase;
  }
  public int getButacasDisponibles(){
    return butacasDisponibles;
  }
  public ArrayList getButacas(){
    return butacas;
  }
  public int getNumeroButacasVendidas(){
    return butacas.size()-butacasDisponibles;
  }
  public Boolean equals(Sesion sesion){
    if(this.fecha==sesion.fecha && this.pelicula.equals(sesion.pelicula) && this.sala.equals(sesion.sala)) return true;
    return false;
  }


  public Boolean actualizarButacasVendidas(int nEntradas){
    Butaca aux;
    int i, j;
    
    if(butacasDisponibles < nEntradas) return false;
    
    for(i=0, j=0; j<butacas.size() || i<nEntradas; j++){
      aux = butacas.get(j);
      if(aux.estaDisponible()){
        aux.ocuparButaca();
        i++;
      }
    }
    for(Butaca b: butacas){
      if(b.estaDisponible()){
        b.ocuparButaca();
        butacasDisponibles -= 1;
        return true;
      }
    }
    return false; /* No hay butacas disponibles */
  }

}
