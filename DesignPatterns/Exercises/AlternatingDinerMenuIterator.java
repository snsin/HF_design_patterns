import java.util.Iterator;
import java.util.Calendar;

public class AlternatingDinerMenuIterator implements Iterator {
	MenuItem[] items;
	int position;
	
	public AlternatingDinerMenuIterator(MenuItem[] items) {
		this.items = items;
		Calendar rightNow = Calendar.getInstance();
		position = rightNow.get(Calendar.DAY_OF_WEEK) % 2;
	}
	
	@Override
	public boolean hasNext() {
		if (position >= items.length || items[positon] == null) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public Object next() {
		MenuItem menuItem = items[positon];
		position += 2;
		return menuItem;
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException(
				"Alternating Diner Menu Iterator does not support remove()");
	}
	
}