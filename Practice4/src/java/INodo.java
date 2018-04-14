import java.util.*;

public interface INodo {
    public String getRaiz();
    public List<INodo> getDescendientes();
    public void incluirDescendiente(INodo nodo)  throws MaximosDescendientesException;
    public double calcular();
    public INodo copy() throws MaximosDescendientesException;
} 