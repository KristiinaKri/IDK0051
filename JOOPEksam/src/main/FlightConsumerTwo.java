package main;

import java.util.*;

public class FlightConsumerTwo implements Runnable {
	protected static List<Flight> f2ok = new ArrayList<>();
	private String name;

	public FlightConsumerTwo(String name) {
		this.name = name;
	}

	public void getFlight(Optional<Flight> f) {
		if (f.isPresent()) {
			Flight flight = f.get();
			f2ok.get(0);
			System.out.println("Flight " + name + " "
					+ flight.getS().getC().getDeparture() + "-"
					+ flight.getS().getC().getDestination() + "\n"
					+ flight.getS().getCompany() + ", "
					+ flight.getS().getP().getType() + "\nPassengers: "
					+ flight.getPassengers() + "\n");
		}
	}

	public void arrived() {
		Main.airports.get(10).setPassengers(
				Main.airports.get(10).getPassengers()
						+ f2ok.get(0).getPassengers());
		f2ok.remove(0);
	}

	@Override
	public void run() {
		Main.get();
		synchronized (f2ok) {
			try {
				if (f2ok.isEmpty()) {
					Thread.sleep(5000);
				}
				Optional<Flight> flight = Main.getFlight2();
				getFlight(flight);
				while (f2ok.get(0).getS().getDistance() > 0) {
					f2ok.get(0).getS()
							.setDistance(f2ok.get(0).getS().getDistance() - 1);
					// System.out.println(f2ok.get(0).getS().getDistance());
					Thread.sleep(1);
				}
				arrived();
			} catch (InterruptedException e) {
				System.out.println("Interruption executed.");
			}
		}
	}
}