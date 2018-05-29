package fsm;

import java.util.ArrayList;
import java.util.List;

public class StateBasic implements StateInterface {
	// transitions of this State
	protected List<Transition> transitions = new ArrayList<Transition>();
	// determine if this State is active or not
	protected boolean active;
	// reference to parent State
	protected StateInterface parent;
	// name of the State
	protected String name;
	
	public StateBasic(String name) {
		this.name = name;
	}
	
	/**
	 * Recursive execution of all childs
	 */
	@Override
	public void execute() {
	}
	
	@Override
	public void addTransition(Transition transition) {
		// inject this as fromState
		transition.setFromState(this);

		transitions.add(transition);
	}
	
	@Override
	public List<Transition> getTransitions() {
		return this.transitions;
	}
	
	@Override
	public void setParent(StateInterface state) {
		this.parent = state;
	}
	
	@Override
	public StateInterface getParent() {
		return this.parent;
	}
	
	@Override
	public void setActive(boolean active) {
		this.active = active;

		// bubble up!
		if (this.parent != null) {
			this.parent.setActive(active);
		}
	}
	
	@Override
	public boolean getActive() {
		return this.active;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
}
