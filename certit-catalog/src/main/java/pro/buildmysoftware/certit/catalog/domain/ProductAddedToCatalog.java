package pro.buildmysoftware.certit.catalog.domain;

import pro.buildmysoftware.domain.common.DomainEvent;

import java.time.Instant;

public class ProductAddedToCatalog extends DomainEvent {

	public ProductAddedToCatalog(Instant timestamp) {
		super(timestamp);
	}
}
