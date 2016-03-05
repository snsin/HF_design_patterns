package exer.serg.factory;

public class ChicagoStyleVeggiePizza extends Pizza {
	public ChicagoStyleVeggiePizza() {
		name = "Chicago Style Deep Dish Veggie Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		toppings.add("Some Veggie Topping");
	}
	
	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}

}
