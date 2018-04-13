public interface IAlgoritmo {
    public void defineConjuntoTerminales(List<Terminal> terminales);
    public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;
    public void crearPoblacion() throws ParametroNoInicializadoException;
    public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException;
    public void crearNuevaPoblacion() throws ParametroNoInicializadoException;
    //public void ejecutar(IDominio dominio);
}