package custom;

import fsm.*;

public class Idle extends StateAtomic {
	
	public Idle(StateInterface state) {
		super(state);
	}

	@Override
	public void execute() {
		System.out.println("=> executing Idle (AtomicState)");
	}
}
