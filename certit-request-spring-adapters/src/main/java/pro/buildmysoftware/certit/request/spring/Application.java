package pro.buildmysoftware.certit.request.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import pro.buildmysoftware.certit.request.application.CertificateService;
import pro.buildmysoftware.certit.request.domain.CertificateOffice;
import pro.buildmysoftware.certit.request.domain.CertificateRequestRepository;
import pro.buildmysoftware.certit.request.spring.persistence.CertificateRequestSpringDateRepository;
import pro.buildmysoftware.certit.request.spring.persistence.SpringCertificateRequestRepository;
import pro.buildmysoftware.domain.common.EventPublisher;

import java.time.Clock;

@SpringBootApplication
public class Application {

	@Autowired
	public static ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

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
	public EventPublisher eventPublisher() {
		return EventPublisher.EventPublisherProvider.getInstance();
	}

}
