package pro.buildmysoftware.certit.infrastructure.spring.persistence;

import pro.buildmysoftware.certit.domain.common.AggregateRepository;
import pro.buildmysoftware.certit.domain.request.CertificateRequest;
import pro.buildmysoftware.certit.domain.request.CertificateRequestId;
import pro.buildmysoftware.certit.domain.request.CertificateRequester;
import pro.buildmysoftware.certit.domain.request.CertificateTypeId;

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
