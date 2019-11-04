package pro.buildmysoftware.certit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pro.buildmysoftware.certit.request.application.CertificateService;
import pro.buildmysoftware.certit.infrastructure.spring.rest.request.CertificateRestController;
import pro.buildmysoftware.certit.request.domain.RequestCertificateCommand;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CertificateRestController.class)
public class RestApiIntegrationTests {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CertificateService service;

	// @formatter:off
	@DisplayName(
		"when POST on /api/requests, " +
		"then new certificate request is created"
	)
	// @formatter:on
	@Test
	void test() throws Exception {
		// given
		String commandAsJson = "{}";

		// when
		mockMvc.perform(post("/api/requests")
			.contentType(MediaType.APPLICATION_JSON)
			.content(commandAsJson))
			// then
			.andExpect(status().isCreated());
		verify(service).requestCertificate(Mockito
			.any(RequestCertificateCommand.class));
	}
}
