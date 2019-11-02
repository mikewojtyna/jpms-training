package pro.buildmysoftware.certit.application.catalog;

import pro.buildmysoftware.certit.domain.catalog.AddProductCommand;
import pro.buildmysoftware.certit.domain.catalog.Product;
import pro.buildmysoftware.certit.domain.catalog.ProductCatalog;

import java.util.Collection;

public class ProductCatalogService {

	private final ProductCatalog catalogue;

	public ProductCatalogService(ProductCatalog catalogue) {
		this.catalogue = catalogue;
	}

	public Collection<Product> allProducts() {
		return catalogue.allProducts();
	}

	public void addProduct(AddProductCommand command) {
		catalogue.addNewProduct(new Product(command.getType(), command
			.getName()));
	}
}
