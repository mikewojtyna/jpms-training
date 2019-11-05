package pro.buildmysoftware.certit.client.spring;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class SendMessageCommandDto {

	private final String msg;
	private final String client;

	@JsonCreator
	public SendMessageCommandDto(@JsonProperty("msg") String msg,
				     @JsonProperty("client") String client) {
		this.msg = msg;
		this.client = client;
	}
}
