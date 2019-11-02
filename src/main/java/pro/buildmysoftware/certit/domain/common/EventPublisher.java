package pro.buildmysoftware.certit.domain.common;

public interface EventPublisher {

	void publish(Iterable<DomainEvent> domainEvents);
}
