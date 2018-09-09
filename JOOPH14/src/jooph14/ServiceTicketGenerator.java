package jooph14;

import java.util.function.LongSupplier;

public class ServiceTicketGenerator implements Runnable {
	private long ticketNum = 0;
	private int prefix;

	public ServiceTicketGenerator(int prefix) {
		this.prefix = prefix;
	}

	private long getNextTicketNum() {
		return Long.valueOf(String.valueOf(prefix) + String.valueOf(++ticketNum));
	}

	private ServiceTicket createTicket(LongSupplier ticketCodeGenerator) {
		return new ServiceTicket("Teenindussoov", ticketCodeGenerator.getAsLong());
	}

	@Override
	public void run() {
		try {
			while (true) {
				ServiceTicket t = createTicket(this::getNextTicketNum);
				// synchronized (DataCentral.tickets) {
				// DataCentral.tickets.add(t);
				// }
				DataCentral.addTicket(t);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			System.out.println("I'm interrupted!");
		}
	}
}