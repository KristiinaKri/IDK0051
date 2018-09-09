package jooph14;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataCentral {
	public static List<ServiceTicket> tickets = new ArrayList<>();

	public static void addTicket(ServiceTicket t) {
		synchronized (tickets) {
			tickets.add(t);
		}
	}

	public static Optional<ServiceTicket> getTicketIfExists() {
		synchronized (tickets) {
			if (tickets.size() > 0) {
				return Optional.of(tickets.remove(0));
			}
		}
		return Optional.empty();
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new ServiceTicketGenerator(11));
		Thread t2 = new Thread(new ServiceTicketGenerator(12));
		Thread tc1 = new Thread(new ServiceConsumer("1."));
		Thread tc2 = new Thread(new ServiceConsumer("2."));
		Thread tc3 = new Thread(new ServiceConsumer("3."));
		Thread tc4 = new Thread(new ServiceConsumer("4."));
		t1.start();
		t2.start();
		tc1.start();
		tc2.start();
		tc3.start();
		tc4.start();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
		t2.interrupt();
		tc1.interrupt();
		tc2.interrupt();
		tc3.interrupt();
		tc4.interrupt();
	}
}