package loaders;

public class FastLoader extends Loader {
	// siin ei oleks vaja eraldi klassiv2lja, vaid v22rtustada
	// ylemklassi v2li normalpower fastpower asemel
	private int fastPower = 50000;
	private int lowPower = 5000;

	// Meetod, mis m‰‰rab kiirlaadija vıimsuseks 5kW
	public void startLowLoad() {
		power = lowPower;
	}

	// Meetod, mis m‰‰rab kiirlaadija vıimsuseks 50kW
	// siin v6ib vabalt kasutada ylemklassi meetodit ja dubleerida pole vaja
	// kui eraldi klassiv2ljad 2ra j2tta
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