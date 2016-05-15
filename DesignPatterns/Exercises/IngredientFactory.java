package exer.serg.factory;

import exer.serg.factory.Cheese;
import exer.serg.factory.Clams;
import exer.serg.factory.Dough;
import exer.serg.factory.Pepperoni;
import exer.serg.factory.Sauce;
import exer.serg.factory.Veggies;

public interface PizzaIngredientFactory {
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();

}
