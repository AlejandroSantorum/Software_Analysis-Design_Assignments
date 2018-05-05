import java.util.*;

public abstract class Subject {
	protected List<Observer> observers;
	
	public Subject() {
		this.observers = new ArrayList<Observer>();
	}
	
	public void anadir(Observer o) {
		observers.add(o);
	}
	
	public void borrar(Observer o) {
		observers.remove(o);
	}
	
	public void notificar() {
		Iterator<Observer> it;
		it = observers.iterator();
		while (it.hasNext()) {
			it.next().actualizar();
		}
	}
}
