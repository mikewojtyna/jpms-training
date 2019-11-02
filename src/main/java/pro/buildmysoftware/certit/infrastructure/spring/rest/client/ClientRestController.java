package pro.buildmysoftware.certit.infrastructure.spring.rest.client;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.buildmysoftware.certit.application.client.ClientManager;
import pro.buildmysoftware.certit.domain.client.SendMessageCommand;

@RestController
@RequestMapping("/api/clients")
public class ClientRestController {

	private final ClientManager clientManager;

	public ClientRestController(ClientManager clientManager) {
		this.clientManager = clientManager;
	}

	@PostMapping("/{clientId}/messages")
	public void sendMsg(@RequestBody SendMessageCommand command) {
		clientManager.sendMsg(command);
	}

}
