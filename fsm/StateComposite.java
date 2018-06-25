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
	
	public void update() {
		if (this.getActive() == null) {
			return;
		}
		
		List<Transition> transitions = this.activeState.getTransitions();
		
		if (transitions != null) {
			for (Transition transition : transitions) {
				if (Event.getName() != null && Event.getName().equals(transition.getEventName())) {
			
					StateInterface fromState = transition.getFromState();
					StateInterface toState = transition.getToState();
					
					if (fromState.getParent() != null) {
						fromState.getParent().setActive(toState);
					}
					
					System.out.println("=> transition details:");
					System.out.println("eventName -> " + Event.getName());
					System.out.println("deactivate -> " + fromState.getName());
					System.out.println("activate -> " + toState.getName());
					
					if (toState.getDefault() != null) {
						toState.setActive(toState.getDefault());
					}
					
					toState.execute();
					toState.update();
					
					// leave here!
					return;
				}
			}
		}
		
		this.getActive().execute();
		this.getActive().update();
	}
	
	@Override
	public void execute() {
		System.out.println("=> executing " + this.getName() + " (default)");
	}
	
	public void addChild(StateInterface state) {
		childs.add(state);
		state.setParent(this);
	}
	
	public List<StateInterface> getChilds() {
		return this.childs;
	}
}
