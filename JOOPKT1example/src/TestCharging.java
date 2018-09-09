import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import charging.Charger;

//import charging.FastCharger;

public class TestCharging {
	public static void main(String[] args) {
		List<Optional<Charger>> chargers = new ArrayList<>();
		/*
		 * Charger c = Charger.getCharger("normal");
		 * Charger c2 = Charger.getCharger("fast");
		 * chargers.add(c);
		 * chargers.add(c2);
		 */
		chargers.add(Charger.getOptCharger("normal"));
		chargers.add(Charger.getOptCharger("fast"));
		for (Optional<Charger> charger : chargers) {
			charger.get().startCharging();
			Charger.startEmergencyMode(1);
			charger.get().startCharging();
			charger.get().stopCharging();
			Charger.stopEmergencyMode();
			charger.get().stopCharging();
		}
		/*
		 * for (Optional<Charger> charger : chargers) {
		 * charger.ifPresent(TestCharging::useCharger);
		 * }
		 * System.out.println(c);
		 * System.out.println(c2);
		 * c.startCharging();
		 * Charger.startEmergencyMode(1);
		 * c2.startCharging();
		 * c.stopCharging();
		 * Charger.stopEmergencyMode();
		 * c2.stopCharging();
		 * ((FastCharger)c2).startSlowCharging();
		 */
	}
}