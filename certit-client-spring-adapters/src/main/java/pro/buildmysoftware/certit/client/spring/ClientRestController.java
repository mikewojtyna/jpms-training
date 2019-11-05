package pro.buildmysoftware.certit.client.spring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.buildmysoftware.certit.client.application.ClientManager;
import pro.buildmysoftware.certit.client.domain.Client;
import pro.buildmysoftware.certit.client.domain.Message;
import pro.buildmysoftware.certit.client.domain.SendMessageCommand;

@RestController
@RequestMapping("/api/clients")
public class ClientRestController {

	private final ClientManager clientManager;

	public ClientRestController(ClientManager clientManager) {
		this.clientManager = clientManager;
	}

	@PostMapping("/{clientId}/messages")
	public void sendMsg(@RequestBody SendMessageCommandDto command) {
		clientManager.sendMsg(new SendMessageCommand(new Message(command
			.getMsg()), new Client()));
	}

}
