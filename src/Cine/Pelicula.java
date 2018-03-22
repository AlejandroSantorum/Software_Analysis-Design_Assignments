/**
 * Implementacion de la clase Pelicula, que trata a cada pelicula de manera 
 * individual. Dara toda la informacion relevante de la pelicula, sin tener en cuenta
 * atributos del propio cine, como salas en las que se proyectan u horarios.
 *
 * @author Alejandro Santorum Varela y David Cabornero Pascual - alejandro.santorum@estudiante.uam.es / david.cabornero@estudiante.uam.es
 *
 */

public class Pelicula{
  /**
   * Atributos de la clase Pelicula:
   */
  private String titulo;
  private String director;
  private int anno;
  private String sinopsis;
  private Genero genero;

  /**
   * Constructor de la clase Pelicula, donde se inicializan los atributos
   * @param titulo Titulo de la pelicula
   * @param director Director de la pelicula
   * @param anno Anyo del estreno de la pelicula
   * @param sinopsis Sinopsis de la pelicula
   * @param genero Genero al que pertenece la pelicula
   */
  public Pelicula(String titulo, String director, int anno, String sinopsis, Genero genero){
    if(anno <= 0){
      throw new IllegalArgumentException("Numero del año incorrecto = "+anno); 
    }
    this.titulo = titulo;
    this.director = director;
    this.anno = anno;
    this.sinopsis = sinopsis;
    this.genero = genero;
  }
  
  /**
   * Devuelve el titulo de la pelicula
   * @return Titulo de la pelicula
   */
  public String getTitulo(){
    return titulo;
  }
  /**
   * Devuelve el director de la pelicula
   * @return Director de la pelicula
   */
  public String getDirector(){
    return director;
  }
  /**
   * Devuelve el anyo de lanzamiento de la pelicula
   * @return Anyo de lanzamiento de la pelicula
   */
  public int getAnno(){
    return anno;
  }
  /**
   * Devuelve la sinopsis de la pelicula
   * @return Sinopsis de la pelicula
   */
  public String getSinopsis(){
    return sinopsis;
  }
  /**
   * Devuelve el genero de la pelicula
   * @return Genero de la pelicula
   */
  public Genero getGenero(){
    return genero;
  }
  /**
   * Cambia la sinopsis de la pelicula
   * @param sinopsis Sinopsis de la pelicula
   */
  public void setSinopsis(String sinopsis){
    this.sinopsis = sinopsis;
  }
  /**
   * Pasa a formato String la Pelicula, indicando todos sus atributos de forma
   * ordenada.
   * @return String de la pelicula con sus caracteristicas.
   */
  public String toString(){
    String aux;
    
    aux = "=====================================\n";
    aux = aux + "TITULO: "+titulo+"\n";
    aux = aux + "-------------------------------------\n";
    aux = aux + "DIRECTOR: "+director+"\n";
    aux = aux + "ANIO: "+anno+"\n";
    aux = aux + "GENERO: "+genero+"\n";
    aux = aux + "SINOPSIS: "+sinopsis+"\n";
    return aux;
  }
  
  /**
   * Permite saber si la pelicula es igual a otra pelicula dada.
   * @param peli Pelicula con la que se pretende comparar nuestra pelicula
   * @return True si las peliculas son iguales, False si son distintas
   */
  public Boolean equals(Pelicula peli){
    if(peli.titulo==this.titulo && peli.director==this.director && peli.anno==this.anno) return true;
    return false;
  }
  

}
