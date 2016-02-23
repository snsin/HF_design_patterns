package exer.serg.observer;

public interface Subject {
	public void registerObserver(ObserverOld o);
	public void removeObserver(ObserverOld o);
	public void notifyObservers();
}
