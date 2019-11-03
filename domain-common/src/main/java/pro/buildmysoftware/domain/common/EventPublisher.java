package pro.buildmysoftware.domain.common;

public interface EventPublisher {

	void publish(Iterable<DomainEvent> events);

	void publish(DomainEvent event);
}
