package fsm;

import java.util.ArrayList;
import java.util.List;

import event.Event;

public class StateComposite extends State {
	// childs of this State
	protected List<StateInterface> childs = new ArrayList<StateInterface>();
	// transitions of this State
	protected List<Transition> transitions = new ArrayList<Transition>();
	
	public StateComposite(String name) {
		super(name);
	}

	/**
	 * Recursive update of all child transitions
	 */
	public void updateTransitions() {
		for (StateInterface child : this.childs) {
			if (child.getActive()) {
				List<Transition> transitions = child.getTransitions();

				// check for transitions
				for (Transition transition : transitions) {

					if (Event.getName().equals(transition.getEventName())) {

						// deactivate "from state"
						StateInterface fromState = transition.getFromState();
						fromState.setActive(false);

						// activate "to state"
						StateInterface toState = transition.getToState();
						toState.setActive(true);

						System.out.println("=> transition details:");
						System.out.println("eventName -> " + Event.getName());
						System.out.println("deactivate -> " + fromState.getName());
						System.out.println("activate -> " + toState.getName());
					}
				}
				
				if (child instanceof StateComposite) {
					((StateComposite) child).updateTransitions();
				}
			}
		}
	}
	
	/**
	 * Recursive execution of all childs
	 */
	@Override
	public void execute() {
		for (StateInterface child : this.childs) {
			if (child.getActive()) {
				child.execute();
			}
		}
	}
	
	public void addChild(StateInterface state) {
		childs.add(state);
		state.setParent(this);
	}
	
	public List<StateInterface> getChilds() {
		return this.childs;
	}
}
