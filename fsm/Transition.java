package fsm;

public class Transition {
	// source State
	protected StateInterface fromState;
	// destination State
	protected StateInterface toState;
	// event name, which triggers this transition
	protected String eventName;

	/**
	 * Transition
	 * 
	 * @param toState
	 * @param eventName
	 */
	public Transition(StateInterface toState, String eventName) {
		this.toState = toState;
		this.eventName = eventName;
	}

	public StateInterface getFromState() {
		return fromState;
	}

	public void setFromState(StateInterface fromState) {
		this.fromState = fromState;
	}

	public StateInterface getToState() {
		return toState;
	}

	public void setToState(StateInterface toState) {
		this.toState = toState;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
}
