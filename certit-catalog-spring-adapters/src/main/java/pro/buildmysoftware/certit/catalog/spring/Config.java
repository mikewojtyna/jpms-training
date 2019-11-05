package pro.buildmysoftware.certit.catalog.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.buildmysoftware.certit.catalog.application.ProductCatalogService;
import pro.buildmysoftware.certit.catalog.domain.Product;
import pro.buildmysoftware.certit.catalog.domain.ProductCatalog;
import pro.buildmysoftware.certit.spring.common.SpringEventPublisher;
import pro.buildmysoftware.domain.common.EventPublisher;

import java.time.Clock;
import java.util.Collection;

@Configuration
public class Config {

	@Bean
	public ProductCatalogService productCatalogService(ProductCatalog catalog, EventPublisher eventPublisher, Clock clock) {
		return new ProductCatalogService(catalog, eventPublisher,
			clock);
	}

	@Bean
	public ProductCatalog catalog() {
		return new ProductCatalog() {
			@Override
			public Collection<Product> allProducts() {
				return null;
			}

			@Override
			public void addNewProduct(Product product) {

			}
		};
	}

	@Bean
	public EventPublisher eventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		return new SpringEventPublisher(applicationEventPublisher);
	}

	@Bean
	public Clock clock() {
		return Clock.systemUTC();
	}
}
