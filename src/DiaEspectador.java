public enum DiaEspectador{
  LUNES(5),
  MARTES(6),
  MIERCOLES(7),
  JUEVES(1),
  VIERNES(2),
  SABADO(3),
  DOMINGO(4);
  
  private final int dia;
  
  DiaEspectador(int dia){
    this.dia = dia;
  }
  
  public int getDia(){
    return dia;
  }
}