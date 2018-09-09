package warehouse;

import java.util.HashSet;
import java.util.Set;

public class StockTest {
	public static void main(String[] args) {
		Item i1 = new Item("Leib", 0.95);
		Item i2 = new Item("Piim", 0.55);
		Item i3 = new Item("Piim", 0.95);
		Item i4 = new Item("Piim", 0.95);
		// testing toString()
		System.out.println("i1 -> " + i1);
		System.out.println("i2 -> " + i2);
		System.out.println("i3 -> " + i3);
		System.out.println("i4 -> " + i4);
		// testing equals()
		System.out.println("i1 vs i2 " + i1.equals(i2)); // false
		System.out.println("i2 vs i3 " + i2.equals(i3)); // false
		System.out.println("i3 vs i4 " + i3.equals(i4)); // true, false before
														 // equals() override
		System.out.println("i4 vs i4 " + i4.equals(i4)); // true
		// testing hashCode()
		Set<Item> itemSet = new HashSet<Item>();
		System.out.println("adding i1 " + itemSet.add(i1));
		System.out.println("adding i2 " + itemSet.add(i2));
		System.out.println("adding i3 " + itemSet.add(i3));
		System.out.println("adding i4 " + itemSet.add(i4));
		System.out.println("adding i4 again " + itemSet.add(i4));

		Order receipt = new Order();
		System.out.println("receipt " + receipt);
		Order receipt1 = new Order();
		System.out.println("receipt " + receipt1);

		System.out.println("receipt.add(i1, 5) " + receipt.add(i1, 5));
		System.out.println("receipt.add(i2, 5) " + receipt.add(i2, 5));
		System.out.println("receipt.add(i3, 5) " + receipt.add(i3, 5));
		System.out.println("receipt.add(i4, 5) " + receipt.add(i4, 5));

		System.out.println("receipt " + receipt);

		Stock s = new Stock();
		s.receive(receipt);

		System.out.println("i1 " + s.getAvailable(i1));
		System.out.println("i4 " + s.getAvailable(i4));
		System.out.println("new object 1 " + s.getAvailable(new Item("Leib", 0.95)));
		System.out.println("new object 2 " + s.getAvailable(new Item("Leib", 0.65)));
	}
}