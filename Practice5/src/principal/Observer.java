
public abstract class Observer {
	protected Subject sujeto;
	
	public Observer(Subject s) {
		this.sujeto = s;
		sujeto.anadir(this);
	}
	
	public abstract void actualizar();
}
