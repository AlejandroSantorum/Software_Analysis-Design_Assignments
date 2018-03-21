import java.util.*;

public class Pruebas{
    public static void main(String[] args){
        Cine cine = new Cine("Cinesa", "Plaza de la puerta del Sol", DiaEspectador.MIERCOLES);
        
        System.out.println(cine);
        
        GregorianCalendar fecha1 = new GregorianCalendar(2018, 03, 19);
        GregorianCalendar fecha2 = new GregorianCalendar(2018, 03, 20);
        GregorianCalendar fecha3 = new GregorianCalendar(2018, 03, 21);
        GregorianCalendar fecha4 = new GregorianCalendar(2018, 03, 22);
        GregorianCalendar fecha5 = new GregorianCalendar(2018, 03, 23);
        GregorianCalendar fecha6 = new GregorianCalendar(2018, 03, 24);
        GregorianCalendar fecha7 = new GregorianCalendar(2018, 03, 25);

        System.out.println(fecha1.get(Calendar.DAY_OF_WEEK));
        System.out.println(fecha2.get(Calendar.DAY_OF_WEEK));
        System.out.println(fecha3.get(Calendar.DAY_OF_WEEK));
        System.out.println(fecha4.get(Calendar.DAY_OF_WEEK));
        System.out.println(fecha5.get(Calendar.DAY_OF_WEEK));
        System.out.println(fecha6.get(Calendar.DAY_OF_WEEK));
        System.out.println(fecha7.get(Calendar.DAY_OF_WEEK));
    }
}