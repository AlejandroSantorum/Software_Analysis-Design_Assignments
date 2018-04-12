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
    
    
    public INodo copy(){
        FuncionMultiplicacion fm = new FuncionMultiplicacion(this.getRaiz(), this.getMaxDescendientes());
        
        ArrayList<INodo> arrayDes = this.getDescendientes();
        
        if(arrayDes.size() > 0){
            for(INodo n: arrayDes){
                INodo nuevo = n.copy();
                fm.incluirDescendiente(nuevo);
            }
        }
        
        return fm;
    }
}