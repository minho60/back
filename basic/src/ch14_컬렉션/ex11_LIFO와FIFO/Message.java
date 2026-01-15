package ch14_컬렉션.ex11_LIFO와FIFO;

public class Message {
	public String command;
	public String to;

	public Message(String command, String to) {
		this.command = command;
		this.to = to;
	}
}