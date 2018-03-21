/**
 * Implementacion de la clase Butaca, necesaria para nuestra implementacion de la clase Sala
 * y la clase Sesion. Disponemos de la informacion correspondiente a su fila y columna asociada,
 * ademas de si esta se encuentra ocupada o no.
 *
 * @author Alejandro Santorum Varela y David Cabornero Pascual - alejandro.santorum@estudiante.uam.es / david.cabornero@estudiante.uam.es
 *
 */

public class Butaca{
  /**
   * Atributos de la clase Butaca:
   */
  private int fila;
  private int columna;
  private Boolean disponible;
  
  /**
   * Constructor de la clase Butaca, a la que se la pasa su fila y su columna correspondiente.
   * Al crear una entrada la butaca siempre esta disponible.
   * @param fila Fila de la sala en la que se encuentra
   * @param columna Columna de la sala en la que se encuentra
   */
  public Butaca(int fila, int columna){
    if(fila < 0 || columna < 0){
      throw new IllegalArgumentException("Numero de fila o columna menor que cero-> Fila = "+fila+" Columna = "+columna); 
    }
    this.fila = fila;
    this.columna = columna;
    this.disponible = true;
  }
  
  /**
   * Devuelve la fila de la butaca en la sala
   * @return Fila de la butaca en la sala
   */
  public int getFila(){
    return fila;
  }
  /**
   * Devuelve la columna de la butaca en la sala
   * @return Columna de la butaca en la sala
   */
  public int getColumna(){
    return columna;
  }
  /**
   * Indica si una butaca esta disponible
   * @return true si la butaca esta disponible, false si no
   */
  public Boolean estaDisponible(){
    return disponible;
  }
  
  /**
   * Permite ocupar la butaca
   */
  public void ocuparButaca(){
    disponible = false;
  }

}
