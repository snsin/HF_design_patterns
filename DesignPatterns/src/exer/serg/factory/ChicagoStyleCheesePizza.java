package exer.serg.factory;

public class ChicagoStyleCheesePizza extends Pizza {
	public ChicagoStyleCheesePizza() {
		name = "Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		toppings.add("Shreded Mozarella Cheese");
	}
	
	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
