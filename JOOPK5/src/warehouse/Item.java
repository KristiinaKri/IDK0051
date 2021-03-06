package warehouse;

public class Item {
	private String name;
	private double price;

	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Item: " + name + ", price = " + price + " �";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Item)) {
			return false;
		}
		Item item = (Item) o;
		return name.equals(item.name) && price == item.price;
	}

	@Override
	public int hashCode() {
		return name.hashCode() * (int) (100 * price);
	}
}