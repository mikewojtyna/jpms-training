package pro.buildmysoftware.certit.request.domain;

import pro.buildmysoftware.domain.common.AggregateId;

import java.util.UUID;

public class CertificateRequestId extends AggregateId {

	public CertificateRequestId(UUID uuid) {
		super(uuid);
	}
}
