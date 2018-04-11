import java.io.*;
import java.util.*;

public class DominioAritmetico extends Dominio{
    private ArrayList<Double> valores;
    private ArrayList<Double> reales;
    private ArrayList<Double> estimados; /* OPCIONAL */
    
    public DominioAritmetico(){
        valores = new ArrayList<Double>();
        reales = new ArrayList<Double>();
        estimados = new ArrayList<Double>();
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
        Nodo raiz = (Nodo) individuo.getExpresion();
        Nodo auxAct, auxFut;
        TerminalAritmetico terminal;
        Double estimado, real;
        int fitness=0;
        
        if(raiz instanceof TerminalAritmetico){
            terminal = (TerminalAritmetico) raiz;
        }
        else{
            auxAct = raiz;
            while(true){
                auxFut = ((Nodo) auxAct.getDescendientes().get(0));
                if(auxFut instanceof TerminalAritmetico){
                    terminal = (TerminalAritmetico) auxFut;
                    break;
                }
                else{
                    auxAct = auxFut;
                }
            }
        }
        
        for(int i=0; i<valores.size(); i++){
            terminal.setValor(valores.get(i));
            
            estimado = raiz.calcular();
            real = reales.get(i);
            
            System.out.println("Valor "+valores.get(i)+" <-> Rdo estimado: "+estimado+" <-> Rdo real: "+real);
            
            estimados.add(estimado); /* OPCIONAL */
            
            if(Math.abs(real - estimado) <= 1){
                fitness += 1;
            }
        }
        return fitness;
    }
}