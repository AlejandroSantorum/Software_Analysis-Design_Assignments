import java.util.*;

public class TerminalBooleano2 extends Terminal{
    private static int valor;
    
    public TerminalBooleano2(String simbolo){
        super(simbolo);
    }
    
    
    public double calcular(){
        return valor;
    }
    
    
    public static void setValor(int val){
        valor = val;
    }
    
    
    public INodo copy(){
        TerminalBooleano2 tb = new TerminalBooleano2(this.getRaiz());
        return tb;
    }
}