package exer.serg.composite;

public class MenuItem extends MenuComponent {
	private String name;
	private String description;
	private boolean vegeterian;
	private double price;
	
	public MenuItem(String name, 
			String description,
			boolean vegeterian,
			double price) {
		this.name = name;
		this.description = description;
		this.vegeterian = vegeterian;
		this.price = price;
	}

}
