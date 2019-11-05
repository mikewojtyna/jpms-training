package pro.buildmysoftware.common.clock.api;

import java.time.Clock;
import java.util.ServiceLoader;

public interface ClockProvider {

	static Clock getInstance() {
		return ServiceLoader.load(ClockProvider.class).findFirst()
			.orElseThrow().provide();
	}

	Clock provide();
}
