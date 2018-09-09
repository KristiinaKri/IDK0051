package travel;

public class Temperature {
	private double avgTemp;
	public double dailyMinTemp, dailyMaxTemp;

	Temperature(double avgTemp, double dailyMinTemp, double dailyMaxTemp) {
		this.avgTemp = avgTemp;
		this.dailyMinTemp = dailyMinTemp;
		this.dailyMaxTemp = dailyMaxTemp;
	}
}