package toyfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderTest {
	public static List<OrderCar> cars = new ArrayList<>();
	public static List<OrderTruck> trucks1 = new ArrayList<>();
	public static List<OrderTruck> trucks2 = new ArrayList<>();

	public static Optional<OrderCar> getOrderCar() {
		synchronized (cars) {
			if (cars.size() > 0) {
				return Optional.of(cars.remove(0));
			}
		}
		return Optional.empty();
	}

	public static Optional<OrderTruck> getOrderTruck1() {
		synchronized (trucks1) {
			if (trucks1.size() > 0) {
				return Optional.of(trucks1.remove(0));
			}
		}
		return Optional.empty();
	}

	public static Optional<OrderTruck> getOrderTruck2() {
		synchronized (trucks2) {
			if (trucks2.size() > 0) {
				return Optional.of(trucks2.remove(0));
			}
		}
		return Optional.empty();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 900; i++) {
			OrderCar oc = new OrderCar("Volkswagen", "Golf", 2, 4,
					Integer.valueOf(String.valueOf(1) + String.valueOf(i)));
			cars.add(oc);
		}
		for (int i = 0; i < 350; i++) {
			OrderTruck ot1 = new OrderTruck("Audi", "A6", 3, 3,
					Integer.valueOf(String.valueOf(2) + String.valueOf(i)), "open");
			trucks1.add(ot1);
		}
		for (int i = 0; i < 250; i++) {
			OrderTruck ot2 = new OrderTruck("Citreon", "C4", 2, 2,
					Integer.valueOf(String.valueOf(3) + String.valueOf(i)), "fridge");
			trucks2.add(ot2);
		}
		Thread t1 = new Thread(new OrderConsumer("O1."));
		Thread t2 = new Thread(new OrderConsumer("O2."));
		Thread t3 = new Thread(new OrderConsumer("O3."));
		Thread t4 = new Thread(new OrderConsumer("O4."));
		Thread t5 = new Thread(new OrderConsumer("O5."));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();
		t4.interrupt();
		t5.interrupt();
	}
}