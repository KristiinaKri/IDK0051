package JOOPK1;

public class ValidatorController {
	public static void printInfo(Passenger p) {
		p.getCode();
		p.getAge();
		p.getLocation();
		System.out.println("----------x----------");
	}

	public static void main(String[] args) {
		Passenger p1 = new Passenger(335244, 21, "Tallinn");
		printInfo(p1);
		Validator.validate(p1);
		Validator.isValidated(p1);

		Passenger p2 = new Passenger(596264, 6, "Paide");
		printInfo(p2);
		Validator.validate(p2);
		Validator.isValidated(p2);

		Passenger p3 = new Passenger(487951, 33, "Hiiumaa");
		printInfo(p3);
		Validator.isValidated(p3);

		Passenger p4 = new Passenger(1053667, 2, "Tartu");
		printInfo(p4);
		Validator.validate(p4);
		Validator.isValidated(p4);

		Passenger p5 = new Passenger(1270, 7, "Hiiumaa");
		printInfo(p5);
		Validator.validate(p5);
		Validator.isValidated(p5);

		Passenger p6 = new Passenger(589921, 80, "Haapsalu");
		printInfo(p6);
		Validator.validate(p6);
		Validator.isValidated(p6);

		Passenger p7 = new Passenger(203960, 45, "Türi");
		printInfo(p7);
		Validator.validate(p7);
		Validator.isValidated(p7);

		Passenger p8 = new Passenger(829254, 4, "Rakvere");
		printInfo(p8);
		Validator.isValidated(p8);

		Passenger p9 = new Passenger(598636, -18, "Valga");
		printInfo(p9);
		Validator.validate(p9);
		Validator.isValidated(p9);

		p1.getPassengerCount();
		Validator.getValidatedCount();
	}
}