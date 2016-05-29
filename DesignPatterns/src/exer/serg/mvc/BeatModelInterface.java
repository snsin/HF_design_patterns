package exer.serg.mvc;

public interface BeatModelInterface {

	void initialize();

	void on();

	void off();

	void registerObserver(BeatObserver o);

	void removeObserver(BeatObserver o);

	void registerObserver(BpmObserver o);

	void removeObserver(BpmObserver o);

	int getBpm();

	void setBpm(int i);

}