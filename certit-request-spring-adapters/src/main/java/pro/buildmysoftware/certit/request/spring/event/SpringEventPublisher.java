package pro.buildmysoftware.certit.request.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import pro.buildmysoftware.domain.common.DomainEvent;
import pro.buildmysoftware.domain.common.EventPublisher;

public class SpringEventPublisher implements EventPublisher {

	private final ApplicationEventPublisher applicationEventPublisher;

	public SpringEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Override
	public void publish(Iterable<DomainEvent> events) {
		events.forEach(applicationEventPublisher::publishEvent);
	}

	@Override
	public void publish(DomainEvent event) {
		applicationEventPublisher.publishEvent(event);
	}
}
