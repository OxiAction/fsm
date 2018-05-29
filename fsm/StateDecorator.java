package fsm;

import java.util.List;

public class StateDecorator implements StateInterface {
	protected StateInterface state;
	
	public StateDecorator(StateInterface state) {
		this.state = state;
	}

	@Override
	public void execute() {
		this.state.execute();
	}

	@Override
	public void addTransition(Transition transition) {
		this.state.addTransition(transition);
	}

	@Override
	public List<Transition> getTransitions() {
		return this.state.getTransitions();
	}

	@Override
	public void setParent(StateInterface state) {
		this.state.setParent(state);
	}

	@Override
	public StateInterface getParent() {
		return this.state.getParent();
	}

	@Override
	public void setActive(boolean active) {
		this.state.setActive(active);
	}

	@Override
	public boolean getActive() {
		return this.state.getActive();
	}

	@Override
	public String getName() {
		return this.state.getName();
	}
}
