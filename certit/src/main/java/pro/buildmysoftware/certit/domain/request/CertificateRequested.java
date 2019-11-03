package pro.buildmysoftware.certit.domain.request;

import pro.buildmysoftware.domain.common.DomainEvent;

import java.time.Instant;

public class CertificateRequested extends DomainEvent {

	public CertificateRequested(Instant timestamp) {
		super(timestamp);
	}
}
