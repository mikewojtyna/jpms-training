package pro.buildmysoftware.certit.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.buildmysoftware.certit.client.application.ClientManager;
import pro.buildmysoftware.certit.client.domain.*;
import pro.buildmysoftware.domain.common.EventPublisher;

import java.time.Clock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ClientManagerTest {

	// @formatter:off
	@DisplayName(
		"send message"
	)
	// @formatter:on
	@Test
	void sendMsg() throws Exception {
		// given
		MessageSender messageSender = mock(MessageSender.class);
		ClientManager clientManager =
			clientManagerWithMessageSender(messageSender);
		SendMessageCommand command = commandWithMsg("hello");

		// when
		clientManager.sendMsg(command);

		// then
		verify(messageSender).send(any(), eq(message("hello")));
	}

	private Message message(String content) {
		return new Message(content);
	}

	private SendMessageCommand commandWithMsg(String msg) {
		return new SendMessageCommand(new Message(msg), new Client());
	}

	private ClientManager clientManagerWithMessageSender(MessageSender messageSender) {
		return new ClientManager(messageSender, mock(ClientDb.class),
			mock(EventPublisher.class), mock(Clock.class));
	}
}
