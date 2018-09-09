package airports;

public class Connection {
	private String departure, destination;

	public Connection(String departure, String destination) {
		this.departure = departure;
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public String getDestination() {
		return destination;
	}
}