package pro.buildmysoftware.certit.domain.request;

import pro.buildmysoftware.certit.domain.common.DomainEvent;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

public class CertificateRequest {
	private final CertificateRequestId id;
	private final CertificateTypeId certificateType;
	private final CertificateRequester requester;
	private Collection<DomainEvent> domainEvents;

	public CertificateRequest(CertificateRequestId id,
				  CertificateTypeId certificateType,
				  CertificateRequester requester) {
		this.id = id;
		this.certificateType = certificateType;
		this.requester = requester;
	}

	public CertificateRequest(CertificateRequestId id,
				  CertificateTypeId certificateType,
				  CertificateRequester requester,
				  Collection<DomainEvent> domainEvents) {
		this.id = id;
		this.certificateType = certificateType;
		this.requester = requester;
		this.domainEvents = domainEvents;
	}

	public CertificateRequestId getId() {
		return id;
	}

	public Collection<DomainEvent> domainEvents() {
		return Collections.unmodifiableCollection(domainEvents);
	}

	public void scheduleExam(LocalDateTime examDate) {

	}

	public void issueCertificate() {

	}

	public void passExam() {

	}

	public void failExam() {

	}

	public void clearDomainEvents() {

	}
}
