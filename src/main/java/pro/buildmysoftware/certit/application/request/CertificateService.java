package pro.buildmysoftware.certit.application.request;

import pro.buildmysoftware.certit.domain.common.AggregateRepository;
import pro.buildmysoftware.certit.domain.common.EventPublisher;
import pro.buildmysoftware.certit.domain.request.*;

import java.util.function.Consumer;

public class CertificateService {

	private final AggregateRepository<CertificateRequest,
		CertificateRequestId> repository;
	private final CertificateOffice office;
	private final EventPublisher eventPublisher;

	public CertificateService(AggregateRepository<CertificateRequest,
		CertificateRequestId> repository, CertificateOffice office,
				  EventPublisher eventPublisher) {
		this.repository = repository;
		this.office = office;
		this.eventPublisher = eventPublisher;
	}

	public CertificateRequest requestCertificate(RequestCertificateCommand command) {
		CertificateRequest certificateRequest = office
			.requestCertificate(command);
		return saveAndPublishEvents(certificateRequest);
	}

	public void scheduleExam(ScheduleExamCommand command) {
		handleRequestCommand(command
			.getId(), certificateRequest -> certificateRequest
			.scheduleExam(command.getExamDate()));
	}

	public void issueCertificate(IssueCertificateCommand command) {
		handleRequestCommand(command
			.getId(), CertificateRequest::issueCertificate);
	}

	public void passExam(PassExamCommand command) {
		handleRequestCommand(command
			.getId(), CertificateRequest::passExam);
	}

	public void failExam(FailExamCommand command) {
		handleRequestCommand(command
			.getId(), CertificateRequest::failExam);
	}

	private CertificateRequest saveAndPublishEvents(CertificateRequest certificateRequest) {
		repository.save(certificateRequest);
		eventPublisher.publish(certificateRequest.domainEvents());
		certificateRequest.clearDomainEvents();
		repository.save(certificateRequest);
		return certificateRequest;
	}

	private void handleRequestCommand(CertificateRequestId id,
					  Consumer<CertificateRequest> handler) {
		repository.load(id).ifPresent(certificateRequest -> {
			handler.accept(certificateRequest);
			saveAndPublishEvents(certificateRequest);
		});
	}
}
