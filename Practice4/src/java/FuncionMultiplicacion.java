import java.util.*;

public class FuncionMultiplicacion extends Funcion{
    
    public FuncionMultiplicacion(String simbolo, int maxDescendientes){
        super(simbolo, maxDescendientes);
    }
    
    public double calcular(){
        ArrayList<INodo> descendientes = this.getDescendientes();
        double calculo = 1;
        
        for(INodo n: descendientes){
            calculo *= n.calcular();
        }
        return calculo;
    }
}