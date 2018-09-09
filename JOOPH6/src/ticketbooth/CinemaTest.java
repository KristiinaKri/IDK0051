package ticketbooth;

public class CinemaTest {

	public static void main(String[] args) {
		TicketMachine m = new TicketMachine();
		TicketMachine m2 = new TicketMachine();
		Ticket t1 = m.buyTicket("SherlockHolmes");
		Ticket t2 = m.buyTicket("Mission Impossible");
		Ticket t3 = m.buyTicket("SherlockHolmes");
		Ticket t4 = m.buyTicket("MissionImpossible");
		System.out.println("t1.toString() - " + t1);
		System.out.println("t2.toString() - " + t2);
		System.out.println("t3.toString() - " + t3);
		System.out.println("t4.toString() - " + t4);
		System.out.println("isValid(t1) - " + m.isValid(t1));
		System.out.println("isValid(t2) - " + m.isValid(t2));
		m.useTicket(t1);
		System.out.println("Pärast sisenemist: t1.isValid() - " + m.isValid(t1));
		m2.useTicket(t1);
		Ticket fake = new Ticket("Sherlock", 0);
		fake.ticketNr = 4;
		System.out.println("fake.toString() - " + fake);
		System.out.println("fake.isValid() - " + m.isValid(fake));
		m.useTicket(fake);
	}
}