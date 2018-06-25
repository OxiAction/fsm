package fsm;

import java.util.ArrayList;
import java.util.List;

import event.Event;

public class StateComposite extends State {
	// children of this State
	protected List<StateInterface> children = new ArrayList<StateInterface>();
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
					// target state
					StateInterface toState = transition.getToState();	
					
					// change active state
					this.setActive(toState);
					
					System.out.println("=> transition details:");
					System.out.println("eventName -> " + Event.getName());
					System.out.println("deactivate -> " + transition.getFromState().getName());
					System.out.println("activate -> " + transition.getToState().getName());
					
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
		children.add(state);
		state.setParent(this);
	}
	
	public List<StateInterface> getChildren() {
		return this.children;
	}
}
