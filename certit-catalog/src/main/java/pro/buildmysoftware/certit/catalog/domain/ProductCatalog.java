package pro.buildmysoftware.certit.catalog.domain;

import java.util.Collection;
import java.util.ServiceLoader;

public interface ProductCatalog {

	Collection<Product> allProducts();

	void addNewProduct(Product product);

	interface ProductCatalogProvider {

		static ProductCatalog getInstance() {
			return ServiceLoader.load(ProductCatalogProvider.class)
				.findFirst().orElseThrow().provide();
		}

		ProductCatalog provide();
	}
}
