import java.io.*;
import java.util.*;

public class DominioBooleano extends Dominio{
    private ArrayList<Integer> valores;
    private ArrayList<Double> reales;
    private ArrayList<Double> estimados; /* OPCIONAL */
    private ArrayList<Terminal> terminalesDefinidos;
    private ArrayList<Funcion> funcionesDefinidas;
    
    public DominioBooleano(){
        valores = new ArrayList<Integer>();
        reales = new ArrayList<Double>();
        estimados = new ArrayList<Double>();
    }
    
    
    public List<Terminal> definirConjuntoTerminales(String... terminales){
        
        if(terminalesDefinidos==null){
            terminalesDefinidos = new ArrayList<Terminal>();
        }
        else{
            terminalesDefinidos.clear();
        }
        
        for(int i=0; i<terminales.length; i++){
            if((i%3)==0){
                TerminalBooleano1 t1 = new TerminalBooleano1(terminales[i]);
                terminalesDefinidos.add(t1);
            }
            else if((i%3)==1){
                TerminalBooleano2 t2 = new TerminalBooleano2(terminales[i]);
                terminalesDefinidos.add(t2);
            }
            else{
                TerminalBooleano3 t3 = new TerminalBooleano3(terminales[i]);
                terminalesDefinidos.add(t3);
            }
        }
        
        return terminalesDefinidos;
    }
    
    
    public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException{
        if(argumentos.length != funciones.length){
            throw new ArgsDistintosFuncionesException("El numero de simbolos de funciones es diferente al tamaño del array de argumentos");
        }
        
        if(funcionesDefinidas==null){
            funcionesDefinidas = new ArrayList<Funcion>();
        }
        else{
            funcionesDefinidas.clear();
        }
        
        for(int i=0; i<funciones.length; i++){
            String comparar = funciones[i];
            Funcion f;
            
            switch(comparar){
                case "or":
                    f = new FuncionOr(comparar, argumentos[i]);
                    funcionesDefinidas.add(f);
                    break;
                    
                case "and":
                    f = new FuncionAnd(comparar, argumentos[i]);
                    funcionesDefinidas.add(f);
                    break;
                    
                case "nand":
                    f = new FuncionNand(comparar, argumentos[i]);
                    funcionesDefinidas.add(f);
                    break;
                
                case "nor":
                    f = new FuncionNor(comparar, argumentos[i]);
                    funcionesDefinidas.add(f);
                    break;
                    
                default:
                    throw new ArgsDistintosFuncionesException("La cadena de caracteres simbolica no tiene ninguna correspondencia con las funciones definidas");
            }
        }
        
        return funcionesDefinidas;
    }
    
    
    public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException{
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroDatos)))){
			String line;
			String[] items = new String[]{};
			double fitnessMaximo = 0.0;
			
			while((line = reader.readLine()) != null) {
				items = line.split(" ");
				
				if (items.length != 4) {
					throw new IOException("La línea leída no contiene exactamente cuatro datos.\n");
				}
				
				if(items[0].equals("true")) valores.add(1);
				else if(items[0].equals("false")) valores.add(0);
				
				if(items[1].equals("true")) valores.add(1);
				else if(items[1].equals("false")) valores.add(0);
				
				if(items[2].equals("true")) valores.add(1);
				else if(items[2].equals("false")) valores.add(0);
				
				if(items[3].equals("true")) reales.add(1.0);
				else if(items[3].equals("false")) reales.add(0.0);
				
				fitnessMaximo += 1.0;
			}
			super.setFitnessMaximo(fitnessMaximo);
		}catch(IOException ex) {
			throw ex;
		};
    }
    
    
    public double calcularFitness(IIndividuo individuo, int flag){
        Double estimado, real;
        int fitness=0;
        
        int k=0;
        for(int i=0; i<valores.size(); i = i+3){
            TerminalBooleano1.setValor(valores.get(i));
            TerminalBooleano2.setValor(valores.get(i+1));
            TerminalBooleano3.setValor(valores.get(i+2));
            
            estimado = (individuo.getExpresion()).calcular();
            real = reales.get(k);
            
            if(flag!=0){
                System.out.println("Valor1="+valores.get(i)+", Valor2="+valores.get(i+1)+", Valor3="+valores.get(i+2)+" <-> Rdo estimado: "+estimado+" <-> Rdo real: "+real);
            }
            
            estimados.add(estimado); /* OPCIONAL */
            
            if(real.equals(estimado)){
                fitness += 1;
            }
            k += 1;
        }
        individuo.setFitness(fitness);
        return fitness;
    }
    
    
    public ArrayList<Funcion> getFuncionesDefinidas(){
        return funcionesDefinidas;
    }
    
    public ArrayList<Terminal> getTerminalesDefinidos(){
        return terminalesDefinidos;
    }
}