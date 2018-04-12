import java.util.*;

public class PruebaCruce{
    
    public static int aleat_num(int min, int max){
        Random rand = new Random();
        return (min + rand.nextInt((max-min)+1));
    }
    
    public ArrayList<IIndividuo> cruce(IIndividuo ind1, IIndividuo ind2) throws CruceNuloException{
        INodo copia1 = ind1.getExpresion().copy();
        INodo copia2 = ind2.getExpresion().copy();
        
        int nNodos1 = ind1.getNumeroNodos();
        int nNodos2 = ind2.getNumeroNodos();
        
        ((Nodo) copia1).etiquetarDescendientes();
        ((Nodo) copia2).etiquetarDescendientes();
        
        int rand1 = aleat_num(1, nNodos1);
        int rand2 = aleat_num(1, nNodos2);
        if(rand1==1 && rand2==1){
            throw new CruceNuloException("Ambos numeros aleatorios son igual a uno");
        }
        
        INodo nodoCruce1 = ((Nodo) copia1).getDescendienteById(rand1);
        INodo nodoCruce2 = ((Nodo) copia2).getDescendienteById(rand2);
        
        INodo padre1 = ((Nodo) nodoCruce1).getPadre();
        INodo padre2 = ((Nodo) nodoCruce2).getPadre();
        
        if(padre1!=null) ((Nodo) padre1).getDescendientes().remove(nodoCruce1);
        if(padre2!=null) ((Nodo) padre2).getDescendientes().remove(nodoCruce2);
        
        if(padre1!=null){
            ((Nodo) padre1).getDescendientes().add(nodoCruce2);
            ((Nodo) nodoCruce2).setPadre(padre1);
        } 
        if(padre2!=null){
            ((Nodo) padre2).getDescendientes().add(nodoCruce1);
            ((Nodo) nodoCruce1).setPadre(padre2);
        } 
        
        IIndividuo nuevo1 = new Individuo();
        nuevo1.setExpresion(copia1);
        IIndividuo nuevo2 = new Individuo();
        nuevo2.setExpresion(copia2);
        
        ArrayList<IIndividuo> arrayInd = new ArrayList<IIndividuo>();
        arrayInd.add(nuevo1);
        arrayInd.add(nuevo2);
        
        return arrayInd;
    }
    
}