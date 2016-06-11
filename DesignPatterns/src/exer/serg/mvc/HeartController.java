package exer.serg.mvc;

public class HeartController implements ControllerInterface {
	
	private HeartModelInterface model;
	private DjView view;

	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new DjView(this, new HeartAdapter(model));
		view.createView();
		view.createControls();
		view.disableStartMenuItem();
		view.disableStopMenuItem();
	}	
	
	@Override
	public void start() {

	}

	@Override
	public void stop() {

	}

	@Override
	public void increaseBpm() {

	}

	@Override
	public void decreaseBpm() {

	}

	@Override
	public void setBpm(int bpm) {

	}

}
