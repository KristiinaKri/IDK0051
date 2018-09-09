package loaders;

public class FastLoader extends Loader {
	private int fastPower = 50000;
	private int lowPower = 5000;

	// Meetod, mis m‰‰rab kiirlaadija vıimsuseks 5kW
	public void startLowLoad() {
		power = lowPower;
	}

	// Meetod, mis m‰‰rab kiirlaadija vıimsuseks 50kW
	@Override
	public int getPower() {
		power = fastPower;
		return power;
	}

	// Meetod, mis tagastab hetkel oleva vıimsuse
	// Kui vıimsust pole m‰‰ratud, siis vaikimisi 50kW
	@Override
	public int getCurrentPower() {
		if (power == 0) {
			power = fastPower;
		}
		return power;
	}

	// Meetod, mis prindib v‰lja info laadija kohta
	@Override
	public String readInfo() {
		return "\nLoader type: fast\n" + "Chosen power: " + getCurrentPower()
				+ "W\nCurrent power: " + power + "W\n";
	}
}