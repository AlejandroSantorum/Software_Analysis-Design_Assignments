import java.util.*;

public class AlgoritmoGenetico implements IAlgoritmo{
    private int numeroIndividuosIniciales;
    private int profundidadInicial;
    private int Ktorneo;
    private double probCruce;
    private int numGeneraciones;
    private List<Terminal> conjuntoTerminales;
    private List<Funcion> conjuntoFunciones;
    private List<IIndividuo> poblacion;
    private double fitnessMejor;
    
    public AlgoritmoGenetico(int numeroIndividuosIniciales, int profundidadInicial, int Ktorneo, double probCruce, int numGeneraciones){
        if(numeroIndividuosIniciales <= 8){
		      throw new IllegalArgumentException("El numero de individuos iniciales es demasiado pequeña = " +numeroIndividuosIniciales+". Cota inferior permitida = 8"); 
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
		if(probCruce < 0.65){
		    throw new IllegalArgumentException("Probabilidad de cruce muy baja: " + probCruce +". Cota inferior permitida 0.65 = 65%");
		}
		if(numGeneraciones < 3){
		    throw new IllegalArgumentException("Numero de generaciones muy baja: " + numGeneraciones +". Cota inferior permitida = 3");
		}
		
        this.numeroIndividuosIniciales = numeroIndividuosIniciales;
        this.profundidadInicial = profundidadInicial;
        this.Ktorneo = Ktorneo;
        this.probCruce = probCruce;
        this.numGeneraciones = numGeneraciones;
    }
    
    
    public void defineConjuntoTerminales(List<Terminal> terminales){
        this.conjuntoTerminales = terminales;
    }
    
    
    public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException{
        this.conjuntoFunciones = funciones;
    }
    
    
    public void crearPoblacion() throws ParametroNoInicializadoException, CruceNuloException, ProfundidadInvalidaException, MaximosDescendientesException{
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
    
    
    public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException, MaximosDescendientesException{
        INodo copia1 = prog1.getExpresion().copy();
        INodo copia2 = prog2.getExpresion().copy();
        
        int nNodos1 = prog1.getNumeroNodos();
        int nNodos2 = prog2.getNumeroNodos();
        
        ((Nodo) copia1).etiquetarDescendientes();
        ((Nodo) copia2).etiquetarDescendientes();
        
        int rand1 = PruebaCruce.aleat_num(1, nNodos1);
        int rand2 = PruebaCruce.aleat_num(1, nNodos2);
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
    
    
    public void crearNuevaPoblacion() throws ParametroNoInicializadoException, CruceNuloException, ProfundidadInvalidaException, MaximosDescendientesException{
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
        
        double nDirectos = Math.floor(0.1 * tam);
        double nTorneo = Math.ceil(0.9 * tam);
        
        ArrayList<IIndividuo> nuevaPobl = new ArrayList<IIndividuo>();
        IIndividuo mejor;
        ArrayList<IIndividuo> peores = new ArrayList<IIndividuo>();
        
        mejor = poblacion.get(0);
        peores.add(poblacion.get(0));
        peores.add(poblacion.get(1));
        
        for(int i=1; i<poblacion.size(); i++){
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
                    peores.add(poblacion.get(i));
                }
            } 
        }
        poblacion.remove(mejor);
        nuevaPobl.add(mejor);
        System.out.println("Mejor individuo de esta generacion:");
        mejor.writeIndividuo();
        System.out.println("FITNESS = "+mejor.getFitness());
        this.fitnessMejor = mejor.getFitness();
        
        for(int i=0; i<nDirectos; i++){
            int rand = PruebaCruce.aleat_num(0, poblacion.size()-1);
            IIndividuo indAux = poblacion.remove(rand);
            nuevaPobl.add(indAux);
        }
        
        
        ArrayList<IIndividuo> seleccionados = new ArrayList<IIndividuo>();
        for(int j=0; j<Ktorneo; j++){
            int rand = PruebaCruce.aleat_num(0, poblacion.size()-1);
            seleccionados.add(poblacion.get(rand));
        }
        
        ArrayList<IIndividuo> dosMejores = new ArrayList<IIndividuo>();
        dosMejores.add(seleccionados.get(0));
        dosMejores.add(seleccionados.get(1));
        for(int i=2; i<Ktorneo; i++){
            if(seleccionados.get(i).getFitness() > dosMejores.get(0).getFitness() || seleccionados.get(i).getFitness() > dosMejores.get(1).getFitness()){
                if(dosMejores.get(0).getFitness() > dosMejores.get(1).getFitness()){
                    dosMejores.remove(1);
                    dosMejores.add(seleccionados.get(i));
                }
                else{
                    dosMejores.remove(0);
                    dosMejores.add(seleccionados.get(i));
                }
            }
        }
        
        List<IIndividuo> cruzados = new ArrayList<IIndividuo>();
        
        int exito=0;
        while(exito==0){
            try{
                cruzados = cruce(dosMejores.get(0), dosMejores.get(1));
                exito=1;
            }catch(CruceNuloException ex){
                
            }
        }
        
        poblacion.remove(peores.get(0));
        poblacion.remove(peores.get(1));
        
        poblacion.add(cruzados.get(0));
        poblacion.add(cruzados.get(1));
        poblacion.addAll(nuevaPobl);
    }
    
    
    public List<IIndividuo> getPoblacion(){
        return poblacion;
    }
    
    
    public void ejecutar(IDominio dominio) throws ParametroNoInicializadoException, CruceNuloException, ProfundidadInvalidaException, MaximosDescendientesException{
        if(((DominioAritmetico) dominio).getFitnessMaximo() == -1.0){
            throw new ParametroNoInicializadoException("No se ha inicializado en el dominio el fichero de texto con los datos");
        }
        IIndividuo mejorFinal;
        conjuntoFunciones = ((Dominio) dominio).getFuncionesDefinidas();
        conjuntoTerminales = ((Dominio) dominio).getTerminalesDefinidos();
        
        this.crearPoblacion();
        
        for(int i=0; i<this.numGeneraciones; i++){
            System.out.println("\t GENERACION NUMERO "+i);
            
            for(IIndividuo ind: poblacion){
                dominio.calcularFitness(ind, 0);
            }
            
            if(this.fitnessMejor == ((Dominio) dominio).getFitnessMaximo()){
                System.out.println("Fitness maximo alcanzado!");
                for(IIndividuo ind: poblacion){
                    if(ind.getFitness() == fitnessMejor){
                        System.out.println("INDIVIDUO OBTENIDO:");
                        ind.writeIndividuo();
                        System.out.println("Con FITNESS = "+ind.getFitness());
                        return;
                    }
                }
            }
            
            this.crearNuevaPoblacion();
        }
        
        System.out.println("Numero maximo de generaciones alcanzado");
        for(IIndividuo ind: poblacion){
            if(ind.getFitness() == fitnessMejor){
                System.out.println("INDIVIDUO OBTENIDO:");
                ind.writeIndividuo();
                System.out.println("Con FITNESS = "+ind.getFitness()+". Maximo posible = "+((Dominio) dominio).getFitnessMaximo());
                return;
            }
        }
        return;
    }
    
}