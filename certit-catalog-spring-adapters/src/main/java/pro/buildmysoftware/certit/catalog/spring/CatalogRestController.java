package pro.buildmysoftware.certit.catalog.spring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.buildmysoftware.certit.catalog.application.ProductCatalogService;
import pro.buildmysoftware.certit.catalog.domain.AddProductCommand;
import pro.buildmysoftware.certit.catalog.domain.Product;

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
	@ResponseStatus(HttpStatus.CREATED)
	public void addProduct(@RequestBody AddProductCommand command) {
		catalogService.addProduct(command);
	}
}
