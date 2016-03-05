package exer.serg.factory;

public class NYPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		Pizza result = null;
		if (type.equals("ceese")) {
			result = new NYStyleChesePizza();
		}
		return result;
	}

}
