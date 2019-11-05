package pro.buildmysoftware.certit.client.domain;

import java.util.ServiceLoader;

public interface ClientDb {

	void addClient(ClientDetails details);

	void updateClient(ClientDetails clientDetails);

	interface ClientDbProvider {

		static ClientDb getInstance() {
			return ServiceLoader.load(ClientDbProvider.class)
				.findFirst().orElseThrow().provide();
		}

		ClientDb provide();
	}
}
