package exer.serg.decorator;

public class Whip extends ConditimentDecorator {
	
	Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() {
		return 0.10 + beverage.cost();
	}

}
