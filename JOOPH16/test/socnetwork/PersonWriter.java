package socnetwork;

public class PersonWriter extends Person implements Runnable {
	public PersonWriter(String name) {
		super(name);
	}

	@Override
	public void run() {
		synchronized (SocialNetwork.board) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SocialNetwork.board.addMessage(new Message("Tere", this));
			SocialNetwork.board.notifyAll();
		}
	}
}