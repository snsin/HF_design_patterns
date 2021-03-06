package exer.serg.composite;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {
	private Iterator<MenuComponent> iterator = null;
	private ArrayList<MenuComponent> menuComponents = new ArrayList<>();
	private String name;
	private String description;
	
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;		
	}
	
	@Override
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
	
	@Override
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
	
	@Override
	public MenuComponent getChild(int i) {
		return menuComponents.get(i);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("----------------------");
		for (MenuComponent menuComponent : menuComponents) {
			menuComponent.print();
		}
	}

	@Override
	public Iterator<MenuComponent> createIterator() {
		if (iterator == null) {
			iterator =  new CompositeIterator(menuComponents.iterator());
		}
		return iterator;
	}

}
