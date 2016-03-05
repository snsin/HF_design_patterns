package exer.serg.factory;

public class ChicagoStylePepperoniPizza extends Pizza {
	public ChicagoStylePepperoniPizza() {
		name = "Chicago Style Deep Dish Pepperoni Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		toppings.add("Sliced Pepperoni");
	}
	
	@Override
	void cut() {
		System.out.println("Cutting the pizza ino square slices");
	}
}
