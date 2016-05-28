package exer.serg.somepartterns;

public interface QuackObservable {
	void registerObserver(Observer observer);
	void notifyObservers();

}
