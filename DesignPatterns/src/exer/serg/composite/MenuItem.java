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
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public double getPrice() {
		return price;
	}
	
	@Override
	public boolean isVegetarian() {
		return vegeterian;
	}
	
	@Override
	public void print() {
		System.out.print("   " + getName());
		if (isVegetarian()) {
			System.out.print("(v)");
		}
		System.out.println(", " + getPrice());
		System.out.println("     -- " + getDescription());
	}

}
