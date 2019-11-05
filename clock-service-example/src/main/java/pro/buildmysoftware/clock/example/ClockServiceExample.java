package pro.buildmysoftware.clock.example;

import pro.buildmysoftware.common.clock.api.ClockProvider;

import java.time.Clock;

public class ClockServiceExample {

	public static void main(String[] args) {
		Clock clock = ClockProvider.getInstance();

		System.out.printf("Provided clock: %s", clock);
	}
}
