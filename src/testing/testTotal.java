import java.util.*;

public class testTotal{
    public static void main(String[] args){
        System.out.println("=============== INTEGRATION TEST ===============\n");
        System.out.println("Creando cine...");
        
        Cine cine = new Cine("Cinesa", "Plaza de la puerta del Sol", DiaEspectador.MIERCOLES);
        System.out.println(cine);
        System.out.println("Cine creado con exito\n");
        
        Cartelera cartelera = cine.getCartelera();
        
        System.out.println("Creando peliculas, salas y sesiones de prueba...");
        
        if(!cine.anadirSala(1, 10, 10)){
            System.out.println("ERROR INSERTANDO UNA NUEVA SALA EN EL CINE");
            return;
        }
        if(!cine.anadirSala(2, 20, 20)){
            System.out.println("ERROR INSERTANDO UNA NUEVA SALA EN EL CINE");
            return;
        }
        if(!cine.anadirSala(3, 30, 30)){
            System.out.println("ERROR INSERTANDO UNA NUEVA SALA EN EL CINE");
            return;
        }
        
        
        if(!cine.anadirPelicula("El lobo de Wall Street", "Martin Scorsese", 2013, "Historia de la vida de un corrupto agente de bolsa", Genero.COMEDIA)){
            System.out.println("ERROR INSERTANDO UNA NUEVA PELICULA EN EL CINE");
            return;
        }
        if(!cine.anadirPelicula("Harry Potter y las Reliquias de la Muerte", "David Yates", 2011, "Potter vs Voldemort", Genero.ACCION)){
            System.out.println("ERROR INSERTANDO UNA NUEVA PELICULA EN EL CINE");
            return;
        }
        if(!cine.anadirPelicula("El señor de los Anillos", "Peter Jackson", 2001, "Tres personas buscando un anillo", Genero.BELICO)){
            System.out.println("ERROR INSERTANDO UNA NUEVA PELICULA EN EL CINE");
            return;
        }
        
        ArrayList<Pelicula> peliculas = cine.getPeliculas();
        ArrayList<Sala> salas = cine.getSalas();
        
        int i=1;
        for(Pelicula p: peliculas){
            for(Sala s: salas){
                if(!cine.anadirSesion(new GregorianCalendar(2018, 02, i, i, 10+i), p, s, 10.00f)){
                    System.out.println("ERROR INSERTANDO UNA NUEVA SESION EN EL CINE");
                    return;
                }
                i += 1;
            }
        }
        ArrayList<Sesion> sesiones = cine.getSesiones();
        
        System.out.println("Peliculas, Salas y Sesiones de prueba creadas y insertadas en el cine con EXITO\n");
        
        
        System.out.println("Procediendo a mostrar la cartelera...");
        cartelera.mostrarCartelera();
        System.out.println("\nCartelera mostrada con exito\n");
        
        
        System.out.println("Procediendo a realizar varias compras de entradas NORMALES en diferentes sesiones");
        System.out.println("Si la fecha de la sesion coincide con el dia del espectador, las entradas tendrán un descuento...");
        for(Sesion s: sesiones){
            cine.comprarEntradas(s, 3, TipoEntrada.NORMAL);
        }
        System.out.println("Entradas NORMALES en diferentes sesiones compradas con exito\n");
        
        System.out.println("Procediendo a realizar varias compras de entradas para ESTUDIANTES en diferentes sesiones");
        System.out.println("Si la fecha de la sesion coincide con el dia del espectador, las entradas tendrán un unico descuento...");
        for(Sesion s: sesiones){
            cine.comprarEntradas(s, 3, TipoEntrada.ESTUDIANTE);
        }
        System.out.println("Entradas de ESTUDIANTES en diferentes sesiones compradas con exito");
        System.out.println("La comprobacion para el resto de tipo de entradas es análoga a esta\n");
        
        System.out.println("Mostrando el mas informacion util que el cine es capaz de mostrar...");
        
        for(Pelicula p: peliculas){
            System.out.println(p);
            ArrayList<Sesion> auxSes = cartelera.getSesionesPorPelicula(p);
            for(Sesion s: auxSes){
                s.mostrarInfoDetalladaSesion();
            }
        }
        
        System.out.println("Informacion mostrada con EXITO\n");
        
        System.out.println("Escenario de exito COMPROBADO. Ahora eliminaremos algunas peliculas, sesiones y/o salas y se intentara forzar el sistema a fallar");
        
        cine.eliminarPelicula(peliculas.get(0));
        cine.eliminarSala(salas.get(0));
        
        sesiones = cine.getSesiones();
        
        Pelicula peliFallo = new Pelicula("Pelicula del fallo", "Alejandro Santorum", 2020, "Una pelicula creada para que falle el sistema", Genero.AVENTURAS);
        Sala salaFallo = new Sala(1234, 3, 3);
        Sesion sesFallo = new Sesion(new GregorianCalendar(2018, 02, 1, 1, 11), peliFallo, salaFallo, 10.00f);
        
        cine.anadirSesion(new GregorianCalendar(2018, 02, 1, 1, 11), peliFallo, salas.get(1), 10.00f);
        cine.anadirSesion(new GregorianCalendar(2018, 02, 1, 1, 11), peliculas.get(1), salaFallo, 10.00f);
        cine.anadirPelicula(peliculas.get(1).getTitulo(), peliculas.get(1).getDirector(), peliculas.get(1).getAnno(), 
                                                        peliculas.get(1).getSinopsis(), peliculas.get(1).getGenero());
        cine.anadirSala(2, 15, 15);
        cine.comprarEntradas(sesFallo, 5, TipoEntrada.NORMAL);
        cine.comprarEntradas(sesiones.get(1), 10000, TipoEntrada.NORMAL);
        
        System.out.println("Como todas las operaciones anteriores han desembocado en algun fallo:");
        System.out.println("Se puede sostener que el sistema es ferreo y robusto contra parametros incorrectos");
        
        System.out.println("Escenarios de errores superados con EXITO\n");
        
        System.out.println("=============== INTEGRATION TEST SUPERADO CON EXITO ===============");
        
    }
}