package custom;

import fsm.*;

public class Approach extends StateAtomic {
	
	public Approach(StateInterface state) {
		super(state);
	}

	@Override
	public void execute() {
		System.out.println("=> executing Approach (AtomicState)");
	}
}
