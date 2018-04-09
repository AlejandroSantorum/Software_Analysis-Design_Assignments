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
    
}