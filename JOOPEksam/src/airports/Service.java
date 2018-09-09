package airports;

import planes.Plane;

public class Service {
	private Connection connection;
	private Plane plane;
	private String company;
	private int distance, price;

	public Service(Connection connection, int distance, String company,
			int price, Plane plane) {
		this.connection = connection;
		this.distance = distance;
		this.company = company;
		this.price = price;
		this.plane = plane;
	}

	public Connection getC() {
		return connection;
	}

	public Plane getP() {
		return plane;
	}

	public String getCompany() {
		return company;
	}

	public int getDistance() {
		return distance;
	}

	public int setDistance(int distance) {
		this.distance = distance;
		return distance;
	}

	public int getPrice() {
		return price;
	}
}