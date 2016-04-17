package exer.serg.composite;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<MenuComponent> {
	Stack<Iterator<MenuComponent>> stack = new Stack<>();
	
	public CompositeIterator(Iterator<MenuComponent> iterator) {
		if (iterator != null) {
			stack.push(iterator);
		}
	}

	@Override
	public boolean hasNext() {
		boolean result = false;
		if ( !stack.empty() ) {
			Iterator<MenuComponent> iterator = stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				result =  hasNext();
			} else {
				result = true;
			}
		}
		return result;
	}

	@Override
	public MenuComponent next() {
		MenuComponent result = null;
		if (hasNext()) {
			Iterator<MenuComponent> iterator = stack.peek();
			result = iterator.next();
			if (result instanceof Menu) {
				stack.push(result.createIterator());
			}
		}
		return result;
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
