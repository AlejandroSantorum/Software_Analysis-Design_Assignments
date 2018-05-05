package opcional;

public class FactoriaGrafos<T> {
	public static <T> IGrafo crearGrafo(TiposGrafo tipoGrafo) throws IllegalArgumentException {
		if (tipoGrafo.equals(TiposGrafo.DIRIGIDO)) {
			return new GrafoDirigido();
		} else if (tipoGrafo.equals(TiposGrafo.NO_DIRIGIDO)) {
			return new GrafoNoDirigido();
		} else if (tipoGrafo.equals(TiposGrafo.COMPLETAMENTE_CONECTADO)) {
			return new GrafoCompletamenteConectado();
		} else {
			return null;
		}
	}
	
	public enum TiposGrafo{
		DIRIGIDO,
		NO_DIRIGIDO,
		COMPLETAMENTE_CONECTADO;
	}
}
