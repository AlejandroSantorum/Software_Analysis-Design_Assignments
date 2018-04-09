import java.util.*;

public class TerminalAritmetico extends Terminal{
    private static double valor;
    
    public TerminalAritmetico(String simbolo){
        super(simbolo);
    }
    
    public double calcular(){
        return valor;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    } 
}