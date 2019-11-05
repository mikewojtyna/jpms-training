package pro.buildmysoftware.certit.client.domain;

import pro.buildmysoftware.domain.common.DomainEvent;

import java.time.Instant;

public class ClientRegistered extends DomainEvent {

	public ClientRegistered(Instant timestamp) {
		super(timestamp);
	}
}
