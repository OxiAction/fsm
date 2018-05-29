package fsm;

import java.util.List;

public interface StateInterface {
	public void execute();
	public void addTransition(Transition transition);
	public List<Transition> getTransitions();
	public void setParent(StateInterface state);
	public StateInterface getParent();
	public void setActive(boolean active);
	public boolean getActive();
	public String getName();
}
