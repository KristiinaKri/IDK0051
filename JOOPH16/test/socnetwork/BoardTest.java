package socnetwork;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	private Board board;
	private Person john;

	@Before
	public void setup() {
		board = new Board();
		john = new Person("John");
	}

	@Test
	public void hasNoMessages() {
		assertEquals(0, board.getNumOfMessages());
	}

	@Test
	public void hasOneMessage() {
		board.addMessage(new Message("Tere", john));
		assertEquals(1, board.getNumOfMessages());
	}

	@Test
	public void lastMessageIsReturned() {
		Message m1 = new Message("Tere", john);
		Message m2 = new Message("Teine", john);
		board.addMessage(m1);
		board.addMessage(m2);
		assertEquals(m2, board.getLastMessage());
	}
}