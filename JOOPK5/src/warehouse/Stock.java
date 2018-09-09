package warehouse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Stock {
	private HashMap<Item, Integer> items = new HashMap<Item, Integer>();

	public void receive(Order order) {
		Set<Item> keys = order.getKeySet();
		Iterator<Item> iterator = keys.iterator();
		while (iterator.hasNext()) {
			Item item = iterator.next();
			Integer n = order.getValue(item);
			if (items.containsKey(item)) {
				n += items.get(item);
			}
			items.put(item, new Integer(n));
		}
	}

	public int getAvailable(Item item) {
		if (items.containsKey(item)) {
			System.out.println("In stock:\n" + item);
			return items.get(item);
		}
		return 0;
	}

	public void dispatch(Order order) {
		Set<Item> keys = order.getKeySet();
		Iterator<Item> iterator = keys.iterator();
		while (iterator.hasNext()) {
			Item item = iterator.next();
			Integer n = order.getValue(item);
			System.out.println(item);
			System.out.println("Items ordered: " + n);
			System.out.println("Items in stock: " + items.get(item));
			if (items.containsKey(item)) {
				n = items.get(item) - n;
				if (items.get(item) < 0 || n < 0) {
					System.out.println("Cannot purchase, stock too small.");
					n = items.get(item);
				}
			}
			items.put(item, new Integer(n));
			System.out.println("Items in stock: " + items.get(item) + " (updated)\n");
		}
	}

	@Override
	public String toString() {
		System.out.println("Available items in stock:");
		return items.toString();
	}
}