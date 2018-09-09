package lufthavn;

public class Gate implements GateDataReceiver {
	@Override
	public void addTicket(GateTicket t) throws IllegalArgumentException {
		System.out.println("Registreeritud pilet nr " + t.getTicketCode()
				+ ": " + t.getPassengerFirstName()
				+ " " + t.getPassengerLastName());
	}
}