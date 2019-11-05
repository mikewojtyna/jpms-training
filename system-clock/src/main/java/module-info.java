module pro.buildmysoftware.common.clock.system {
	requires pro.buildmysoftware.common.clock.api;
	provides pro.buildmysoftware.common.clock.api.ClockProvider with pro.buildmysoftware.common.clock.system.UtcClockProvider;
}