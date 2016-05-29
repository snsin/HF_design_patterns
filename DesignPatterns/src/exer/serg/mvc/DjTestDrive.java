package exer.serg.mvc;

public class DjTestDrive {
	public static void main(String...args) {
		BeatModel model = new BeatModel();
		final ControllerInterface controller = new BeatController(model);		
	}
}
