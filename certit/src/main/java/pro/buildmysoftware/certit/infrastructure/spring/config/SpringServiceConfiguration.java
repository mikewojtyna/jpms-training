package pro.buildmysoftware.certit.infrastructure.spring.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.buildmysoftware.certit.application.catalog.ProductCatalogService;
import pro.buildmysoftware.certit.domain.catalog.Product;
import pro.buildmysoftware.certit.domain.catalog.ProductCatalog;
import pro.buildmysoftware.certit.infrastructure.spring.event.SpringEventPublisher;
import pro.buildmysoftware.certit.infrastructure.spring.persistence.CertificateRequestSpringDateRepository;
import pro.buildmysoftware.certit.infrastructure.spring.persistence.SpringCertificateRequestRepository;
import pro.buildmysoftware.certit.request.application.CertificateService;
import pro.buildmysoftware.certit.request.domain.CertificateOffice;
import pro.buildmysoftware.certit.request.domain.CertificateRequest;
import pro.buildmysoftware.certit.request.domain.CertificateRequestId;
import pro.buildmysoftware.certit.request.domain.CertificateRequestRepository;
import pro.buildmysoftware.domain.common.AggregateRepository;
import pro.buildmysoftware.domain.common.EventPublisher;

import java.time.Clock;
import java.util.Collection;
import java.util.List;

@Configuration
public class SpringServiceConfiguration {

	@Bean
	public ProductCatalogService productCatalogService(EventPublisher eventPublisher, Clock clock) {
		return new ProductCatalogService(new ProductCatalog() {
			@Override
			public Collection<Product> allProducts() {
				return List.of();
			}

			@Override
			public void addNewProduct(Product product) {
				// do nothing
			}
		}, eventPublisher, clock);
	}

	@Bean
	public CertificateService certificateService(CertificateRequestRepository repository, CertificateOffice office, EventPublisher eventPublisher) {
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
