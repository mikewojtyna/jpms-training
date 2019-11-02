package pro.buildmysoftware.certit.domain.client;

import pro.buildmysoftware.certit.domain.common.DomainEvent;

import java.time.Instant;

public class ClientRegistered extends DomainEvent {

	public ClientRegistered(Instant timestamp) {
		super(timestamp);
	}
}
