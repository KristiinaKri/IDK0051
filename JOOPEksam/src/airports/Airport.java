package airports;

public class Airport {
	private String name, country, continent;
	private int runway, passengers;

	public Airport(String name, String country, String continent,
			int runway, int passengers) {
		this.name = name;
		this.country = country;
		this.continent = continent;
		this.runway = runway;
		this.passengers = passengers;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String getContinent() {
		return continent;
	}

	public int getRunway() {
		return runway;
	}

	public int getPassengers() {
		return passengers;
	}

	public int setPassengers(int passengers) {
		this.passengers = passengers;
		return passengers;
	}
}