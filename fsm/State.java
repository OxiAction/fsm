package fsm;

import java.util.ArrayList;
import java.util.List;

public class State implements StateInterface {
	// transitions of this State
	protected List<Transition> transitions = new ArrayList<Transition>();
	// determine if this State is active or not
	protected boolean active;
	// reference to parent State
	protected StateInterface parent;
	// name of the State
	protected String name;
	// default state
	protected StateInterface defaultState;
	// active state
	protected StateInterface activeState;
	
	public State(String name) {
		this.name = name;
	}
	
	@Override
	public void execute() {
	}
	
	@Override
	public void update() {
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
	public void setActive(StateInterface activeState) {
		System.out.println("setting active state @" + this.getName() + " to: " + activeState.getName());
		this.activeState = activeState;
	}
	
	@Override
	public StateInterface getActive() {
		return this.activeState;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setDefault(StateInterface defaultState) {
		System.out.println("setting default state @" + this.getName() + " to: " + defaultState.getName());
		this.defaultState = defaultState;
	}
	
	@Override
	public StateInterface getDefault() {
		return this.defaultState;
	}
}
