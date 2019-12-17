package L7_EnumDays;

public enum DaysOfWeek {
	SUNDAY,
	MONDAY(true),
	TUESDAY,
	WEDNESDAY(true),
	THURSDAY,
	FRIDAY(true),
	SATURDAY;

	private boolean epamClass;

	DaysOfWeek() { }

	DaysOfWeek(boolean epamClass) {
		this.epamClass = epamClass;
	}

	public boolean isEpamClass() {
		return epamClass;
	}

	public DaysOfWeek nextDay() {
		DaysOfWeek[] days = DaysOfWeek.values();
		return days[(this.ordinal() + 1) % days.length];
	}

}
