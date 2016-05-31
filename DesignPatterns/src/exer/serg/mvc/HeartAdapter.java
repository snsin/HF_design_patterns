package exer.serg.mvc;

public class HeartAdapter implements BeatModelInterface {

	private HeartModelInterface heart;
	
	public HeartAdapter(HeartModelInterface heart) {
		this.heart = heart;
	}	
	
	@Override
	public void initialize() {}

	@Override
	public void on() {}

	@Override
	public void off() {}

	@Override
	public void registerObserver(BeatObserver o) {
		heart.registerObserver(o);
	}

	@Override
	public void removeObserver(BeatObserver o) {
		heart.removeObserver(o);
	}

	@Override
	public void registerObserver(BpmObserver o) {
		heart.registerObserver(o);
	}

	@Override
	public void removeObserver(BpmObserver o) {
		heart.removeObserver(o);
	}

	@Override
	public int getBpm() {
		return heart.getHeartRate();
	}

	@Override
	public void setBpm(int i) {}

}
