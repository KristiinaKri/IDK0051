package toyfactory;

import java.util.function.DoubleBinaryOperator;

// see v6iks olla ylemklass - siin muutusi poleks vaja
public class OrderCar {
	private String mark, model;
	private int axis, doors, serialNr, wheels;

	public OrderCar(String mark, String model, int axis, int doors, int serialNr) {
		this.mark = mark;
		this.model = model;
		this.axis = axis;
		this.doors = doors;
		this.serialNr = serialNr;
	}

	public int getNrOfWheels() {
		wheels = axis * 2;
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