package event;

public final class Event {
	public static String name;
	
	public static void setName(String name) {
		Event.name = name;
	}
	
	public static String getName() {
		return Event.name;
	}
}
