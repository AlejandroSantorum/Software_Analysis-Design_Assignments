public class Cine{
  private String nombre;
  private String direccion;
  private ArrayList<Pelicula> listaPeliculas;
  private ArrayList<Sala> listaSalas;
  private ArrayList<Entrada> listaEntradas;
  private ArrayList<Sesion> listaSesiones;

  public Cine(String nombre, String direccion){
    this.nombre = nombre;
    this.direccion = direccion;
    this.listaPeliculas = new ArrayList<Pelicula>();
    this.listaSalas = new ArrayList<Sala>();
    this.listaEntradas = new ArrayList<Entrada>();
  }

  public Boolean añadirPelicula(String titulo, String director, int anno, String sinopsis, Genero genero){
    for(Pelicula p: listaPeliculas){ /* Comprobamos que no existe ya esa pelicula */
      if(p.getTitulo==titulo && p.getDirector()==director && p.getAnno()==anno){
        System.out.println("Lo siento, la pelicula ya existe.\n");
        return false;
      }
    }

    /* Creamos pelicula y la añadimos a la lista de peliculas del cine */
    Pelicula peli = new Pelicula(titulo, director, anno, sinopsis, genero);
    listaPeliculas.add(peli);
    System.out.println("Pelicula añadida con éxito.\n");
    return true;
  }



  public Boolean añadirSesion(Calendar fecha, Pelicula pelicula, Sala sala){
    int flag=0;

    for(Sala s: listaSalas){ /* Comprobamos que la sala existe */
      if(sala.equals(s)){
        flag=1;
        break;
      }
    }
    if(flag){
      System.out.println("Lo siento, la sala a la que se intenta añadir una sesion no existe\n");
      return false;
    }

    flag=0;
    for(Pelicula p: listaPeliculas){ /* Comprobamos que la pelicula existe */
      if(p.equals(pelicula)){
        flag=1;
        break;
      }
    }
    if(flag){
      System.out.println("Lo siento, la pelicula introducida no existe\n");
      return false;
    }

    Sesion sesion = new Sesion(fecha, pelicula, sala); /* Creamos sesion */
    /* Añadimos sesion a la sala*/
    if(!sala.addSesion(sesion)){
      /* Control de errores: no puede haber dos sesiones
       * a la misma hora de un dia en una misma sala */
      System.out.println("Lo siento, la sala ya tiene una sesion en el momento seleccionado\n");
      return false;
    }

    /* Añadimos la sesion a la lista de sesiones del cine */
    listaSesiones.add(sesion);
    System.out.println("Sesion añadida con exito\n");
    return true;
  }


  public Boolean añadirSala(int id, int filas, int columnas){
    for(Sala s: listaSalas){
      if(s.getId==id){
        System.out.println("Lo siento, ya existe una sala con ese identificador\n");
        return false;
      }
    }

    /* Si la sala no existe, la creamos */
    Sala sala = new Sala(id, filas, columnas);
    /* Introducimos la sala en la lista de salas del cine */
    listaSalas.add(sala);
    System.out.println("Sesion añadida con exito\n");
    return true;
  }


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
    return true;
  }


  public Boolean eliminarSesion(Sesion sesion){
    Sala aux;
    /* Buscamos la sesion en la lista de sesiones.
    * si la encontramos, primero eliminamos dicha sesion
    * del array de sesiones de su sala, y despues, la
    * suprimimos de la lista de sesiones del cine */
    for(Sesion s: listaSesiones){
      if(s.equals(sesion)){
        aux = s.getSala();
        aux.deleteSesion(s);
        listaSesiones.remove(s);
        return true;
      }
    }
    return false;
  }


  public Boolean eliminarSala(Sala sala){
    /* Buscamos la sala en la lista de salas del cine.
    * Si la encontramos, la eliminamos. En caso
    contrario, error */
    for(Sala s: listaSalas){
      if(s.equals(sala)){
        listaSalas.remove(s);
        return true;
      }
    }
    return false;
  }

}
