package main;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;
import planes.*;
import airports.*;

public class Main {
	private static final String FILE = "http://dijkstra.cs.ttu.ee/~Kristiina.Kristal/IDK0051/Eksam.txt";
	private static String[] text, parts;
	private static String line;
	private static int speed, distance, price, nrOfLines = 0;
	private static double time, additionalTime = 0;
	protected static List<Airport> airports = new ArrayList<>();
	private static List<Connection> connections = new ArrayList<>();
	private static List<Flight> flights1 = new ArrayList<>();
	protected static List<Flight> flights2 = new ArrayList<>();
	private static List<Flight> testFlights = new ArrayList<>();
	private static List<Service> services = new ArrayList<>();
	private static List<Thread> threads = new ArrayList<>();

	public static void printLine() {
		System.out.println("\n----------x----------\n");
	}

	public static URL findFile() throws MalformedURLException {
		URL textFile = new URL(FILE);
		return textFile;
	}

	public static int readLines() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(findFile().openStream()));
		while (br.readLine() != null) {
			nrOfLines++;
		}
		br.close();
		return nrOfLines;
	}

	public static String[] readFile() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(findFile().openStream()));
		text = new String[readLines()];
		for (int i = 0; i < nrOfLines; i++) {
			text[i] = br.readLine();
		}
		br.close();
		System.out.println("File has been successfully read.\n");
		return text;
	}

	public static void saveAirports() {
		for (int i = 0; i < nrOfLines; i++) {
			line = text[i];
			parts = line.split("; ");
			String name = parts[0];
			String country = parts[1];
			String continent = parts[2];
			String runway = parts[3].substring(0, 1);
			int distance = Integer.parseInt(runway);
			Airport a = new Airport(name, country, continent, distance, 0);
			airports.add(a);
		}
	}

	public static void getAirportList(List<Airport> array) {
		for (Airport a : array) {
			System.out.println("Name: " + a.getName() + "\nCountry: "
					+ a.getCountry() + "\nContinent: " + a.getContinent()
					+ "\nRunway: " + a.getRunway() + " km\nPassengers: "
					+ a.getPassengers());
			printLine();
		}
	}

	public static void getContinentalAirports(String continent) {
		List<Airport> continentalAirports = airports.stream()
				.filter(a -> a.getContinent().equals(continent))
				.collect(Collectors.toList());
		System.out.println("Airports in " + continent + " ("
				+ continentalAirports.size() + "):\n");
		getAirportList(continentalAirports);
	}

	public static void getAirportsWithRunway(int distance) {
		List<Airport> runwayAirports = airports.stream()
				.filter(a -> a.getRunway() < distance)
				.collect(Collectors.toList());
		System.out.println("Airports where runway < " + distance + " km ("
				+ runwayAirports.size() + "):\n");
		getAirportList(runwayAirports);
	}

	public static String getAirport(String location) {
		List<Airport> airport = airports.stream()
				.filter(a -> a.getName().equals(location)).distinct()
				.collect(Collectors.toList());
		if (airport.isEmpty()) {
			return "No airports in " + location + "!\n";
		}
		return airport.get(0).getName();
	}

	public static Connection setupConnection(String l1, String l2) {
		if (!l1.equals(getAirport(l1)) || !l2.equals(getAirport(l2))) {
			System.out.println("Connection could not be established.\n");
			return null;
		}
		Connection c = new Connection(getAirport(l1), getAirport(l2));
		connections.add(c);
		return c;
	}

	public static Service setupService(String l1, String l2, int distance,
			String company, Plane p) {
		Connection c = setupConnection(l1, l2);
		if (c == null) {
			System.out.println("Service could not be established.\n");
			return null;
		}
		// Price is 0.07 € per km
		price = (int) (0.07 * distance);
		Service s = new Service(c, distance, company, price, p);
		services.add(s);
		return s;
	}

	public static List<Connection> findConnections(String l1, String l2) {
		List<Connection> cs = connections.stream()
				.filter(c -> c.getDeparture().equals(l1))
				.filter(c -> c.getDestination().equals(l2))
				.collect(Collectors.toList());
		return cs;
	}

	public static int findFlightLength(String l1, String l2) {
		List<Connection> cd = findConnections(l1, l2);
		if (!cd.isEmpty()) {
			distance = services.stream()
					.filter(s -> s.getC().getDeparture().equals(l1))
					.filter(s -> s.getC().getDestination().equals(l2))
					.mapToInt(s -> s.getDistance()).sum();
			if (distance < 700) {
				checkPlaneType(l1, l2);
			}
			System.out.println("Distance between " + l1 + " & " + l2 + ":\n"
					+ distance + " km\n");
			return distance;
		} else {
			System.out.println("Direct connection not found.");
			System.out.println("Would you like to transfer?\nDistance: 0 km\n");
			return 0;
		}
	}

	public static int findFlightLength(String l1, String l2, String l3) {
		List<Connection> ct1 = findConnections(l1, l2);
		List<Connection> ct2 = findConnections(l2, l3);
		ct1.addAll(ct2);
		if (!ct1.isEmpty()) {
			int length1 = services.stream()
					.filter(s -> s.getC().getDeparture().equals(l1))
					.filter(s -> s.getC().getDestination().equals(l2))
					.mapToInt(s -> s.getDistance()).sum();
			int length2 = services.stream()
					.filter(s -> s.getC().getDeparture().equals(l2))
					.filter(s -> s.getC().getDestination().equals(l3))
					.mapToInt(s -> s.getDistance()).sum();
			distance = length1 + length2;
			if (distance < 700) {
				checkPlaneType(l1, l2);
				checkPlaneType(l2, l3);
			}
			System.out.println("Distance between " + l1 + " & " + l3
					+ ":\n(with transfer from " + l2 + ")\n" + distance
					+ " km\n");
			return distance;
		} else {
			System.out.println("Transfer connection not found.");
			System.out.println("Choose another one!\nDistance: 0 km\n");
			return 0;
		}
	}

	public static int findSpeed(String l1, String l2) {
		List<Connection> cd = findConnections(l1, l2);
		if (!cd.isEmpty()) {
			speed = services.stream()
					.filter(s -> s.getC().getDeparture().equals(l1))
					.filter(s -> s.getC().getDestination().equals(l2))
					.mapToInt(s -> s.getP().getSpeed()).sum();
			return speed;
		} else {
			return 0;
		}
	}

	public static double findFlightTime(int s, int v) {
		if (v == 0) {
			System.out.println("Cannot divide with 0!");
			return 0;
		}
		time = ((double) s / (double) v) + additionalTime;
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("Flight time: " + (df.format(time)) + " h\n");
		return time;
	}

	public static double findFlightTime(int s1, int s2, int v1, int v2) {
		if (v1 == 0 || v2 == 0) {
			System.out.println("Cannot divide with 0!");
			return 0;
		}
		// Flights with transfer take 45 minutes longer
		additionalTime += 0.75;
		time = ((double) s1 / (double) v1) + ((double) s2 / (double) v2)
				+ additionalTime;
		// Turn back additional time for new calculation
		additionalTime = 0;
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("Flight time: " + (df.format(time)) + " h\n");
		return time;
	}

	public static double checkPlaneType(String l1, String l2) {
		List<Service> ss = services.stream()
				.filter(s -> s.getC().getDeparture().equals(l1))
				.filter(s -> s.getC().getDestination().equals(l2))
				.filter(s -> s.getP().getType().equals("ATR-72"))
				.collect(Collectors.toList());
		if (!ss.isEmpty()) {
			// Flights with ATR-72 type planes take 10 minutes longer
			additionalTime += (double) (1.00 / 6.00);
			return additionalTime;
		}
		return 0;
	}

	public static Optional<Flight> getFlight1() {
		synchronized (flights1) {
			if (flights1.size() > 0) {
				return Optional.of(flights1.remove(0));
			}
		}
		return Optional.empty();
	}

	public static Optional<Flight> getFlight2() {
		synchronized (flights2) {
			if (flights2.size() > 0) {
				return Optional.of(flights2.remove(0));
			}
		}
		return Optional.empty();
	}

	public static Object get() {
		synchronized (FlightConsumerTwo.f2ok) {
			while (FlightConsumerTwo.f2ok.isEmpty()) {
				try {
					FlightConsumerTwo.f2ok.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return FlightConsumerTwo.f2ok;
		}
	}

	public static void notifyThread() {
		synchronized (FlightConsumerTwo.f2ok) {
			set();
			FlightConsumerTwo.f2ok.notifyAll();
		}
	}

	public static void set() {
		synchronized (FlightConsumerTwo.f2ok) {
			for (Flight f : FlightConsumerTwo.f2ok) {
				f.getPassengers();
			}
		}
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		readFile();
		saveAirports();
		System.out.println("There are " + airports.size()
				+ " airports:\n(in alphabetical order)\n");
		getAirportList(airports);
		// 2 airports in Africa
		getContinentalAirports("Africa");
		// 6 airports in America
		getContinentalAirports("America");
		// 7 airports in Asia
		getContinentalAirports("Asia");
		// 8 airports in Europe
		getContinentalAirports("Europe");
		getAirportsWithRunway(3);
		System.out.println(getAirport("Paide"));
		setupConnection("Tokyo", getAirport("Beijing"));
		setupConnection("Paide", "Tallinn");
		Plane p1 = new Plane();
		PlaneLuxury p2 = new PlaneLuxury();
		// Plane p3 = new PlaneLuxury();
		setupService("Tokyo", "Beijing", 2098, "Japan Airlines", p2);
		setupService("Tallinn", "Kraków", 1084, "Estonian Air", p1);
		setupService("Kraków", "Cape Town", 9342, "Ryanair", p2);
		setupService("Tallinn", "Tokyo", 7881, "Estonian Air", p1);
		setupService("Tokyo", "Cape Town", 14739, "Japan Airlines", p2);
		setupService("Tallinn", "New York", 6647, "Estonian Air", p1);
		setupService("New York", "Cape Town", 12564, "American Airlines", p2);
		printLine();
		System.out.println("Finding flight distances.");
		printLine();
		findFlightLength("Tallinn", "Cape Town");
		findFlightLength("Tokyo", "Beijing");
		findFlightLength("Tallinn", "Paris", "Cape Town");
		findFlightLength("Tallinn", "Kraków", "Cape Town");
		printLine();
		System.out.println("Finding flight times.");
		printLine();
		findFlightTime(findFlightLength("Tokyo", "Cape Town"),
				findSpeed("Tokyo", "Cape Town"));
		findFlightTime(findFlightLength("Tallinn", "Kraków"),
				findFlightLength("Kraków", "Cape Town"),
				findSpeed("Tallinn", "Kraków"),
				findSpeed("Kraków", "Cape Town"));
		findFlightTime(findFlightLength("Tallinn", "New York"),
				findFlightLength("New York", "Cape Town"),
				findSpeed("Tallinn", "New York"),
				findSpeed("New York", "Cape Town"));
		findFlightTime(findFlightLength("Tallinn", "Tokyo"),
				findFlightLength("Tokyo", "Cape Town"),
				findSpeed("Tallinn", "Tokyo"),
				findSpeed("Tokyo", "Cape Town"));
		printLine();
		System.out.println("Transporting 500 passengers");
		System.out.println("from Tallinn to Florence.");
		printLine();
		airports.get(20).setPassengers(500);
		Flight f1 = new Flight(setupService("Tallinn", "Amsterdam", 1456,
				"Estonian Air", p1), 120);
		Flight f2 = new Flight(setupService("Tallinn", "Kraków", 1084,
				"Estonian Air", p1), 100);
		Flight f3 = new Flight(setupService("Tallinn", "London", 1780,
				"Estonian Air", p1), 80);
		Flight f4 = new Flight(setupService("Tallinn", "Madrid", 2893,
				"Estonian Air", p1), 60);
		Flight f5 = new Flight(setupService("Tallinn", "Stockholm", 378,
				"Estonian Air", p1), 70);
		Flight f6 = new Flight(setupService("Tallinn", "Vilnius", 530,
				"Estonian Air", p1), 70);
		flights1.add(f1);
		flights1.add(f2);
		flights1.add(f3);
		flights1.add(f4);
		flights1.add(f5);
		flights1.add(f6);
		// 500 passengers from Tallinn airport have been placed on flights
		for (Flight f : flights1) {
			airports.get(20).setPassengers(
					airports.get(20).getPassengers() - f.getPassengers());
		}
		Flight f7 = new Flight(setupService("Amsterdam", "Florence", 1063,
				"Schiphol Group", p2), 0);
		Flight f8 = new Flight(setupService("Kraków", "Florence", 961,
				"Ryanair", p2), 0);
		Flight f9 = new Flight(setupService("London", "Florence", 1208,
				"British Airways", p2), 0);
		Flight f10 = new Flight(setupService("Madrid", "Florence", 1286,
				"Aena", p2), 0);
		Flight f11 = new Flight(setupService("Stockholm", "Florence", 1791,
				"Swedavia", p2), 0);
		Flight f12 = new Flight(setupService("Vilnius", "Florence", 1580,
				"Wizz Air", p2), 0);
		flights2.add(f7);
		flights2.add(f8);
		flights2.add(f9);
		flights2.add(f10);
		flights2.add(f11);
		flights2.add(f12);
		Thread t1 = new Thread(new FlightConsumerOne("O1."));
		Thread t2 = new Thread(new FlightConsumerOne("O2."));
		Thread t3 = new Thread(new FlightConsumerOne("O3."));
		Thread t4 = new Thread(new FlightConsumerOne("O4."));
		Thread t5 = new Thread(new FlightConsumerOne("O5."));
		Thread t6 = new Thread(new FlightConsumerOne("O6."));
		Thread t7 = new Thread(new FlightConsumerTwo("O7."));
		Thread t8 = new Thread(new FlightConsumerTwo("O8."));
		Thread t9 = new Thread(new FlightConsumerTwo("O9."));
		Thread t10 = new Thread(new FlightConsumerTwo("10."));
		Thread t11 = new Thread(new FlightConsumerTwo("11."));
		Thread t12 = new Thread(new FlightConsumerTwo("12."));
		threads.add(t1);
		threads.add(t2);
		threads.add(t3);
		threads.add(t4);
		threads.add(t5);
		threads.add(t6);
		threads.add(t7);
		threads.add(t8);
		threads.add(t9);
		threads.add(t10);
		threads.add(t11);
		threads.add(t12);
		for (Thread t : threads) {
			t.start();
		}
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (Thread t : threads) {
			t.interrupt();
		}
		System.out.println(airports.get(10).getPassengers()
				+ " passengers safely landed in Florence!");
		printLine();
		Flight tf1 = new Flight(setupService("Tallinn", "Florence", 1966,
				"Estonian Air", p1), 258);
		Flight tf2 = new Flight(setupService("Lima", "Santiago", 2466,
				"Lima Airport Partners", p2), 999);
		Flight tf3 = new Flight(setupService("Bangkok", "Delhi", 2918,
				"AOT PLC", p2), 371);
		testFlights.add(tf1);
		testFlights.add(tf2);
		testFlights.add(tf3);
		for (Flight tf : testFlights) {
			System.out.println("Income from flight\n"
					+ tf.getS().getC().getDeparture() + "-"
					+ tf.getS().getC().getDestination() + ": "
					+ tf.calculateIncome((x1, x2) -> x1 * x2) + " €\n");
		}
	}
}