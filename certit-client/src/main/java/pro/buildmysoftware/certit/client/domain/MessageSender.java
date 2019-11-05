package pro.buildmysoftware.certit.client.domain;


import java.util.ServiceLoader;

public interface MessageSender {

	void send(Client client, Message msg);

	interface MessageSenderProvider {

		static MessageSender getInstance() {
			return ServiceLoader.load(MessageSenderProvider.class)
				.findFirst().orElseThrow().provide();
		}

		MessageSender provide();
	}
}
