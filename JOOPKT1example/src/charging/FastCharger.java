package charging;

public class FastCharger extends Charger {

	private static final int SLOW_CHARGING = 5;
	private static final int CHARGING_POWER = 50;

	FastCharger() {
		setPower(CHARGING_POWER);
		System.out.println("Fast charger initialized");
	}

	public void startSlowCharging() {
		setPower(SLOW_CHARGING);
		startCharging();
	}
}