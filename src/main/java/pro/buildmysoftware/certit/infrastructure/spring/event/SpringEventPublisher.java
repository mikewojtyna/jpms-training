package pro.buildmysoftware.certit.infrastructure.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import pro.buildmysoftware.certit.domain.common.DomainEvent;
import pro.buildmysoftware.certit.domain.common.EventPublisher;

public class SpringEventPublisher implements EventPublisher {

	private final ApplicationEventPublisher applicationEventPublisher;

	public SpringEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Override
	public void publish(Iterable<DomainEvent> domainEvents) {
		domainEvents.forEach(applicationEventPublisher::publishEvent);
	}
}
