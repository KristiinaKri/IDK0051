package travel;

public class DestinationTest {
	public static void main(String[] args) {
		Destination d1 = new Destination("Paide", 296.15);
		Destination d2 = new Destination("Rooma", 307.15);
		Destination d3 = new Destination("Stockholm", 278.15);
		d1.getCelsius();
		d2.getCelsius();
		d3.getCelsius();
		d1.getFahrenheit();
		d2.getFahrenheit();
		d3.getFahrenheit();
		System.out.println(d1.getAvgWeather(t -> t - 273.15));
		System.out.println(d1.getAvgWeather(t -> t * (9.0 / 5.0) - 459.67));
		System.out.println(d1.getAvgWeather(Destination::toCelsius));
		System.out.println(d1.getAvgWeather(Destination::toFahrenheit));
	}
}