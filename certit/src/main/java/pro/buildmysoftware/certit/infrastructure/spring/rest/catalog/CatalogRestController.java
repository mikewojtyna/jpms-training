package pro.buildmysoftware.certit.infrastructure.spring.rest.catalog;

import org.springframework.web.bind.annotation.*;
import pro.buildmysoftware.certit.application.catalog.ProductCatalogService;
import pro.buildmysoftware.certit.domain.catalog.AddProductCommand;
import pro.buildmysoftware.certit.domain.catalog.Product;

import java.util.Collection;

@RestController
@RequestMapping("/api/catalog")
public class CatalogRestController {

	private final ProductCatalogService catalogService;

	public CatalogRestController(ProductCatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping
	public Collection<Product> allProducts() {
		return catalogService.allProducts();
	}

	@PostMapping
	public void addProduct(@RequestBody AddProductCommand command) {
		catalogService.addProduct(command);
	}
}
