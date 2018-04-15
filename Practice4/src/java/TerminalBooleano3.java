import java.util.*;

public class TerminalBooleano3 extends Terminal{
    private static int valor;
    
    public TerminalBooleano3(String simbolo){
        super(simbolo);
    }
    
    
    public double calcular(){
        return valor;
    }
    
    
    public static void setValor(int val){
        valor = val;
    }
    
    
    public INodo copy(){
        TerminalBooleano3 tb = new TerminalBooleano3(this.getRaiz());
        return tb;
    }
}