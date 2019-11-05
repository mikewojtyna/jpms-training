open module pro.buildmysoftware.certit.catalog.spring {
	requires pro.buildmysoftware.domain.common;
	requires pro.buildmysoftware.certit.catalog;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.web;
	requires lombok;
	requires spring.boot;
	requires spring.beans;
	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires com.fasterxml.jackson.databind;
}