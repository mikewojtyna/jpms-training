package pro.buildmysoftware.certit.domain.client;

import pro.buildmysoftware.certit.domain.common.DomainEvent;

import java.time.Instant;

public class ClientUpdated extends DomainEvent {

	public ClientUpdated(Instant timestamp) {
		super(timestamp);
	}
}
