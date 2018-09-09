package socnetwork;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private List<Person> friends = new ArrayList<>();
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public int getNumOfFriends() {
		return friends.size();
	}

	public void addFriend(Person mary) {
		addToFriendList(mary);
		mary.addToFriendList(this);
	}

	public boolean hasFriend(Person mary) {
		return friends.contains(mary);
	}

	private void addToFriendList(Person person) {
		friends.add(person);
	}
}