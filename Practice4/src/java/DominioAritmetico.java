import java.io.*;
import java.util.*;

public class DominioAritmetico extends Dominio{
    private ArrayList<Double> valores;
    private ArrayList<Double> reales;
    private ArrayList<Double> estimados; /* OPCIONAL */
    private ArrayList<Terminal> terminalesDefinidos;
    private ArrayList<Funcion> funcionesDefinidas;
    
    public DominioAritmetico(){
        valores = new ArrayList<Double>();
        reales = new ArrayList<Double>();
        estimados = new ArrayList<Double>();
    }
    
    
    public List<Terminal> definirConjuntoTerminales(String... terminales){
        TerminalAritmetico aux;
        
        if(terminalesDefinidos==null){
            terminalesDefinidos = new ArrayList<Terminal>();
        }
        else{
            terminalesDefinidos.clear();
        }
        
        for(String simbolo: terminales){
            aux = new TerminalAritmetico(simbolo);
            terminalesDefinidos.add(aux);
        }
        
        return terminalesDefinidos;
    }
    
    
    public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException{
        if(argumentos.length != funciones.length){
            return null; // ----> EXCEPCIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOON <----
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
                case "+":
                    f = new FuncionSuma(comparar, argumentos[i]);
                    funcionesDefinidas.add(f);
                    break;
                    
                case "-":
                    f = new FuncionResta(comparar, argumentos[i]);
                    funcionesDefinidas.add(f);
                    break;
                    
                case "*":
                    f = new FuncionMultiplicacion(comparar, argumentos[i]);
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
			
			while((line = reader.readLine()) != null) {
				items = line.split(" ");
				
				if (items.length != 2) {
					throw new IOException("La línea leída no contiene exactamente dos datos.\n");
				}
				
				valores.add(Double.parseDouble(items[0]));
				reales.add(Double.parseDouble(items[1]));
			}
		}catch(IOException ex) {
			throw ex;
		};
    }
    
    
    public double calcularFitness(IIndividuo individuo){
        Double estimado, real;
        int fitness=0;
        
        for(int i=0; i<valores.size(); i++){
            TerminalAritmetico.setValor(valores.get(i));
            
            estimado = (individuo.getExpresion()).calcular();
            real = reales.get(i);
            
            System.out.println("Valor "+valores.get(i)+" <-> Rdo estimado: "+estimado+" <-> Rdo real: "+real);
            
            estimados.add(estimado); /* OPCIONAL */
            
            if(Math.abs(real - estimado) <= 1){
                fitness += 1;
            }
        }
        individuo.setFitness(fitness);
        return fitness;
    }
}