package main;

import java.util.*;
import java.util.stream.*;

public class FlightConsumerOne implements Runnable {
	private static List<Flight> f1 = new ArrayList<>();
	private static List<Flight> f2 = new ArrayList<>();
	private String name;

	public FlightConsumerOne(String name) {
		this.name = name;
	}

	public void getFlight(Optional<Flight> f) {
		if (f.isPresent()) {
			Flight flight = f.get();
			f1.add(flight);
			System.out.println("Flight " + name + " "
					+ flight.getS().getC().getDeparture() + "-"
					+ flight.getS().getC().getDestination() + "\n"
					+ flight.getS().getCompany() + ", "
					+ flight.getS().getP().getType() + "\nPassengers: "
					+ flight.getPassengers() + "\n");
		}
	}

	public void transfer() {
		f2 = Main.flights2
				.stream()
				.filter(x -> x.getS().getC().getDeparture()
						.equals(f1.get(0).getS().getC().getDestination()))
				.collect(Collectors.toList());
		f2.get(0).setPassengers(f1.get(0).getPassengers());
		f1.get(0).setPassengers(0);
		FlightConsumerTwo.f2ok.add(f2.get(0));
		f1.remove(0);
	}

	@Override
	public void run() {
		synchronized (f1) {
			try {
				Optional<Flight> flight = Main.getFlight1();
				getFlight(flight);
				try {
					for (Flight f1 : f1) {
						while (f1.getS().getDistance() > 0) {
							f1.getS().setDistance(f1.getS().getDistance() - 1);
							// System.out.println(f1.getS().getDistance());
							Thread.sleep(1);
						}
						transfer();
					}
				} catch (ConcurrentModificationException e) {
				}
			} catch (InterruptedException e) {
				System.out.println("Interruption executed.");
			}
		}
		Main.notifyThread();
	}
}