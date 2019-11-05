package pro.buildmysoftware.common.clock.system;

import pro.buildmysoftware.common.clock.api.ClockProvider;

import java.time.Clock;

public class UtcClockProvider implements ClockProvider {

	@Override
	public Clock provide() {
		return Clock.systemUTC();
	}
}
