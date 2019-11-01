package pro.buildmysoftware.certit.domain.common;

import lombok.Value;
import lombok.experimental.NonFinal;

import java.time.Instant;

@Value
@NonFinal
public class DomainEvent {
	private Instant timestamp;
}
