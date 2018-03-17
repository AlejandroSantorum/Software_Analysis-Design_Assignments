public class Pelicula{
  private String titulo;
  private String director;
  private int anno;
  private String sinopsis;
  private Genero genero;

  public Pelicula(String titulo, String director, int anno, String sinopsis, Genero genero){
    this.titulo = titulo;
    this.director = director;
    this.anno = anno;
    this.sinopsis = sinopsis;
    this.genero = genero;
  }

  public String getTitulo(){
    return titulo;
  }
  public String getDirector(){
    return director;
  }
  public int getAnno(){
    return anno;
  }
  public String getSinopsis(){
    return sinopsis;
  }
  public Genero getGenero(){
    return genero;
  }
  public void setSinopsis(String sinopsis){
    this.sinopsis = sinopsis;
  }
  public Boolean equals(Pelicula peli){
    if(peli.titulo==this.titulo && peli.director==this.director && peli.anno==this.anno) return true;
    return false;
  }
  public String toString(){
    String aux;
    
    aux = "=====================================\n";
    aux = aux + "TITULO: "+titulo+"\n";
    aux = aux + "-------------------------------------\n"
    aux = aux + "DIRECTOR: "+director+"\n";
    aux = aux + "ANIO: "+anno+"\n";
    aux = aux + "GENERO: "+genero+"\n";
    aux = aux + "SINOPSIS: "+sinopsis;
    return aux;
  }

}
