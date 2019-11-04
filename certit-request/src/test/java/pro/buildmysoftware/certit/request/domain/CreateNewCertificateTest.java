package pro.buildmysoftware.certit.request.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateNewCertificateTest {

	// @formatter:off
	@DisplayName(
		"create new certificate request"
	)
	// @formatter:on
	@Test
	void certRequest() throws Exception {
		// given
		CertificateOffice office = anyOffice();
		RequestCertificateCommand command = anyCommand();
		CertificateRequested createdEvent =
			certificateRequestedEvent();

		// when
		CertificateRequest certificateRequest = office
			.requestCertificate(command);

		// then
		assertThat(certificateRequest.domainEvents())
			.containsExactly(createdEvent);
	}

	private CertificateOffice anyOffice() {
		return new CertificateOffice(Clock
			.fixed(currentInstant(), ZoneOffset.UTC));
	}

	private CertificateRequested certificateRequestedEvent() {
		return new CertificateRequested(currentInstant());
	}

	private Instant currentInstant() {
		return Instant.EPOCH;
	}

	private RequestCertificateCommand anyCommand() {
		return new RequestCertificateCommand();
	}
}
