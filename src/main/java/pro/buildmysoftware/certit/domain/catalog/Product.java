package pro.buildmysoftware.certit.domain.catalog;

import lombok.Value;

@Value
public class Product {

	private final ProductType type;
	private final String name;
}
