package custom;

import fsm.*;

public class Defend extends StateAtomic {
	
	public Defend(StateInterface state) {
		super(state);
	}

	@Override
	public void execute() {
		System.out.println("=> executing Defend (AtomicState)");
	}
}
