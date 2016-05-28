package exer.serg.mvc;

import java.util.Timer;
import java.util.TimerTask;

public class DjTestDrive {
	public static void main(String...args) {
		BeatModel model = new BeatModel();
		final ControllerInterface controller = new BeatController(model);
		controller.start();
		Timer updBpm = new Timer();
		updBpm.schedule(new TimerTask() {
			
			@Override
			public void run() {
				controller.increaseBpm();
				
			}
		}, 10000, 5000);
	}
	

}
