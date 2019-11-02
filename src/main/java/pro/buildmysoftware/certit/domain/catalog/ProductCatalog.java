package pro.buildmysoftware.certit.domain.catalog;

import java.util.Collection;

public interface ProductCatalog {
	Collection<Product> allProducts();

	void addNewProduct(Product product);
}
