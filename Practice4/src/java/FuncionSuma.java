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
    
    
    public INodo copy() throws MaximosDescendientesException{
        FuncionSuma fs = new FuncionSuma(this.getRaiz(), this.getMaxDescendientes());
        
        ArrayList<INodo> arrayDes = this.getDescendientes();
        
        if(arrayDes.size() > 0){
            for(INodo n: arrayDes){
                INodo nuevo = n.copy();
                fs.incluirDescendiente(nuevo);
            }
        }
        
        return fs;
    }
}