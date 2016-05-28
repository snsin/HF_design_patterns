package exer.serg.mvc;

import java.util.TimerTask;

public class BeatStub extends TimerTask {
	
	private BeatModelInterface beatModel;

	public BeatStub(BeatModelInterface beatModel) {
		this.beatModel = beatModel;
	}

	@Override
	public void run() {
		beatModel.beatEvent();

	}

}
