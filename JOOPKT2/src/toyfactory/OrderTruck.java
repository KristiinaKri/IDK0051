package toyfactory;

import java.util.function.DoubleBinaryOperator;

// see peaks olema OrderCar alamklass - enamus meetodeid p2riks sellelt ja pole vaja uuesti luua
// yle kirjutada tuleks ainult need meetodid, mis teevad midagi teisiti kui ylemklassis
public class OrderTruck {
	private String mark, model, box;
	private int axis, doors, serialNr, wheels;

	public OrderTruck(String mark, String model, int axis, int doors, int serialNr, String box) {
		this.mark = mark;
		this.model = model;
		this.axis = axis;
		this.doors = doors;
		this.serialNr = serialNr;
		this.box = box;
	}

	public int getNrOfWheels() {
		wheels = (axis * 2) + 2;
		return wheels;
	}

	public double getPrice(DoubleBinaryOperator price) {
		return price.applyAsDouble(doors, wheels);
	}

	public String getMark() {
		return mark;
	}

	public String getModel() {
		return model;
	}

	public String getBox() {
		return box;
	}

	public int getAxis() {
		return axis;
	}

	public int getDoors() {
		return doors;
	}

	public int getSerialNr() {
		return serialNr;
	}
}