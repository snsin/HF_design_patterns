package exer.serg.decorator;

public class WpCream extends ConditimentDecorator {
	Beverage beverage;
	
	public WpCream(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whipped Cream";
	}

	@Override
	public double cost() {
		return 0.10 + beverage.cost();
	}

}
