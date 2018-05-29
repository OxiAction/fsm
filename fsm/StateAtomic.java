package fsm;

public class StateAtomic extends StateDecorator {
	public StateAtomic(StateInterface state) {
		super(state);
	}
	
	@Override
	public void execute() {
		
	}
}
