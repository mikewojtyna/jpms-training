module pro.buildmysoftware.certit.client {
	exports pro.buildmysoftware.certit.client.domain;
	exports pro.buildmysoftware.certit.client.application;
	uses pro.buildmysoftware.certit.client.domain.MessageSender.MessageSenderProvider;
	uses pro.buildmysoftware.certit.client.domain.ClientDb.ClientDbProvider;
	requires pro.buildmysoftware.domain.common;
	requires lombok;
}