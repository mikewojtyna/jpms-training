package pro.buildmysoftware.domain.common;

import java.util.ServiceLoader;

public interface EventPublisher {

	void publish(Iterable<DomainEvent> events);

	void publish(DomainEvent event);

	interface EventPublisherProvider {

		static EventPublisher getInstance() {
			return ServiceLoader.load(EventPublisherProvider.class)
				.findFirst().orElseThrow().provide();
		}

		EventPublisher provide();
	}
}
