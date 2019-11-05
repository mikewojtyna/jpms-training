package pro.buildmysoftware.certit.catalog.domain;

import lombok.Value;

@Value
public class Product {

	private final ProductType type;
	private final String name;
}
