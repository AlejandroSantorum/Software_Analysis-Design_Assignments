import java.util.*;

public interface IAlgoritmo {
    public void defineConjuntoTerminales(List<Terminal> terminales);
    public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;
    public void crearPoblacion() throws ParametroNoInicializadoException, CruceNuloException, ProfundidadInvalidaException, MaximosDescendientesException;
    public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException, MaximosDescendientesException;
    public void crearNuevaPoblacion() throws ParametroNoInicializadoException, CruceNuloException, ProfundidadInvalidaException, MaximosDescendientesException;
    public void ejecutar(IDominio dominio) throws ParametroNoInicializadoException, CruceNuloException, ProfundidadInvalidaException, MaximosDescendientesException;
}