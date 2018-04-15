import java.util.*;

public class TerminalBooleano1 extends Terminal{
    private static int valor;
    
    public TerminalBooleano1(String simbolo){
        super(simbolo);
    }
    
    
    public double calcular(){
        return valor;
    }
    
    
    public static void setValor(int val){
        valor = val;
    }
    
    
    public INodo copy(){
        TerminalBooleano1 tb = new TerminalBooleano1(this.getRaiz());
        return tb;
    }
}