package opcional;

import java.util.List;

public class GrafoCompletamenteConectado<T> extends GrafoNoDirigido<T>{

	@Override
	public Vertice<T> addVertice(T datos) throws VerticeIdException{
		List<Vertice<T>> todos = this.getVertices();
        Vertice<T> nuevo = this.addVertice(incrementaId(), datos);
        
        for(Vertice<T> v: todos) {/*Al no especificarse, ponemos como peso predeterminado 1*/
        	v.addAristaIn(nuevo, 1.0);
        	v.addAristaOut(nuevo, 1.0);
        	nuevo.addAristaIn(v, 1.0);
        	nuevo.addAristaOut(v, 1.0);
        }
        
        return nuevo;
    }

}
