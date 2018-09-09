package airlineservice;

import lufthavn.GateTicket;

public interface AirlineTicketService {
	public boolean hasNextTicket();

	public GateTicket getNextTicket();
}