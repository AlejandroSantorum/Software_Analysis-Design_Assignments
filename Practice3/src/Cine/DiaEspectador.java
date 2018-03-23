import java.util.Calendar;
/**
 * Implementacion de la enumeracion DiaEspectador, una enumeracion especial utilizada
 * para que nuestro cine pueda indicar cual quiere ser su dia del espectador.
 *
 * @author Alejandro Santorum Varela y David Cabornero Pascual - alejandro.santorum@estudiante.uam.es / david.cabornero@estudiante.uam.es
 *
 */

public enum DiaEspectador{
  /**
   * Atributos de la enumeracion DiaEspectador
   */
  LUNES(Calendar.MONDAY),
  MARTES(Calendar.TUESDAY),
  MIERCOLES(Calendar.WEDNESDAY),
  JUEVES(Calendar.THURSDAY),
  VIERNES(Calendar.FRIDAY),
  SABADO(Calendar.SATURDAY),
  DOMINGO(Calendar.SUNDAY);
  
  private final int dia;
  
  /**
   * Constructor de DiaEspectador, en el que se necesita un entero para indicar el dia
   * de la semana
   * @param dia dia de la semana que sera dia del espectador
   */
  DiaEspectador(int dia){
    this.dia = dia;
  }
  
  /**
   * Da el dia de la semana
   * @return Dia de la semana
   */
  public int getDia(){
    return dia;
  }
}