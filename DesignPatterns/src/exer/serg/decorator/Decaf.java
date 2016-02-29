package exer.serg.decorator;

public class Decaf extends Beverage {
	
	public Decaf() {
		description = "Decaffeinated coffee";
	}

	@Override
	public double cost() {
		return 1.05;
	}

}
