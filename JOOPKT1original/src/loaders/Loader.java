package loaders;

public class Loader {
	private int normalPower = 2000;
	protected int power;
	protected int oldPower;

	// static factory meetod, mis tagastab i=2 korral kiirlaadija
	// Vastasel juhul tavalise laadija
	public static Loader getInstance(int i) {
		if (i == 2) {
			return new FastLoader();
		} else {
			return new Loader();
		}
	}

	// Meetod, mis m‰‰rab laadija vıimsuseks 2kW
	public int getPower() {
		power = normalPower;
		return power;
	}

	// Meetod, mis tagastab hetkel oleva vıimsuse
	// Kui vıimsust pole m‰‰ratud, siis vaikimisi 2kW
	public int getCurrentPower() {
		if (power == 0) {
			power = normalPower;
		}
		return power;
	}

	// Meetod, mis alustab laadimist
	public void startLoad() {
		System.out.println("Start! Power: " + getCurrentPower() + "W");
	}

	// Meetod, mis lıpetab laadimise
	public void stopLoad() {
		System.out.println("Stop! Final power: " + getCurrentPower() + "W");
	}

	// Meetod, mis m‰‰rab laadija vıimsuse vastavalt i-le
	// Samuti salvestatakse eelnev vıimsus
	public void startCrashLoad(int i) {
		oldPower = power;
		power = i * 1000;
	}

	// Meetod, mis m‰‰rab laadija vıimsuseks salvestatud vıimsuse
	public void stopCrashLoad() {
		power = oldPower;
	}

	// Meetod, mis prindib v‰lja info laadija kohta
	public String readInfo() {
		return "\nLoader type: normal\n" + "Chosen power: " + normalPower
				+ "W\nCurrent power: " + power + "W\n";
	}
}