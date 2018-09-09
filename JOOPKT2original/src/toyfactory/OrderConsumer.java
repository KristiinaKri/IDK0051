package toyfactory;

import java.util.Optional;

public class OrderConsumer implements Runnable {
	private String name;

	public OrderConsumer(String name) {
		this.name = name;
	}

	public void getOrderCar(Optional<OrderCar> o) {
		if (o.isPresent()) {
			OrderCar oc = o.get();
			System.out.println(name + " " + oc.getMark() + " " + oc.getModel()
					+ " " + oc.getAxis() + " " + oc.getDoors() + " "
					+ oc.getSerialNr() + " Hind:"
					+ oc.getPrice((x1, x2) -> (x1 * 1.3) + (x2 * 0.7)));
		}
	}

	public void getOrderTruck1(Optional<OrderTruck> ot1) {
		if (ot1.isPresent()) {
			OrderTruck ot = ot1.get();
			System.out.println(name + " " + ot.getMark() + " " + ot.getModel()
					+ " " + ot.getAxis() + " " + ot.getDoors() + " "
					+ ot.getSerialNr() + " " + ot.getBox() + " Hind:"
					+ ot.getPrice((x1, x2) -> (x1 * 1.3) + (x2 * 0.7)));
		}
	}

	public void getOrderTruck2(Optional<OrderTruck> ot2) {
		if (ot2.isPresent()) {
			OrderTruck ot = ot2.get();
			System.out.println(name + " " + ot.getMark() + " " + ot.getModel()
					+ " " + ot.getAxis() + " " + ot.getDoors() + " "
					+ ot.getSerialNr() + " " + ot.getBox() + " Hind:"
					+ ot.getPrice((x1, x2) -> (x1 * 1.3) + (x2 * 0.7)));
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				Optional<OrderCar> oc = OrderTest.getOrderCar();
				getOrderCar(oc);
				Optional<OrderTruck> ot1 = OrderTest.getOrderTruck1();
				getOrderTruck1(ot1);
				Optional<OrderTruck> ot2 = OrderTest.getOrderTruck2();
				getOrderTruck2(ot2);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			System.out.println("Interruption executed.");
		}
	}
}