package pro.buildmysoftware.certit.request.spring.persistence;

import pro.buildmysoftware.certit.request.domain.*;

import java.util.Optional;
import java.util.UUID;

public class SpringCertificateRequestRepository implements CertificateRequestRepository {

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
