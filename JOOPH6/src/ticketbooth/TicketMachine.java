package ticketbooth;

import java.util.ArrayList;

public class TicketMachine {
	public static ArrayList<Ticket> used = new ArrayList<Ticket>();

	private static int ticketNr = 1;

	public Ticket buyTicket(String string) {
		return new Ticket(string, ticketNr++);
	}

	public String isValid(Ticket t) {
		if (used.contains(t)) {
			return "Not valid!";
		}
		return "Valid!";
	}

	public void useTicket(Ticket t) {
		if (used.contains(t)) {
			System.out.println("ALARM! Pilet ei ole kehtiv!");
		} else {
			used.add(t);
			System.out.println("Häid filmielamusi!");
		}
	}
}