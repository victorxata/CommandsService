package ie.vhi.common.services.commands.models;

public class Command {

	private String Payload;
	private String Command;

	public String getCommand() {
		return Command;
	}

	public void setCommand(String command) {
		Command = command;
	}

	public Payload getPayload() {
		return new Payload(Payload);
	}

	public void setPayload(String payload) {
		Payload = payload;
	}
}
