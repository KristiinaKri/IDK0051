package socnetwork;

public class Message {
	private String message;
	private Person author;

	public Message(String message, Person author) {
		this.message = message;
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public Person getAuthor() {
		return author;
	}
}