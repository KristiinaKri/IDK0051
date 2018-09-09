package socnetwork;

public class SocialNetwork {
	public static Board board = new Board();

	public static void main(String[] args) {
		Thread t1 = new Thread(new PersonWriter("John"));
		Thread t2 = new Thread(new PersonReader("Mary"));
		t1.start();
		t2.start();
	}
}