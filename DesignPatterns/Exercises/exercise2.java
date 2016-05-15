public class Beverage {
	String description;
	
	public double cost() {
		double cost = 0.0;
		if (hasMilk()) { cost += milkCost); }
		if (hasSoy()) { cost += soyCost); }
		if (hasMocha()) { cost += mochaCost); }
		if (hasWhip()) { cost += whipCost); }
		return cost;
	}
}

public class DarkRoast extends Beverage {
	double cost = 1.0;
	
	public DarkRoast() {
		description = "Most Exce ... bla bla bla"
	}
	
	public double cost() {
		return super.cost() + this.cost;
	}
}