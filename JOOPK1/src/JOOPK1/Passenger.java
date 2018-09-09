package JOOPK1;

public class Passenger extends ValidatorController {
	public String location = "NA";
	public int ID = 0, age = 0;
	public static int passengerCount = 0;

	public Passenger(int passengerID, int ageNr, String homeAddress) {
		ID = passengerID;
		age = ageNr;
		location = homeAddress;
		passengerCount++;
	}

	public void getCode() {
		System.out.println("Passenger ID: " + ID);
	}

	public void getAge() {
		System.out.println("Passenger age: " + age);
	}

	public void getLocation() {
		System.out.println("This passenger lives in " + location + ".");
	}

	public void getPassengerCount() {
		System.out.println("There are " + passengerCount + " passengers.");
	}
}