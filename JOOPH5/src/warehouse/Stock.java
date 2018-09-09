package warehouse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Stock {
	private HashMap<Item, Integer> items = new HashMap<Item, Integer>();

	public void receive(Order order) {
		Set<Item> keys = order.getKeySet();
		Iterator<Item> iter = keys.iterator();
		while (iter.hasNext()) {
			Item item = iter.next();
			Integer n = order.getValue(item);
			if (items.containsKey(item)) {
				n += items.get(item);
			}
			items.put(item, new Integer(n));
		}
	}

	public int getAvailable(Item item) {
		if (items.containsKey(item)) {
			return items.get(item); // return quantity
		}
		return 0;
	}

	public boolean dispatch(Order order) {
		return true;
	}

	@Override
	public String toString() {
		return "Stock";
	}
}