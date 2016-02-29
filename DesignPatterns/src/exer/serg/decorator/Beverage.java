package exer.serg.decorator;



public abstract class Beverage {
	public enum Size {TALL, GRANDE, VENTY};
	String description = "Unknown Beverage";
	Size size;
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public Size getSize() {
		return size;
	}

}
