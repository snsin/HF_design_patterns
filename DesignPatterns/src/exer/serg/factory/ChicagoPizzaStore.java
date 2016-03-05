package exer.serg.factory;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		Pizza result = null;
		if (type.equals("cheese")) {
			result = new ChicagoStyleCheesePizza();
		}
		if (type.equals("veggie")) {
			result = new ChicagoStyleVeggiePizza();
		}
		if (type.equals("clam")) {
			result = new ChicagoStyleClamPizza();
		}
		if (type.equals("pepperoni")) {
			result = new ChicagoStylePepperoniPizza();
		}
		return result;
	}

}
