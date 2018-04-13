public class AlgoritmoGenetico implements IAlgoritmo{
    int numeroIndividuosIniciales;
    int profundidadInicial;
    int Ktorneo
    private List<Terminal> conjuntoTerminales;
    private List<Funcion> conjuntoFunciones;
    private List<IIndividuo> poblacion;
    
    public AlgoritmoGenetico(int numeroIndividuosIniciales, int profundidadInicial, int Ktorneo){
        if(numeroIndividuosIniciales <= 8){
		      throw new IllegalArgumentException("El numero de individuos iniciales es demasiado pequeña = " +numeroIndividuosIniciales+" Cota inferior permitida = 8"); 
		}
		if(profundidadInicial <= 0){
		      throw new IllegalArgumentException("La profundidad de la poblacion inicial es menor o igual a cero: " + profundidadInicial); 
		}
		if(Ktorneo <= 2){
		      throw new IllegalArgumentException("La constante de seleccion del torneo es demasiado baja: " + Ktorneo); 
		}
		if(Ktorneo >= 0.9*numeroIndividuosIniciales){
		    throw new IllegalArgumentException("La constante de seleccion del torneo es demasiado grande en comparacion con los individuos iniciales"); 
		}
		
        this.numeroIndividuosIniciales = numeroIndividuosIniciales;
        this.profundidadInicial = profundidadInicial;
    }
    
    
    public void defineConjuntoTerminales(List<Terminal> terminales){
        this.conjuntoTerminales = terminales;
    }
    
    
    public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException{
        this.conjuntoFunciones = funciones;
    }
    
    
    public void crearPoblacion() throws ParametroNoInicializadoException{
        if(conjuntoFunciones == null){
            throw new ParametroNoInicializadoException("el conjunto de funciones no ha sido definido");
        }
        if(conjuntoTerminales == null){
            throw new ParametroNoInicializadoException("el conjunto de terminales no ha sido definido");
        }
        
        int max = conjuntoFunciones.size()-1;
        poblacion = new ArrayList<IIndividuo>();
        
        for(int i=0; i<numeroIndividuosIniciales; i++){
            int rand = PruebaCruce.aleat_num(0, max);
            INodo raiz = conjuntoFunciones.get(rand).copy();
            IIndividuo ind = new Individuo();
            ind.setExpresion(raiz);
            ind.crearIndividuoAleatorio(profundidadInicial, conjuntoTerminales, conjuntoFunciones);
            poblacion.add(ind);
        }
    }
    
    
    public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException{
        INodo copia1 = prog1.getExpresion().copy();
        INodo copia2 = prog2.getExpresion().copy();
        
        int nNodos1 = prog1.getNumeroNodos();
        int nNodos2 = prog2.getNumeroNodos();
        
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
        
        if(padre1!=null){
            ((Nodo)padre1).getDescendientes().set(((Nodo)padre1).getDescendientes().indexOf(nodoCruce1), nodoCruce2);
        }
        if(padre2!=null){
            ((Nodo)padre2).getDescendientes().set(((Nodo)padre2).getDescendientes().indexOf(nodoCruce2), nodoCruce1);
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
    
    
    public void crearNuevaPoblacion() throws ParametroNoInicializadoException{
        if(conjuntoFunciones == null){
            throw new ParametroNoInicializadoException("el conjunto de funciones no ha sido definido");
        }
        if(conjuntoTerminales == null){
            throw new ParametroNoInicializadoException("el conjunto de terminales no ha sido definido");
        }
        if(poblacion == null){
            throw new ParametroNoInicializadoException("la poblacion de individuos no ha sido creada");
        }
        
        int tam = poblacion.size();
        
        int nDirectos = Math.floor(0.1 * tam);
        int nTorneo = Math.ceil(0.9 * tam);
        
        ArrayList<IIndividuo> nuevaPobl = new ArrayList<IIndividuo>();
        IIndividuo mejor;
        ArrayList<IIndividuo> peores = new ArrayList<IIndividuo>();
        
        mejor = poblacion.get(0);
        peores.add(poblacion.get(0));
        peores.add(poblacion.get(1));
        
        for(i=1; i<poblacion.size(); i++){
            if(poblacion.get(i).getFitness() > mejor.getFitness()){
                mejor = poblacion.get(i);
                continue;
            }
            if(poblacion.get(i).getFitness() < peores.get(0).getFitness() || poblacion.get(i).getFitness() < peores.get(1).getFitness()){
                if(peores.get(0).getFitness() < peores.get(1).getFitness()){
                    peores.remove(1);
                    peores.add(poblacion.get(i));
                }
                else{
                    peores.remove(0);
                    peores.add(poblacion.get(i);
                }
            } 
        }
        poblacion.remove(mejor);
        nuevaPobl.add(mejor);
        
        
        for(i=0; i<nDirectos; i++){
            int rand = PruebaCruce.aleat_num(0, poblacion.size()-1);
            IIndividuo indAux = poblacion.remove(rand);
            nuevaPobl.add(indAux);
        }
        
        
        ArrayList<IIndividuo> seleccionados = new ArrayList<IIndividuo>();
        for(j=0; j<Ktorneo; j++){
            int rand = PruebaCruce.aleat_num(0, poblacion.size()-1);
            seleccionados.add(poblacion.get(rand));
        }
        
        IIndividuo<IIndividuo> dosMejores = new ArrayList<IIndividuo>();
        dosMejores.add(seleccionados.get(0));
        dosMejores.add(seleccionados.get(1));
        for(i=2; i<Ktorneo; i++){
            if(seleccionados.get(i).getFitness() > dosMejores.get(0).getFitness() || seleccionados.get(i).getFitness() > dosMejores.get(1).getFitness()){
                if(dosMejores.get(0).getFitness() > dosMejores.get(1).getFitness()){
                    dosMejores.remove(1);
                    dosMejores.add(seleccionados(i));
                }
                else{
                    dosMejores.remove(0);
                    dosMejores.add(seleccionados(i));
                }
            }
        }
        
        dosMejores = cruce(dosMejores.get(0), dosMejores.get(1));
        
        poblacion.remove(peores.get(0));
        poblacion.remove(peores.get(1));
        
        poblacion.add(dosMejores(0));
        poblacion.add(dosMejores(1));
        poblacion.addAll(nuevaPobl);
    }
    
    
    
    
}