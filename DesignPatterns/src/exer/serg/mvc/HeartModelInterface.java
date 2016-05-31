package exer.serg.mvc;

public interface HeartModelInterface {

	int getHeartRate();

	void registerObserver(BeatObserver o);

	void removeObserver(BeatObserver o);

	void registerObserver(BpmObserver o);

	void removeObserver(BpmObserver o);

}