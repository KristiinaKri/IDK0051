package warehouse;

//import java.util.HashSet;
//import java.util.Set;

public class StockTest {
	public static void printLine() {
		System.out.println("\n\n----------x----------\n\n");
	}

	public static void main(String[] args) {
		Item i1 = new Item("bread", 0.95);
		Item i2 = new Item("milk", 0.55);
		Item i3 = new Item("milk", 0.95);
		Item i4 = new Item("milk", 0.95);
		Item i5 = new Item("apple", 0.30);
		Item i6 = new Item("candy", 0.10);
		/*
		 * System.out.println("i1 vs i2 " + i1.equals(i2));
		 * System.out.println("i2 vs i3 " + i2.equals(i3));
		 * System.out.println("i3 vs i4 " + i3.equals(i4));
		 * System.out.println("i4 vs i4 " + i4.equals(i4)); Set<Item> itemSet = new HashSet<Item>();
		 * System.out.println("adding i1 " + itemSet.add(i1));
		 * System.out.println("adding i2 " + itemSet.add(i2));
		 * System.out.println("adding i3 " + itemSet.add(i3));
		 * System.out.println("adding i4 " + itemSet.add(i4));
		 * System.out.println("adding i4 again " + itemSet.add(i4));
		 */
		Order receipt1 = new Order();
		receipt1.add(i1, 5);
		receipt1.add(i2, 10);
		receipt1.add(i3, 5);
		receipt1.add(i4, 15);
		System.out.println(receipt1);
		Stock s1 = new Stock();
		s1.receive(receipt1);
		System.out.println(s1.getAvailable(i1));
		System.out.println(s1.getAvailable(i2));
		System.out.println(s1.getAvailable(i3));
		System.out.println(s1.getAvailable(i4));
		System.out.println(s1.getAvailable(i5));
		System.out.println(s1.getAvailable(i6));
		System.out.println(s1.toString());
		// System.out.println("New item 1: " + s1.getAvailable(new Item("bread", 0.95)));
		// System.out.println("New item 2: " + s1.getAvailable(new Item("bread", 0.65)));
		printLine();
		Order receipt2 = new Order();
		receipt2.add(i1, 1);
		receipt2.add(i2, 3);
		receipt2.add(i3, 4);
		receipt2.add(i4, 1);
		receipt2.add(i5, 2);
		receipt2.add(i6, 11);
		System.out.println(receipt2);
		Stock s2 = new Stock();
		s2.receive(receipt2);
		System.out.println(s2.getAvailable(i1));
		System.out.println(s2.getAvailable(i2));
		System.out.println(s2.getAvailable(i3));
		System.out.println(s2.getAvailable(i4));
		System.out.println(s2.getAvailable(i5));
		System.out.println(s2.getAvailable(i6));
		System.out.println(s2.toString());
		printLine();
		Order receipt3 = new Order();
		receipt3.add(i1, 2);
		receipt3.add(i5, 3);
		System.out.println(receipt3);
		Stock s3 = new Stock();
		s3.receive(receipt3);
		System.out.println(s3.getAvailable(i1));
		System.out.println(s3.getAvailable(i5));
		System.out.println(s3.toString());
		printLine();
		Order receipt4 = new Order();
		receipt4.add(i6, 10);
		receipt4.add(i6, 2);
		receipt4.add(i4, 3);
		System.out.println(receipt4);
		Stock s4 = new Stock();
		s4.receive(receipt4);
		System.out.println(s4.getAvailable(i4));
		System.out.println(s4.getAvailable(i6));
		System.out.println(s4.toString());
		printLine();
		Cart c = new Cart();
		c.add(i1);
		c.add(i2, 2);
		c.change(i1, 6);
		c.remove(i2);
		c.add(i2, 1);
		c.add(i2, 1);
		c.add(i2, 1);
		System.out.println(c);
		c.getTotal();
		receipt2 = c.checkOut();
		s1.dispatch(receipt2);
		c.clear();
		System.out.println(c);
		printLine();
		Cart cc = new Cart();
		cc.add(i6, 5);
		cc.add(i4);
		cc.add(i3, 2);
		cc.change(i6, 3);
		cc.remove(i3);
		cc.add(i2, 1);
		cc.change(i4, 2);
		System.out.println(cc);
		cc.getTotal();
		receipt4 = c.checkOut();
		s1.dispatch(receipt1);
		cc.clear();
		System.out.println(cc);
	}
}