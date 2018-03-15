import java.util.*;

public class Sala{
  private final int id;
  private int filasTotales;
  private int columnasTotales;
  private ArrayList<Sesion> sesiones;

  public Sala(int id, int filas, int columnas){
    this.id = id;
    filasTotales = filas;
    columnasTotales = columnas;
    sesiones = ArrayList<Sesion>();
  }

  public int getId(){
    return id;
  }
  public int getFilasTotales(){
    return filasTotales;
  }
  public int getColumnasTotales(){
    return columnasTotales;
  }
  public int getNumeroButacas(){
    return filasTotales * columnasTotales;
  }
  public ArrayList<Sesion> getSesiones(){
    return sesiones;
  }
  public Boolean equals(Sala sala){
    if(this.id == sala.id) return true;
    return false;
  }

  public Boolean addSesion(Sesion sesion){
    for(Sesion s: sesiones){
      if(s.getFecha() == sesion.getFecha){
        return false;
      }
    }
    sesiones.add(sesion);
    return true;
  }

  public Boolean contieneSesion(Sesion sesion){
    for(Sesion s: sesiones){
      if(s.equals(sesion)){
        return true;
      }
    }
    return false;
  }


  public void deletePelicula(Pelicula pelicula){
    Iterator<Sesion> iter = sesiones.iterator();

    /* Comprobamos si en alguna sesion de la sala
    * se emite la pelicula a eliminar.
    * Si existe, es eliminada */
    while(iter.hasNext()){
      if(s.getPelicula.equals(iter.next())) {
        iter.remove();
      }
    }

    return;
  }


  public void deleteSesion(Sesion sesion){
    sesiones.remove(sesion);
  }




}
