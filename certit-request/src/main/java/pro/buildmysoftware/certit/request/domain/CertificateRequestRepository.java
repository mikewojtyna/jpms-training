package pro.buildmysoftware.certit.request.domain;

import pro.buildmysoftware.domain.common.AggregateRepository;

import java.util.ServiceLoader;

public interface CertificateRequestRepository extends AggregateRepository<CertificateRequest, CertificateRequestId> {

	interface CertificateRequestRepositoryProvider {

		static CertificateRequestRepository getInstance() {
			return ServiceLoader
				.load(CertificateRequestRepositoryProvider.class)
				.findFirst().orElseThrow().provide();
		}

		CertificateRequestRepository provide();
	}
}
