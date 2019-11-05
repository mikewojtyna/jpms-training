package pro.buildmysoftware.certit.catalog.application;

import pro.buildmysoftware.certit.catalog.domain.AddProductCommand;
import pro.buildmysoftware.certit.catalog.domain.Product;
import pro.buildmysoftware.certit.catalog.domain.ProductAddedToCatalog;
import pro.buildmysoftware.certit.catalog.domain.ProductCatalog;
import pro.buildmysoftware.domain.common.EventPublisher;

import java.time.Clock;
import java.time.Instant;
import java.util.Collection;

public class ProductCatalogService {

	private final ProductCatalog catalogue;
	private final EventPublisher eventPublisher;
	private final Clock clock;

	public ProductCatalogService(ProductCatalog catalogue,
				     EventPublisher eventPublisher,
				     Clock clock) {
		this.catalogue = catalogue;
		this.eventPublisher = eventPublisher;
		this.clock = clock;
	}

	public Collection<Product> allProducts() {
		return catalogue.allProducts();
	}

	public void addProduct(AddProductCommand command) {
		catalogue.addNewProduct(new Product(command.getType(), command
			.getName()));
		eventPublisher
			.publish(new ProductAddedToCatalog(Instant.now(clock)));
	}
}
