package socnetwork;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Message> messages = new ArrayList<>();

	public int getNumOfMessages() {
		return messages.size();
	}

	public void addMessage(Message message) {
		messages.add(message);
	}

	public Message getLastMessage() {
		return messages.get(messages.size() - 1);
	}
}