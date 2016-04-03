package exer.serg.command;

public class CeillingFan {
	
	private String place;
	
	public CeillingFan(String place) {
		this.place = place;
	}
	
	public void high() {
		System.out.println(place + " ceilling fan is on high!");
	}
	
	public void medium() {
		System.out.println(place + " ceilling fan is on medium!");
	}
	
	public void low() {
		System.out.println(place + " ceilling fan is on low!");
	}
	
	public void off() {
		System.out.println(place + "  ceilling fan is off!");
	}

}
