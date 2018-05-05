import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SimuladorGOT extends Subject {
	private GrafoGOT grafo;
	private PersonajeGOT origen;
	private List<PersonajeGOT> destinos = new ArrayList<>();
	private Map<String, Integer> gradoPonderado;

	public SimuladorGOT(GrafoGOT g) throws IOException, VerticeIdException {
		this.grafo = g;
		List<Vertice<PersonajeGOT>> vertices = grafo.getVertices();
		gradoPonderado = grafo.gradoPonderadoPersonajes();
		for (Vertice<PersonajeGOT> v : vertices) {
			new ObservadorGOT(this, v.getDatos());
		}
	}

	public List<PersonajeGOT> getDestinos() {
		return this.destinos;
	}

	public PersonajeGOT getOrigen() {
		return this.origen;
	}

	public void interaccion(String nombre) throws PersonajeNoExisteException, AristaInvalidaException {
		double aleat, porcion;
		int pesoTotal = gradoPonderado.get(nombre);
		List<Vertice<PersonajeGOT>> allDestinos;
		Vertice<PersonajeGOT> vertice = grafo.getVertice(nombre);
		origen = vertice.getDatos();
		destinos.clear();

		allDestinos = grafo.getVecinosDe(vertice);
		for (Vertice<PersonajeGOT> p : allDestinos) {
			aleat = Math.random();
			porcion = grafo.getPesoDe(vertice, p) / gradoPonderado.get(p.getDatos().getNombre());
			if (porcion > aleat) {
				destinos.add(p.getDatos());
			}
		}
		super.notificar();
	}

	public String toString() {
		String text = "";
		Iterator<Observer> it;
		it = observers.iterator();
		while (it.hasNext()) {
			text += it.next();
		}
		return text;
	}

	public static void main(String[] args)
			throws AristaInvalidaException, VerticeIdException, IOException, ArgsException, PersonajeNoExisteException {
		if (args.length != 1)
			throw new ArgsException("Se debe introducir como unico argumento el numero de iteraciones\n");
		int N = Integer.parseInt(args[0]), aleat;
		if (N <= 0)
			throw new ArgsException("El numero de iteraciones debe ser positivo");

		String aleatNombre;
		GrafoGOT grafo = new GrafoGOT("vertices.csv", "arcos.csv");
		SimuladorGOT sim = new SimuladorGOT(grafo);
		List<Vertice<PersonajeGOT>> vertices = grafo.getVertices();
		List<String> nombres = vertices.stream().map(Vertice<PersonajeGOT>::getDatos).map(PersonajeGOT::getNombre)
				.collect(Collectors.toList());

		for (int i = 0; i < N; i++) {
			aleat = (int) (Math.random()*nombres.size());
			aleatNombre = nombres.get(aleat);
			sim.interaccion(aleatNombre);
		}
		
		System.out.println(sim);
	}
}
