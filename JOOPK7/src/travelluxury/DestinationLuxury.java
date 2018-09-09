package travelluxury;

import travel.*;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;

public class DestinationLuxury implements DestinationModel {
	private String location;
	private double temp;
	private Temperature t;
	private Location l;

	public DestinationLuxury(Location l, Temperature t) {
		this.l = l;
		this.t = t;
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

	public double toCelsius(double temp) {
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

	public double dailyAvg(DoubleBinaryOperator dailyAvgTemp) {
		return dailyAvgTemp.applyAsDouble(t.dailyMinTemp, t.dailyMaxTemp);
	}

	public void getDetailedInfo(Consumer<Location> detailedInfo) {
		detailedInfo.accept(l);
	}
}