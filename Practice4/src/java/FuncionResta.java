import java.util.*;

public class FuncionResta extends Funcion{
    
    public FuncionResta(String simbolo, int maxDescendientes){
        super(simbolo, maxDescendientes);
    }
    
    public double calcular(){
        ArrayList<INodo> descendientes = this.getDescendientes();
        double calculo = descendientes.get(0).calcular();
        
        for(int i=1; i<descendientes.size(); i++){
            calculo -= descendientes.get(i).calcular();
        }
        return calculo;
    }
    
    
    public INodo copy() throws MaximosDescendientesException{
        FuncionResta fr = new FuncionResta(this.getRaiz(), this.getMaxDescendientes());
        
        ArrayList<INodo> arrayDes = this.getDescendientes();
        
        if(arrayDes.size() > 0){
            for(INodo n: arrayDes){
                INodo nuevo = n.copy();
                fr.incluirDescendiente(nuevo);
            }
        }
        
        return fr;
    }
    
}