package pro.buildmysoftware.certit.infrastructure.spring.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.buildmysoftware.certit.application.request.CertificateService;
import pro.buildmysoftware.certit.domain.common.AggregateRepository;
import pro.buildmysoftware.certit.domain.common.EventPublisher;
import pro.buildmysoftware.certit.domain.request.CertificateOffice;
import pro.buildmysoftware.certit.domain.request.CertificateRequest;
import pro.buildmysoftware.certit.domain.request.CertificateRequestId;
import pro.buildmysoftware.certit.infrastructure.spring.event.SpringEventPublisher;
import pro.buildmysoftware.certit.infrastructure.spring.persistence.CertificateRequestSpringDateRepository;
import pro.buildmysoftware.certit.infrastructure.spring.persistence.SpringCertificateRequestRepository;

import java.time.Clock;

@Configuration
public class SpringServiceConfiguration {
	@Bean
	public CertificateService certificateService(AggregateRepository<CertificateRequest, CertificateRequestId> repository, CertificateOffice office, EventPublisher eventPublisher) {
		return new CertificateService(repository, office,
			eventPublisher);
	}

	@Bean
	public AggregateRepository<CertificateRequest, CertificateRequestId> repository(CertificateRequestSpringDateRepository springDataRepo) {
		return new SpringCertificateRequestRepository(springDataRepo);
	}

	@Bean
	public CertificateOffice office(Clock clock) {
		return new CertificateOffice(clock);
	}

	@Bean
	public Clock clock() {
		return Clock.systemUTC();
	}

	@Bean
	public EventPublisher eventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		return new SpringEventPublisher(applicationEventPublisher);
	}
}
