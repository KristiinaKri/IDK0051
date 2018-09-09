package banksystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankClientGateway {
	private static List<Client> clients = new ArrayList<>();

	public static Optional<Client> getClient(int ID) {
		for (int i = 0; i < clients.size(); i++) {
			if (ID == clients.get(i).getIDCode()) {
				return Optional.of(clients.get(i));
			}
		}
		Client client = new Client(ID);
		clients.add(client);
		return Optional.of(client);
	}
}