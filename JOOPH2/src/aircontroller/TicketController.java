package aircontroller;

import lufthavn.Gate;
import lufthavn.GateDataReceiver;
import airlineservice.AirlineTicketService;
import airlineservice.EstonianAirService;

public class TicketController {
	AirlineTicketService ticketService = new EstonianAirService();
	GateDataReceiver gate = new Gate();

	public void TicketController() {
		while (ticketService.hasNextTicket()) {
			gate.addTicket(ticketService.getNextTicket());
		}
	}
}