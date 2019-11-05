package pro.buildmysoftware.certit.catalog.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.buildmysoftware.certit.catalog.domain.AddProductCommand;
import pro.buildmysoftware.certit.catalog.domain.ProductAddedToCatalog;
import pro.buildmysoftware.certit.catalog.domain.ProductCatalog;
import pro.buildmysoftware.domain.common.EventPublisher;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddProductTest {

	// @formatter:off
	@DisplayName(
		"add new product"
	)
	// @formatter:on
	@Test
	void addProduct() throws Exception {
		// given
		EventPublisher eventPublisher = mock(EventPublisher.class);
		ProductCatalogService catalogService =
			catalogServiceWithEventPublisher(eventPublisher);
		AddProductCommand command = addCommand();
		ProductAddedToCatalog expectedEvent =
			productAdded(currentTimestamp());

		// when
		catalogService.addProduct(command);

		// then
		verify(eventPublisher).publish(expectedEvent);
	}

	private AddProductCommand addCommand() {
		return new AddProductCommand();
	}

	private ProductAddedToCatalog productAdded(Instant timestamp) {
		return new ProductAddedToCatalog(timestamp);
	}

	private ProductCatalogService catalogServiceWithEventPublisher(EventPublisher eventPublisher) {
		return new ProductCatalogService(mock(ProductCatalog.class),
			eventPublisher, Clock
			.fixed(currentTimestamp(), ZoneOffset.UTC));
	}

	private Instant currentTimestamp() {
		return Instant.EPOCH;
	}
}
