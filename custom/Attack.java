package custom;

import fsm.*;

public class Attack extends StateAtomic {
	
	public Attack(StateInterface state) {
		super(state);
	}

	@Override
	public void execute() {
		System.out.println("=> executing Attack (AtomicState)");
	}
}
