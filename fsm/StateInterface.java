package fsm;

import java.util.List;

public interface StateInterface {
	public void execute();
	public void update();
	public void addTransition(Transition transition);
	public List<Transition> getTransitions();
	public void setParent(StateInterface state);
	public StateInterface getParent();
	public void setActive(StateInterface activeState);
	public StateInterface getActive();
	public void setDefault(StateInterface defaultState);
	public StateInterface getDefault();
	public String getName();
}
