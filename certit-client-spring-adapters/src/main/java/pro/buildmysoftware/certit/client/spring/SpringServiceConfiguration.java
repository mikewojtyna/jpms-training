package pro.buildmysoftware.certit.client.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.buildmysoftware.certit.client.application.ClientManager;
import pro.buildmysoftware.certit.client.domain.ClientDb;
import pro.buildmysoftware.certit.client.domain.ClientDetails;
import pro.buildmysoftware.certit.client.domain.MessageSender;
import pro.buildmysoftware.certit.spring.common.SpringEventPublisher;
import pro.buildmysoftware.domain.common.EventPublisher;

import java.time.Clock;

@Configuration
public class SpringServiceConfiguration {

	@Bean
	public ClientDb clientDb() {
		return new ClientDb() {
			@Override
			public void addClient(ClientDetails details) {
				// do nothing
			}

			@Override
			public void updateClient(ClientDetails clientDetails) {
				// do nothing
			}
		};
	}

	@Bean
	public MessageSender messageSender() {
		return (client, msg) -> {
			// do nothing
		};
	}

	@Bean
	public ClientManager clientManager(MessageSender messageSender,
					   ClientDb clientDb,
					   EventPublisher eventPublisher,
					   Clock clock) {
		return new ClientManager(messageSender, clientDb,
			eventPublisher, clock);
	}


	@Bean
	public Clock clock() {
		return Clock.systemUTC();
	}

	@Bean
	public EventPublisher eventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		return new SpringEventPublisher(applicationEventPublisher);
	}
}
