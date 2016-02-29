package exer.serg.decorator;

public class Mocha extends ConditimentDecorator {
	
	Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return 0.20 + beverage.cost();
	}

}
