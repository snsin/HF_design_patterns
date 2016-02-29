package exer.serg.decorator;

public class Soy extends ConditimentDecorator {
	
	Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;

	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() {
		double cost = beverage.cost();
		Beverage.Size sz = getSize();
		switch (sz) { 
		case TALL:
			cost += 0.10;
			break;
		case GRANDE:
			cost += 0.15;
			break;
		case VENTY:
			cost += 0.20;
			break;
		}
		return cost;
	}

}
