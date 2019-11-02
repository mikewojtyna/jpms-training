package pro.buildmysoftware.certit.domain.client;

public interface ClientDb {

	void addClient(ClientDetails details);

	void updateClient(ClientDetails clientDetails);
}
