package main;

import java.util.function.IntBinaryOperator;
import airports.Service;

public class Flight {
	private Service service;
	private int passengers;

	public Flight(Service service, int passengers) {
		this.service = service;
		this.passengers = passengers;
	}

	public Service getS() {
		return service;
	}

	public int getPassengers() {
		return passengers;
	}

	public int setPassengers(int passengers) {
		this.passengers = passengers;
		return passengers;
	}

	public int calculateIncome(IntBinaryOperator calculator) {
		return calculator.applyAsInt(service.getPrice(), passengers);
	}
}