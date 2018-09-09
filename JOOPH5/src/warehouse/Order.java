package warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Order {
	protected int serialNumber;
	protected static int counter = 100000;
	protected HashMap<Item, Integer> rows = new HashMap<Item, Integer>();

	public Order() {
		serialNumber = counter++;
	}

	public boolean add(Item item, int q) {
		if (q <= 0) {
			return false;
		}
		if (rows.containsKey(item)) {
			Integer n = rows.get(item);
			q += n; // q + n
		}
		rows.put(item, new Integer(q));
		return true;
	}

	public Integer getValue(Item item) {
		return rows.get(item);
	}

	public Set<Item> getKeySet() {
		return rows.keySet();
	}

	@Override
	public String toString() {
		String result = "Order #" + serialNumber;
		for (Map.Entry<Item, Integer> entry : rows.entrySet()) {
			Item key = entry.getKey();
			Integer value = entry.getValue();
			result += "\n\t" + key + " " + value;
		}
		return result;
	}
}