package pro.buildmysoftware.domain.common;

import java.util.Optional;

public interface AggregateRepository<A, ID> {

	Optional<A> load(ID id);

	A save(A aggregate);
}
