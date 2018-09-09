package socnetwork;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import socnetwork.Person;

public class PersonTest {
	private Person mary;
	private Person john;

	@Before
	public void setupPersons() {
		this.mary = new Person("Mary");
		this.john = new Person("John");
	}

	@Test
	public void newPersonHasNoFriends() {
		// Person john = new Person();
		// Person mary = new Person();
		assertEquals(0, john.getNumOfFriends());
		// fail("Not yet implemented");
	}

	@Test
	public void personHasFriend() {
		john.addFriend(mary);
		assertEquals(1, john.getNumOfFriends());
	}

	@Test
	public void notFriendsWith() {
		assertFalse(john.hasFriend(mary));
	}

	@Test
	public void isFriendsWith() {
		john.addFriend(mary);
		assertTrue(john.hasFriend(mary));
	}

	@Test
	public void areMutualFriends() {
		john.addFriend(mary);
		assertTrue(mary.hasFriend(john));
	}
}