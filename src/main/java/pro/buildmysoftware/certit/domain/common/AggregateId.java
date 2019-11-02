package pro.buildmysoftware.certit.domain.common;

import java.util.Objects;
import java.util.UUID;

public class AggregateId {

	private final UUID id;

	public AggregateId(UUID uuid) {
		id = uuid;
	}

	public UUID unwrap() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AggregateId that = (AggregateId) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
