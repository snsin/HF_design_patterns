package exer.serg.mvc;

public class DjTestDrive {
	public static void main(String...args) {
		HeartModel model = new HeartModel();
		final ControllerInterface controller = new HeartController(model);	
		
		for (String key : System.getenv().keySet()) {
			System.out.println(key + " : " + System.getProperty(((String)key)));
		}
		Object name = new Object();
	}
}
