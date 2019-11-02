package pro.buildmysoftware.certit.application.client;

import pro.buildmysoftware.certit.domain.client.*;

public class ClientManager {

	private final MessageSender messageSender;
	private final ClientDb clientDb;

	public ClientManager(MessageSender messageSender, ClientDb clientDb) {
		this.messageSender = messageSender;
		this.clientDb = clientDb;
	}

	public void sendMsg(SendMessageCommand command) {
		messageSender.send(command.getClient(), command.getMsg());
	}

	public void registerClient(RegisterClientCommand command) {
		clientDb.addClient(command.getDetails());
	}

	public void updateClientDetails(UpdateClientDetailsCommand command) {
		clientDb.updateClient(command.getClientDetails());
	}
}
