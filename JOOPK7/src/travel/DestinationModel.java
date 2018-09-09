package travel;

import java.util.function.DoubleFunction;

public interface DestinationModel {
	// return destination name
	public String getName();

	// return temperature in Kelvins
	public double getKelvin();

	// return temperature using provided converter method
	public double getAvgWeather(DoubleFunction<Double> tempHandler);
}