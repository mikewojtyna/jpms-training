package pro.buildmysoftware.certit.request.domain;

import pro.buildmysoftware.domain.common.DomainEvent;

import java.time.Instant;

public class CertificateRequested extends DomainEvent {

	public CertificateRequested(Instant timestamp) {
		super(timestamp);
	}
}
