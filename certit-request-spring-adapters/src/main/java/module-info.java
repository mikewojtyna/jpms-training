open module pro.buildmysoftware.certit.request.spring {
	requires pro.buildmysoftware.certit.spring.common;
	requires pro.buildmysoftware.certit.request;
	requires pro.buildmysoftware.domain.common;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.web;
	requires spring.data.commons;
	requires java.persistence;
	requires lombok;
	requires spring.boot;
	requires spring.beans;
	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires java.sql;
	requires com.fasterxml.jackson.databind;
}