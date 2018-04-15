import java.util.*;

public class FuncionOr extends Funcion{
    
    public FuncionOr(String simbolo, int maxDescendientes){
        super(simbolo, maxDescendientes);
    }
    
    public double calcular(){
        ArrayList<INodo> descendientes = this.getDescendientes();
        double calculo = 0.0;
        
        for(INodo n: descendientes){
            calculo = FuncionOr.or(calculo, n.calcular());
        }
        return calculo;
    }
    
    public INodo copy() throws MaximosDescendientesException{
        FuncionOr fo = new FuncionOr(this.getRaiz(), this.getMaxDescendientes());
        
        ArrayList<INodo> arrayDes = this.getDescendientes();
        
        if(arrayDes.size() > 0){
            for(INodo n: arrayDes){
                INodo nuevo = n.copy();
                fo.incluirDescendiente(nuevo);
            }
        }
        
        return fo;
    }
    
    
    private static double or(double op1, double op2){
        if(op1==1.0 || op2==1.0) return 1.0;
        else return 0.0;
    }
}