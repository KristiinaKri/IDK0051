package travel;

import java.util.function.DoubleFunction;

public class Destination implements DestinationModel {
	private String location;
	private double temp;
	private static double t;

	Destination(String location, double temp) {
		this.location = location;
		this.temp = temp;
	}

	public double getCelsius() {
		double cTemp = temp - 273.15;
		System.out.println("K to C: " + cTemp);
		return cTemp;
	}

	public double getFahrenheit() {
		double fTemp = temp * (9.0 / 5.0) - 459.67;
		System.out.println("K to F: " + fTemp);
		return fTemp;
	}

	public static double toCelsius(double temp) {
		return temp - 273.15;
	}

	public static double toFahrenheit(double temp) {
		return temp * (9.0 / 5.0) - 459.67;
	}

	@Override
	public String getName() {
		return location;
	}

	@Override
	public double getKelvin() {
		return temp;
	}

	@Override
	public double getAvgWeather(DoubleFunction<Double> tempHandler) {
		return tempHandler.apply(temp);
	}
}