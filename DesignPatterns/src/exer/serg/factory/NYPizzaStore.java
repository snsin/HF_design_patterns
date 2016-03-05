package exer.serg.factory;

public class NYPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		Pizza result = null;
		if (type.equals("cheese")) {
			result = new NYStyleCheesePizza();
		}
		if (type.equals("veggie")) {
			result = new NYStyleVeggiePizza();
		}
		if (type.equals("clam")) {
			result = new NYStyleClamPizza();
		}
		if (type.equals("pepperoni")) {
			result = new NYStylePepperoniPizza();
		}
		return result;
	}

}
