package exer.serg.mvc;

public class DjTestDrive {
	public static void main(String...args) {
		HeartModel model = new HeartModel();
		final ControllerInterface controller = new HeartController(model);		
	}
}
