package Interface;

public interface Observable {

	public abstract void addObserver (Observer o);
	public abstract void notifyObservers (Object o);
	public abstract void removeObservers();
 
}
