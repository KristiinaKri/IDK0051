package ticketbooth;

public class Ticket {
	private String film;
	public int ticketNr;

	public Ticket(String film, int ticketNr) {
		this.film = film;
		this.ticketNr = ticketNr;
	}

	@Override
	public String toString() {
		return "Filmiseanss: " + film + ", pileti number: " + ticketNr;
	}
}