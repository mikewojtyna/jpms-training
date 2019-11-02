package pro.buildmysoftware.certit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import pro.buildmysoftware.certit.application.request.CertificateService;
import pro.buildmysoftware.certit.domain.common.DomainEvent;
import pro.buildmysoftware.certit.domain.common.EventPublisher;
import pro.buildmysoftware.certit.domain.request.CertificateRequest;
import pro.buildmysoftware.certit.domain.request.CertificateRequested;
import pro.buildmysoftware.certit.domain.request.RequestCertificateCommand;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class RequestCertificateScenarioIntegrationTest {

	private static final Instant CURRENT_TIMESTAMP = Instant.EPOCH;
	@Autowired
	private CertificateService certificateService;
	@MockBean
	private EventPublisher eventPublisher;

	// @formatter:off
	@DisplayName(
		"request a new certificate"
	)
	// @formatter:on
	@Test
	void requestNewCertificate() throws Exception {
		// given
		RequestCertificateCommand command =
			new RequestCertificateCommand();
		DomainEvent expectedEvent =
			new CertificateRequested(CURRENT_TIMESTAMP);

		// when
		CertificateRequest certificateRequest = certificateService
			.requestCertificate(command);

		// then
		assertThat(certificateRequest).isNotNull();
		ArgumentCaptor<Iterable<DomainEvent>> argumentCaptor =
			ArgumentCaptor
			.forClass(Iterable.class);
		verify(eventPublisher).publish(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue())
			.containsExactlyInAnyOrder(expectedEvent);
	}

	@TestConfiguration
	public static class TestClockProvider {

		@Bean
		@Primary
		public Clock fixedClock() {
			return Clock.fixed(CURRENT_TIMESTAMP, ZoneOffset.UTC);
		}
	}
}
