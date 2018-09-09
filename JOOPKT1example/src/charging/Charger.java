package charging;

import java.util.Optional;

public class Charger {

	private static final int CHARGING_POWER = 2;
	private int power;
	protected static boolean emergencyMode = false;
	protected static int emergencyPower;

	Charger() {
		setPower(CHARGING_POWER);
		System.out.println("Normal charger initialized");
	}

	public static Optional<Charger> getOptCharger(String chargertype) {
		if (chargertype.equals("fast")) {
			return Optional.of(new FastCharger());
		} else if (chargertype.equals("normal")) {
			return Optional.of(new Charger());
		}
		// JVM provides default constructor
		return null;
	}

	public void startCharging() {
		System.out.println("Alustasin laadimist voimsusel " + getCurrentPower());
	}

	public void stopCharging() {
		System.out.println("Lopetasin laadimise voimsusel " + getCurrentPower());
	}

	public static void startEmergencyMode(int emergencyPower) {
		emergencyMode = true;
		Charger.emergencyPower = emergencyPower;
		System.out.println("Alustasin avariireziimi");
	}

	public static void stopEmergencyMode() {
		emergencyMode = false;
		System.out.println("Lopetasin avariireziimi");
	}

	public int getCurrentPower() {
		if (emergencyMode) {
			return emergencyPower;
		}
		return getPower();
	}

	// returns nominal power
	public int getPower() {
		return power;
	}

	// sets nominal power
	void setPower(int power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "Laadija nominaalvoimsus: " + getPower() + "kW, hetkevoimsus: "
				+ getCurrentPower() + "kW";
	}
}