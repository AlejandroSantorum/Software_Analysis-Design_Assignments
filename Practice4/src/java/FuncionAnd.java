import java.util.*;

public class FuncionAnd extends Funcion{
    
    public FuncionAnd(String simbolo, int maxDescendientes){
        super(simbolo, maxDescendientes);
    }
    
    public double calcular(){
        ArrayList<INodo> descendientes = this.getDescendientes();
        double calculo = 1.0;
        
        for(INodo n: descendientes){
            calculo = FuncionAnd.and(calculo, n.calcular());
        }
        return calculo;
    }
    
    public INodo copy() throws MaximosDescendientesException{
        FuncionAnd fa = new FuncionAnd(this.getRaiz(), this.getMaxDescendientes());
        
        ArrayList<INodo> arrayDes = this.getDescendientes();
        
        if(arrayDes.size() > 0){
            for(INodo n: arrayDes){
                INodo nuevo = n.copy();
                fa.incluirDescendiente(nuevo);
            }
        }
        
        return fa;
    }
    
    
    private static double and(double op1, double op2){
        if(op1==1.0 && op2==1.0) return 1.0;
        else return 0.0;
    }
    
}