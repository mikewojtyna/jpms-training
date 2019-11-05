package pro.buildmysoftware.certit.client.spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class RestIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	// @formatter:off
	@DisplayName(
		"send msg"
	)
	// @formatter:on
	@Test
	void sendMsg() throws Exception {
		// given
		String command = "{\"msg\": \"hello\"}";

		// when
		mockMvc.perform(MockMvcRequestBuilders
			.post("/api/clients/123/messages").content(command)
			.contentType(MediaType.APPLICATION_JSON))
			// then
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
