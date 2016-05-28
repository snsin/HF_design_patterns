package exer.serg.mvc;

public class BeatController implements ControllerInterface {
	private BeatModelInterface model;
	private DjView view;

	public BeatController(BeatModelInterface model) {
		this.model = model;
		view = new DjView(); //TODO change constructor
		view.createView();
		view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
	}
	
	@Override
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}
	
	@Override
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
	
	@Override
	public void increaseBpm() {
		final int bpm = model.getBpm();
		model.setBpm(bpm + 1);
	}
	
	@Override
	public void decreaseBpm() {
		final int bpm = model.getBpm();
		model.setBpm(bpm - 1);
	}
	
	@Override
	public void setBpm(int bpm) {
		model.setBpm(bpm);
	}
}
