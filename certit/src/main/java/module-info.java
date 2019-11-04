open module pro.buildmysoftware.certit.app {
	requires pro.buildmysoftware.domain.common;
	requires pro.buildmysoftware.certit.request;
	requires lombok;
	requires spring.web;
	requires spring.boot.autoconfigure;
	requires spring.boot;
	requires spring.context;
	requires java.persistence;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.webmvc;
	requires java.sql;
	requires net.bytebuddy;
	requires com.fasterxml.classmate;
}