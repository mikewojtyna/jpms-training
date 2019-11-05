package pro.buildmysoftware.certit.catalog.spring;

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
public class AddProductIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	// @formatter:off
	@DisplayName(
		"add new product"
	)
	// @formatter:on
	@Test
	void addProduct() throws Exception {
		// given
		String command = "{}";

		// when
		mockMvc.perform(MockMvcRequestBuilders.post("/api/catalog")
			.contentType(MediaType.APPLICATION_JSON)
			.content(command))

			// then
			.andExpect(MockMvcResultMatchers.status().isCreated());
	}
}
