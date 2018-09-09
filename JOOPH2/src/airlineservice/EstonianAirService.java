package airlineservice;

import java.util.ArrayList;
import java.util.List;
import lufthavn.GateTicket;
import lufthavn.Ticket;

public class EstonianAirService implements AirlineTicketService {
	List<GateTicket> ticketList = new ArrayList<>();

	public EstonianAirService() {
		GateTicket t1 = new Ticket("Mina", "Ise", 347852);
		ticketList.add(t1);
		ticketList.add(new Ticket("Mina2", "Ise2", 328756));
		ticketList.add(new Ticket("Mina3", "Ise3", 847474));
		ticketList.add(new Ticket("Mina4", "Ise4", 148972));
		ticketList.add(new Ticket("Mina5", "Ise5", 914851));
	}

	@Override
	public boolean hasNextTicket() {
		return (ticketList.size() > 0);
	}

	@Override
	public GateTicket getNextTicket() {
		return ticketList.remove(0);
	}
}