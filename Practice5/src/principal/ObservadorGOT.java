import java.util.*;
import java.util.List;
import java.util.Map;

public class ObservadorGOT extends Observer {
	private PersonajeGOT personaje;
	private Map<PersonajeGOT, Integer> interaccionesPersonajes = new TreeMap<PersonajeGOT, Integer>();
	private Map<String, Integer> interaccionesCasas = new TreeMap<String, Integer>();

	public ObservadorGOT(SimuladorGOT s, PersonajeGOT p) {
		super(s);
		this.personaje = p;
		if(interaccionesCasas.get(personaje.getCasa()) == null) {/*Para evitar que en el toString se imprima null en vez*/
			interaccionesCasas.put(personaje.getCasa(), 0);		/*De un 0 cuando no haya interacciones con su propia casa*/
		}
	}

	public void actualizar() {
		int num;
		SimuladorGOT simulador = (SimuladorGOT) super.sujeto;

		PersonajeGOT origen = simulador.getOrigen();
		List<PersonajeGOT> destinos = simulador.getDestinos();

		if (origen.equals(this.personaje)) {
			for (PersonajeGOT d : destinos) {
				if (interaccionesPersonajes.containsKey(d)) {
					num = interaccionesPersonajes.get(d);
					interaccionesPersonajes.put(d, num + 1);
				} else {
					interaccionesPersonajes.put(d, 1);
				}

				if (interaccionesCasas.containsKey(d.getCasa())) {
					num = interaccionesCasas.get(d.getCasa());
					interaccionesCasas.put(d.getCasa(), num + 1);
				} else {
					interaccionesCasas.put(d.getCasa(), 1);
				}
			}
		} else if (destinos.contains(personaje)) {
			if (interaccionesPersonajes.containsKey(origen)) {
				num = interaccionesPersonajes.get(origen);
				interaccionesPersonajes.put(origen, num + 1);
			} else {
				interaccionesPersonajes.put(origen, 1);
			}

			if (interaccionesCasas.containsKey(origen.getCasa())) {
				num = interaccionesCasas.get(origen.getCasa());
				interaccionesCasas.put(origen.getCasa(), num + 1);
			} else {
				interaccionesCasas.put(origen.getCasa(), 1);
			}
		}

	}

	public String toString() {
		String text;
		String tab = "\t", tab2 = "\t\t", tab3 = "\t\t\t";

		text = personaje.getNombre() + "\n";
		text += tab + "Interacciones: " + interaccionesCasas.values().stream().reduce(0, (x, y) -> x + y) + "\n";
		text += tab2 + "Con miembros de su casa: " + interaccionesCasas.get(personaje.getCasa()) + "\n";
		text += tab2 + "Con miembros de casa ajena " + "\n";

		for (String str : interaccionesCasas.keySet()) {
			if (str.equals(personaje.getCasa()) == false) {
				text += tab3 + str + ": " + interaccionesCasas.get(str) + "\n";
			}
		}
		return text;
	}

}
