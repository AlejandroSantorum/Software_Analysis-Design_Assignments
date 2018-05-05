package opcional;
import java.util.*;

public class GrafoDirigido<T> extends Grafo<T>{
    
    public void addArco(Vertice<T> v1, Vertice<T> v2, double peso){
        v1.addAristaOut(v2, peso);
        v2.addAristaIn(v1, peso);
        incrementarAristas();
    }
}