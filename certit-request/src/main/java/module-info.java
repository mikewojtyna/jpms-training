open module pro.buildmysoftware.certit.request {
	exports pro.buildmysoftware.certit.request.application;
	exports pro.buildmysoftware.certit.request.domain;
	uses pro.buildmysoftware.certit.request.domain.CertificateRequestRepository.CertificateRequestRepositoryProvider;
	requires pro.buildmysoftware.domain.common;
	requires lombok;
}