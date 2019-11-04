package pro.buildmysoftware.certit.infrastructure.spring.persistence;

import pro.buildmysoftware.certit.request.domain.CertificateRequest;
import pro.buildmysoftware.certit.request.domain.CertificateRequestId;
import pro.buildmysoftware.certit.request.domain.CertificateRequester;
import pro.buildmysoftware.certit.request.domain.CertificateTypeId;
import pro.buildmysoftware.domain.common.AggregateRepository;

import java.util.Optional;
import java.util.UUID;

public class SpringCertificateRequestRepository implements AggregateRepository<CertificateRequest, CertificateRequestId> {

	private final CertificateRequestSpringDateRepository repository;

	public SpringCertificateRequestRepository(CertificateRequestSpringDateRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<CertificateRequest> load(CertificateRequestId certificateRequestId) {
		return repository
			.findById(certificateRequestId.unwrap().toString())
			.map(certificateRequestData -> new CertificateRequest(new CertificateRequestId(UUID
				.fromString(certificateRequestData
					.getId())), new CertificateTypeId(),
				new CertificateRequester("ANONYMOUS")));
	}

	@Override
	public CertificateRequest save(CertificateRequest aggregate) {
		CertificateRequestData certificateRequestData =
			new CertificateRequestData();
		certificateRequestData
			.setId(aggregate.getId().unwrap().toString());
		repository.save(certificateRequestData);
		return aggregate;
	}
}
