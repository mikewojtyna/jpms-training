package pro.buildmysoftware.certit.request.spring.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.buildmysoftware.certit.request.application.CertificateService;
import pro.buildmysoftware.certit.request.domain.CertificateOffice;
import pro.buildmysoftware.certit.request.domain.CertificateRequestRepository;
import pro.buildmysoftware.certit.request.spring.event.SpringEventPublisher;
import pro.buildmysoftware.certit.request.spring.persistence.CertificateRequestSpringDateRepository;
import pro.buildmysoftware.certit.request.spring.persistence.SpringCertificateRequestRepository;
import pro.buildmysoftware.domain.common.EventPublisher;

import java.time.Clock;

@Configuration
public class SpringConfig {

	@Bean
	public CertificateService certificateService(CertificateRequestRepository repository, CertificateOffice office, EventPublisher eventPublisher) {
		return new CertificateService(repository, office,
			eventPublisher);
	}

	@Bean
	public CertificateRequestRepository repository(CertificateRequestSpringDateRepository springDataRepo) {
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
