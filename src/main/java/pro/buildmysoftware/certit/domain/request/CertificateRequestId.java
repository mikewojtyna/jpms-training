package pro.buildmysoftware.certit.domain.request;

import pro.buildmysoftware.certit.domain.common.AggregateId;

import java.util.UUID;

public class CertificateRequestId extends AggregateId {
	public CertificateRequestId(UUID uuid) {
		super(uuid);
	}
}
