module pro.buildmysoftware.certit.request {
	requires pro.buildmysoftware.domain.common;
	exports pro.buildmysoftware.certit.request.application;
	exports pro.buildmysoftware.certit.request.domain;
	uses pro.buildmysoftware.certit.request.domain.CertificateRequestRepository.CertificateRequestRepositoryProvider;
	requires lombok;
}