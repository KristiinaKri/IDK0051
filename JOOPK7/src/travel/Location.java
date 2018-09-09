package travel;

public class Location {
	private String name, localName, country, continent;

	Location(String name, String localName, String country, String continent) {
		this.name = name;
		this.localName = localName;
		this.country = country;
		this.continent = continent;
	}

	public String getName() {
		return name;
	}

	public String getLocalName() {
		return localName;
	}

	public String getCountry() {
		return country;
	}

	public String getContinent() {
		return continent;
	}
}