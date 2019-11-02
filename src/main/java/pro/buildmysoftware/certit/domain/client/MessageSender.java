package pro.buildmysoftware.certit.domain.client;


public interface MessageSender {

	void send(Client client, Message msg);
}
