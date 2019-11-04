package pro.buildmysoftware.certit.request.domain;

import java.time.Clock;
import java.util.List;
import java.util.UUID;

public class CertificateOffice {

	private final Clock clock;

	public CertificateOffice(Clock clock) {
		this.clock = clock;
	}

	public CertificateRequest requestCertificate(RequestCertificateCommand command) {
		return new CertificateRequest(new CertificateRequestId(UUID
			.randomUUID()), new CertificateTypeId(),
			new CertificateRequester("ANONYMOUS"), List
			.of(new CertificateRequested(clock.instant())));
	}
}
