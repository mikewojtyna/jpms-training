package pro.buildmysoftware.certit.domain.catalog;

import pro.buildmysoftware.certit.domain.common.DomainEvent;

import java.time.Instant;

public class ProductAddedToCatalog extends DomainEvent {

	public ProductAddedToCatalog(Instant timestamp) {
		super(timestamp);
	}
}
