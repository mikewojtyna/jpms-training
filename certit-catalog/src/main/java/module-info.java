module pro.buildmysoftware.certit.catalog {
	exports pro.buildmysoftware.certit.catalog.domain;
	exports pro.buildmysoftware.certit.catalog.application;
	uses pro.buildmysoftware.certit.catalog.domain.ProductCatalog.ProductCatalogProvider;
	requires pro.buildmysoftware.domain.common;
	requires lombok;
}