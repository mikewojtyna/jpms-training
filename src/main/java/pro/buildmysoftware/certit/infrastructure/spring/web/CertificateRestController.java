package pro.buildmysoftware.certit.infrastructure.spring.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.buildmysoftware.certit.application.request.CertificateService;
import pro.buildmysoftware.certit.domain.request.RequestCertificateCommand;

@RestController
@RequestMapping("/api/requests")
public class CertificateRestController {

	private final CertificateService service;

	public CertificateRestController(CertificateService service) {
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void requestCertificate(@RequestBody RequestCertificateCommand command) {
		service.requestCertificate(command);
	}
}
