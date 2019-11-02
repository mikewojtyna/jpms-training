package pro.buildmysoftware.certit.infrastructure.spring.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.buildmysoftware.certit.application.catalog.ProductCatalogService;
import pro.buildmysoftware.certit.application.client.ClientManager;
import pro.buildmysoftware.certit.application.request.CertificateService;
import pro.buildmysoftware.certit.domain.catalog.Product;
import pro.buildmysoftware.certit.domain.catalog.ProductCatalog;
import pro.buildmysoftware.certit.domain.client.ClientDb;
import pro.buildmysoftware.certit.domain.client.ClientDetails;
import pro.buildmysoftware.certit.domain.client.MessageSender;
import pro.buildmysoftware.certit.domain.common.AggregateRepository;
import pro.buildmysoftware.certit.domain.common.EventPublisher;
import pro.buildmysoftware.certit.domain.request.CertificateOffice;
import pro.buildmysoftware.certit.domain.request.CertificateRequest;
import pro.buildmysoftware.certit.domain.request.CertificateRequestId;
import pro.buildmysoftware.certit.infrastructure.spring.event.SpringEventPublisher;
import pro.buildmysoftware.certit.infrastructure.spring.persistence.CertificateRequestSpringDateRepository;
import pro.buildmysoftware.certit.infrastructure.spring.persistence.SpringCertificateRequestRepository;

import java.time.Clock;
import java.util.Collection;
import java.util.List;

@Configuration
public class SpringServiceConfiguration {

	@Bean
	public ClientDb clientDb() {
		return new ClientDb() {
			@Override
			public void addClient(ClientDetails details) {
				// do nothing
			}

			@Override
			public void updateClient(ClientDetails clientDetails) {
				// do nothing
			}
		};
	}

	@Bean
	public MessageSender messageSender() {
		return (client, msg) -> {
			// do nothing
		};
	}

	@Bean
	public ClientManager clientManager(MessageSender messageSender,
					   ClientDb clientDb) {
		return new ClientManager(messageSender, clientDb);
	}

	@Bean
	public ProductCatalogService productCatalogService() {
		return new ProductCatalogService(new ProductCatalog() {
			@Override
			public Collection<Product> allProducts() {
				return List.of();
			}

			@Override
			public void addNewProduct(Product product) {
				// do nothing
			}
		});
	}

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
