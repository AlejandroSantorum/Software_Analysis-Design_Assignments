import java.util.*;

/**
 * Implementacion de la clase Cine, donde se encuetran todos los atributos relativos
 * a su identidad, como su nombre o su direccion. Ademas, en el podremos encontrar
 * todas sus peliculas, sus salas, sus entradas vendidas, su particular dia del espectador
 * y su tambien particular descuento realizado el dia del espectador.
 *
 * @author Alejandro Santorum Varela y David Cabornero Pascual - alejandro.santorum@estudiante.uam.es / david.cabornero@estudiante.uam.es
 *
 */
public class Cine{
  /**
   * Atributos de la clase Cine
   */
  private String nombre;
  private String direccion;
  private ArrayList<Pelicula> listaPeliculas;
  private ArrayList<Sala> listaSalas;
  private ArrayList<Entrada> listaEntradas;
  private Cartelera cartelera;
  private DiaEspectador diaEspectador;
  private float descuentoDiaEspectador;
  
  /**
   * Constructor de la clase Cine, donde debemos dar los datos del cine relativos a su
   * identidad, es decir, su nombre, su direccion y su dia del espectador. Sus salas, sesiones...
   * apareceran vacias al instanciar el cine, y el descuento de dia del espectador
   * aparecera por defecto como un descuento del 20%
   * @param nombre Nombre del cine
   * @param direccion Direccion del cine
   * @param diaEspectador Dia del espectador del cine
   */
  public Cine(String nombre, String direccion, DiaEspectador diaEspectador){
    this.nombre = nombre;
    this.direccion = direccion;
    this.listaPeliculas = new ArrayList<Pelicula>();
    this.listaSalas = new ArrayList<Sala>();
    this.listaEntradas = new ArrayList<Entrada>();
    this.cartelera = new Cartelera();
    this.diaEspectador = diaEspectador;
    this.descuentoDiaEspectador = 0.8f; /* Por defecto */
  }
  /**
   * Devuelve el nombre del cine
   * @return Nombre del cine
   */
  public String getNombre(){
    return nombre;
  }
  /**
   * Devuelve la direccion del cine
   * @return Direccion del cine
   */
  public String getDireccion(){
    return direccion;
  }
  /**
   * Devuelve la cartelera del cine
   * @return Cartelera del cine
   */
  public Cartelera getCartelera(){
    return cartelera;
  }
  /**
   * Devuelve la lista de peliculas del cine
   * @return Lista de peliculas del cine
   */
  public ArrayList<Pelicula> getPeliculas(){
    return listaPeliculas;
  }
  /**
   * Devuelve la lista de salas del cine
   * @return Lista de salas del cine
   */
  public ArrayList<Sala> getSalas(){
    return listaSalas;
  }
  /**
   * Devuelve la lista de entradas del cine
   * @return Lista de entradas del cine
   */
  public ArrayList<Entrada> getEntradas(){
    return listaEntradas;
  }
  /**
   * Devuelve la lista de sesiones del cine
   * @return Lista de sesiones del cine
   */
  public ArrayList<Sesion> getSesiones(){
    ArrayList<Sesion> sesiones = new ArrayList<Sesion>();
    
    for(Sala s: listaSalas){
      sesiones.addAll(s.getSesiones());
    }
    return sesiones;
  }
  
  /**
   * Permite modificar el dia del espectador del cine
   * @param diaEspectador Nuevo dia del espectador del cine 
   */
  public void setDiaEspectador(DiaEspectador diaEspectador){
    this.diaEspectador = diaEspectador;
  }
  /**
   * Permite modificar el descuento del dia del espectador del cine
   * @param descuentoDE Nuevo descuento del dia del espectador (del 0 a 1)
   */
  public void setDescuentoDiaEspectador(float descuentoDE){
    this.descuentoDiaEspectador = descuentoDE;
  }
  /**
   * Convierte en String un cine, mostrando de forma ordenada su nombre,
   * su direccion, su dia del espectador y su correspondiente descuento
   */
  public String toString(){
    String aux;
    
    aux = "Nombre CINE: "+nombre+"\n";
    aux = aux+"Direccion: "+direccion+"\n";
    aux = aux+"Dia del espectador: "+diaEspectador+"\n";
    aux = aux+"Descuento dia espectador: "+descuentoDiaEspectador+"\n";
    return aux;
  }
  
