package exer.serg.command;

public class CeillingFan {
	enum State {OFF, LOW, MEDIUM, HIGH};
	
	private String place;
	private State state;
	
	public CeillingFan(String place) {
		this.place = place;
		state = State.OFF;
	}
	
	public void high() {
		state = State.HIGH;
		System.out.println(place + " ceilling fan is on high!");
	}
	
	public void medium() {
		state = State.MEDIUM;
		System.out.println(place + " ceilling fan is on medium!");
	}
	
	public void low() {
		state = State.LOW;
		System.out.println(place + " ceilling fan is on low!");
	}
	
	public void off() {
		state = State.OFF;
		System.out.println(place + "  ceilling fan is off!");
	}
	
	public State getState() {
		return this.state;
	}

}
