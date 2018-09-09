package socnetwork;

public class PersonReader extends Person implements Runnable {
	public PersonReader(String name) {
		super(name);
	}

	@Override
	public void run() {
		synchronized (SocialNetwork.board) {
			try {
				while (SocialNetwork.board.getNumOfMessages() < 1) {
					System.out.println("Ootan...");
					SocialNetwork.board.wait();
				}
				Message m = SocialNetwork.board.getLastMessage();
				System.out.println("Sain teate: " + m.getMessage());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}