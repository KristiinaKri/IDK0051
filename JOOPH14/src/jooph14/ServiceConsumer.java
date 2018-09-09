package jooph14;

import java.util.Optional;

public class ServiceConsumer implements Runnable {
	private String name;

	public ServiceConsumer(String name) {
		this.name = name;
	}

	public void handleObjects(Optional<ServiceTicket> t) {
		if (t.isPresent()) {
			ServiceTicket st = t.get();
			System.out.println(name + " " + st.getName() + " " + st.getID());
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				Optional<ServiceTicket> t = DataCentral.getTicketIfExists();
				handleObjects(t);
				Thread.sleep(20);
			}
		} catch (InterruptedException e) {
			System.out.println("I'm also interrupted!");
		}
	}
}