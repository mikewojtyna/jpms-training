package pro.buildmysoftware.certit.application.catalog;

import pro.buildmysoftware.certit.domain.catalog.AddProductCommand;
import pro.buildmysoftware.certit.domain.catalog.Product;
import pro.buildmysoftware.certit.domain.catalog.ProductAddedToCatalog;
import pro.buildmysoftware.certit.domain.catalog.ProductCatalog;
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
