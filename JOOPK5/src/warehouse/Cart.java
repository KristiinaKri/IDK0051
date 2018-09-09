package warehouse;

import java.util.Map;

public class Cart extends Order {
	private double sum = 0;

	public void add(Item item) {
		super.add(item, 1);
	}

	public boolean change(Item item, int q) {
		if (q <= 0) {
			return false;
		}
		if (rows.containsKey(item)) {
			rows.put(item, new Integer(q));
		}
		return true;
	}

	public void remove(Item item) {
		if (rows.containsKey(item)) {
			rows.remove(item);
		}
	}

	public void clear() {
		rows.clear();
	}

	public double getTotal() {
		for (Map.Entry<Item, Integer> entry : rows.entrySet()) {
			Item key = entry.getKey();
			Integer value = entry.getValue();
			sum += key.getPrice() * value;
		}
		System.out.print("Checkout sum: ");
		System.out.format("%.2f", sum);
		System.out.println("\n");
		return sum;
	}

	public Order checkOut() {
		Order cartOrder = new Order();
		for (Map.Entry<Item, Integer> entry : rows.entrySet()) {
			Item key = entry.getKey();
			Integer value = entry.getValue();
			cartOrder.add(key, value);
		}
		System.out.println("Check out:\n\t" + cartOrder);
		return cartOrder;
	}

	@Override
	public String toString() {
		System.out.println("Checking order in cart");
		return super.toString();
	}
}