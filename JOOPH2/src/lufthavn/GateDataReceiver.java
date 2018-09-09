package lufthavn;

public interface GateDataReceiver {
	public void addTicket(GateTicket t) throws IllegalArgumentException;
}