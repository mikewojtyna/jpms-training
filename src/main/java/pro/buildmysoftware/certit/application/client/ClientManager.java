package pro.buildmysoftware.certit.application.client;

import pro.buildmysoftware.certit.domain.client.*;
import pro.buildmysoftware.certit.domain.common.EventPublisher;

import java.time.Clock;
import java.time.Instant;

public class ClientManager {

	private final MessageSender messageSender;
	private final ClientDb clientDb;
	private final EventPublisher eventPublisher;
	private final Clock clock;

	public ClientManager(MessageSender messageSender, ClientDb clientDb,
			     EventPublisher eventPublisher, Clock clock) {
		this.messageSender = messageSender;
		this.clientDb = clientDb;
		this.eventPublisher = eventPublisher;
		this.clock = clock;
	}

	public void sendMsg(SendMessageCommand command) {
		messageSender.send(command.getClient(), command.getMsg());
	}

	public void registerClient(RegisterClientCommand command) {
		clientDb.addClient(command.getDetails());
		eventPublisher
			.publish(new ClientRegistered(Instant.now(clock)));
	}

	public void updateClientDetails(UpdateClientDetailsCommand command) {
		clientDb.updateClient(command.getClientDetails());
		eventPublisher.publish(new ClientUpdated(Instant.now(clock)));
	}
}
