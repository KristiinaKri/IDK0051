package jooph14;

public class ServiceTicket {
	private String name;
	private long ID;

	public ServiceTicket(String name, long ID) {
		this.name = name;
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public long getID() {
		return ID;
	}
}