  /**
   * Anyade una cierta pelicula al cine, instanciandola en el momento y anyadiendola
   * a su array, por lo que los argumentos que recibe la funcion son los necesarios para
   * construir una nueva pelicula.
   * @param titulo Titulo de la pelicula
   * @param director Director de la pelicula
   * @param anno Anyo de lanzamiento de la pelicula
   * @param sinopsis Sinopsis de la pelicula
   * @param genero Genero de la pelicula
   * @return false si ya esta incluida esa pelicula, true en caso contrario
   */
  public Boolean anadirPelicula(String titulo, String director, int anno, String sinopsis, Genero genero){
    for(Pelicula p: listaPeliculas){ /* Comprobamos que no existe ya esa pelicula */
      if(p.getTitulo()==titulo && p.getDirector()==director && p.getAnno()==anno){
        System.err.println("Lo siento, la pelicula ya existe.\n");
        return false;
      }
    }

    /* Creamos pelicula y la añadimos a la lista de peliculas del cine */
    Pelicula peli = new Pelicula(titulo, director, anno, sinopsis, genero);
    if(peli==null){
      System.err.println("Error de memoria. Constructor Pelicula en anadirPelicula() ha fallado");
      return false;
    }
    listaPeliculas.add(peli);
    cartelera.addPelicula(peli);
    System.out.println("Pelicula añadida con éxito.\n");
    return true;
  }


  /**
   * Anyade una sesion de una determinada pelicula en una determinada sala, con un cierto precio
   * en una cierta fecha y hora. Se instanciara en el momento.
   * @param fecha Fecha y hora de comienzo de la sesion
   * @param pelicula Pelicula que se emitira en la sesion
   * @param sala Sala de la sesion
   * @param precioBase precio estandar que cuesta una entrada de esta sesion
   * @return false si la pelicula o la sala no existen, o si la sala ya esta ocupada
   * a esa hora ese dia; true en caso contrario
   */
  public Boolean anadirSesion(GregorianCalendar fecha, Pelicula pelicula, Sala sala, float precioBase){
    int flag=0;

    for(Sala s: listaSalas){ /* Comprobamos que la sala existe */
      if(sala.equals(s)){
        flag=1;
        break;
      }
    }
    if(flag==0){
      System.err.println("Lo siento, la sala a la que se intenta añadir una sesion no existe\n");
      return false;
    }

    flag=0;
    for(Pelicula p: listaPeliculas){ /* Comprobamos que la pelicula existe */
      if(p.equals(pelicula)){
        flag=1;
        break;
      }
    }
    if(flag==0){
      System.err.println("Lo siento, la pelicula introducida no existe\n");
      return false;
    }

    Sesion sesion = new Sesion(fecha, pelicula, sala, precioBase); /* Creamos sesion */
    if(sesion==null){
      System.err.println("Error de memoria. Constructor Sesion en anadirSesion() ha fallado");
      return false;
    }
    /* Añadimos sesion a la sala*/
    if(!sala.addSesion(sesion)){
      /* Control de errores: no puede haber dos sesiones
       * a la misma hora de un dia en una misma sala */
      System.err.println("Lo siento, la sala ya tiene una sesion en el momento seleccionado\n");
      return false;
    }
    cartelera.addSesion(sesion);
    System.out.println("Sesion añadida con exito\n");
    return true;
  }

  /**
   * Anyade una nueva sala al cine, instanciandola en el momenento, por lo que se 
   * pasaran los argumentos necesarios para instanciar dicha sala.
   * @param id Identificador de la sala
   * @param filas Filas de la sala
   * @param columnas Columnas de la sala
   * @return false si ya hay una sala con ese identificador o si no hay al menos una fila o una
   * columna, true en caso contrario
   */
  public Boolean anadirSala(int id, int filas, int columnas){
    if(filas <= 0 || columnas <= 0){
      System.err.println("Lo siento, debe haber al menos una fila y una columna en la sala");
      return false;
    }
    for(Sala s: listaSalas){
      if(s.getId()==id){
        System.err.println("Lo siento, ya existe una sala con ese identificador\n");
        return false;
      }
    }

    /* Si la sala no existe, la creamos */
    Sala sala = new Sala(id, filas, columnas);
    /* Introducimos la sala en la lista de salas del cine */
    listaSalas.add(sala);
    System.out.println("Sala añadida con exito\n");
    return true;
  }

