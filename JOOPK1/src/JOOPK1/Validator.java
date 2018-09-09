package JOOPK1;

import java.util.ArrayList;

public class Validator extends ValidatorController {
	public static ArrayList<Passenger> validated = new ArrayList<Passenger>();
	public static int validatedCount = 0;

	public static void validate(Passenger a) {
		validatedCount++;
		if ((a.age < 8 && a.age >= 0) || a.location == "Tallinn"
				|| a.location == "Hiiumaa") {
			if (!validated.contains(a)) {
				validated.add(a);
			}
			System.out.println("Passenger has been validated.");
		} else {
			System.out.println("Passenger could not be validated.");
		}
	}

	public static boolean isValidated(Passenger a) {
		if (validated.contains(a)) {
			System.out.println("This passenger may ride.\n\n");
			return true;
		} else {
			System.out.println("This passenger may not ride.\n\n");
			return false;
		}
	}

	public static void getValidatedCount() {
		System.out.println(validatedCount + " passengers are validated.");
	}
}