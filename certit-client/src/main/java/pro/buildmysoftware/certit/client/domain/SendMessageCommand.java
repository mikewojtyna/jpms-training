package pro.buildmysoftware.certit.client.domain;

import lombok.Value;

@Value
public class SendMessageCommand {

	private final Message msg;
	private final Client client;
}