  /**
   * Elimina cierta pelicula del array de peliculas, asi como las sesiones
   * de de cada sala que tienen esa pelicula.
   * @param pelicula Pelicula que se quiere eliminar
   * @return false si la pelicula no existia en el array, true en caso contrario
   */
  public Boolean eliminarPelicula(Pelicula pelicula){
    if(!listaPeliculas.contains(pelicula)) return false;

    /* Comprobamos en cada sala si tiene una o mas sesiones
    * con la pelicula a eliminar. Si la hay, la sesion es
    * eliminada de la lista de sesiones */
    for(Sala sala: listaSalas){
      sala.deletePelicula(pelicula);
    }
    /* Eliminamos la pelicula de la lista de peliculas */
    listaPeliculas.remove(pelicula);
    cartelera.deletePelicula(pelicula);
    System.out.println("Pelicula eliminada con exito\n");
    return true;
  }

  /**
   * Elimina cierta sesion del array de sesiones, asi como tambien se elimina
   * de su correspondiente sala.
   * @param sesion Sesion a eliminar
   * @return true si la sesion existe en una sala, false en caso contrario
   */
  public Boolean eliminarSesion(Sesion sesion){
    /* Buscamos la sesion en la lista de sesiones.
    * si la encontramos, primero eliminamos dicha sesion
    * del array de sesiones de su sala, y despues, la
    * suprimimos de la lista de sesiones del cine */
    for(Sala s: listaSalas){
      if(s.contieneSesion(sesion)){
        s.deleteSesion(sesion);
        cartelera.deleteSesion(sesion);
        System.out.println("Sesion eliminada con exito.\n");
        return true;
      }
    }
    return false;
  }

  /**
   * Elimina cierta sala del array de salas. Como no tenemos un array de sesiones
   * en el cine, las sesiones estan asociadas a una sala concreta, por lo que las
   * sesiones correspondientes a cierta sala seran eliminadas con la sala.
   * @param sala Sala a eliminar
   * @return true si la sala existia, false en caso contrario
   */
  public Boolean eliminarSala(Sala sala){
    /* Buscamos la sala en la lista de salas del cine.
    * Si la encontramos, la eliminamos. En caso
    contrario, error */
    for(Sala s: listaSalas){
      if(s.equals(sala)){
        listaSalas.remove(s);
        System.out.println("Sala eliminada con exito.\n");
        return true;
      }
    }
    return false;
  }
  
  /**
   * Permite comprar un cierto numero de entradas de cierto tipo (el tipo nos
   * permite aplicar un descuento especifico) y para cierta sesion.
   * @param sesion Sesion de la que se quieren comprar entradas
   * @param nEntradas Numero de entradas que se quiere vender
   * @param tipo Tipo de entradas que se quiere vender
   * @return Precio total de todas las entradas. Devolvera -1 en caso de error,
   * es decir, si el aforo no permite reservar suficientes entradas o si no existe
   * la sesion a la que se quiere acceder.
   */
  public float comprarEntradas(Sesion sesion, int nEntradas, TipoEntrada tipo){
    int i, flag=0;
    float precioFinalCompra=0.0f;
    
    for(Sala s: listaSalas){
      if(s.contieneSesion(sesion)){
        flag = 1;
        if(!sesion.actualizarButacasVendidas(nEntradas)){
          System.out.println("Lo sentimos, no hay "+nEntradas+" entradas disponibles en esta sesion.\n");
          return -1;
        }
      }
    }
    if(flag==0){
      System.err.println("Lo sentimos, no existe la sesion seleccionada para comprar entradas.\n");
      return -1;
    }
    
    if(tipo != TipoEntrada.NORMAL){
      for(i=0; i<nEntradas; i++){
        EntradaEspecial entrEsp = new EntradaEspecial(sesion, tipo);
        precioFinalCompra += entrEsp.getPrecio();
        listaEntradas.add(entrEsp);
      }
    }else if(sesion.getFecha().get(Calendar.DAY_OF_WEEK) == diaEspectador.getDia()){
      for(i=0; i<nEntradas; i++){
        EntradaDiaEspectador entrDiaEspect = new EntradaDiaEspectador(sesion, descuentoDiaEspectador);
        precioFinalCompra += entrDiaEspect.getPrecio();
        listaEntradas.add(entrDiaEspect);
      }
    }else{
      for(i=0; i<nEntradas; i++){
        Entrada entr = new Entrada(sesion);
        precioFinalCompra += entr.getPrecio();
        listaEntradas.add(entr);  
      }
    }
    
    System.out.println("Entradas compradas con exito. Precio final = "+precioFinalCompra);
    return precioFinalCompra;
  }
  
  
}
