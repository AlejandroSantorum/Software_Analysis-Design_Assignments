import java.util.*;

public class FuncionSuma extends Funcion{
    
    public FuncionSuma(String simbolo, int maxDescendientes){
        super(simbolo, maxDescendientes);
    }
    
    public double calcular(){
        ArrayList<INodo> descendientes = this.getDescendientes();
        double calculo = 0;
        
        for(INodo n: descendientes){
            calculo += n.calcular();
        }
        return calculo;
    }
}