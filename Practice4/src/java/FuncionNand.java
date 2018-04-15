import java.util.*;

public class FuncionNand extends Funcion{
    
    public FuncionNand(String simbolo, int maxDescendientes){
        super(simbolo, maxDescendientes);
    }
    
    public double calcular(){
        ArrayList<INodo> descendientes = this.getDescendientes();
        double calculo = 0;
        
        for(INodo n: descendientes){
            calculo = FuncionNand.or(calculo, n.calcular());
        }
        
        return FuncionNand.not(calculo);
    }
    
    public INodo copy() throws MaximosDescendientesException{
        FuncionNand fn = new FuncionNand(this.getRaiz(), this.getMaxDescendientes());
        
        ArrayList<INodo> arrayDes = this.getDescendientes();
        
        if(arrayDes.size() > 0){
            for(INodo n: arrayDes){
                INodo nuevo = n.copy();
                fn.incluirDescendiente(nuevo);
            }
        }
        
        return fn;
    }
    
    private static double or(double op1, double op2){
        if(op1==1.0 || op2==1.0) return 1.0;
        else return 0.0;
    }
    
    
    private static double not(double op){
        if(op == 1.0) return 0.0;
        else if(op == 0.0) return 1.0;
        else return -1.0;
    }
    
}