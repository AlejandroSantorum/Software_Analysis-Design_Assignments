import java.util.*;

public class TerminalAritmetico extends Terminal{
    private static double valor;
    
    public TerminalAritmetico(String simbolo){
        super(simbolo);
    }
    
    public double calcular(){
        return valor;
    }
    
    public static void setValor(double val){
        valor = val;
    }
    
    public INodo copy(){
        TerminalAritmetico ta = new TerminalAritmetico(this.getRaiz());
        
        return ta;
    }
}