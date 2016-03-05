package exer.serg.factory;

public class ChicagoStyleVeggiePizza extends Pizza {
	public ChicagoStyleVeggiePizza() {
		name = "Chicago Style Deep Dish Veggie Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		toppings.add("Sone Veggie Topping");
	}
	
	@Override
	void cut() {
		System.out.println("Cutting the pizza ino square slices");
	}

}
