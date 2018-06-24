package custom;

import fsm.*;

public class Attack extends StateAtomic {
	
	public Attack() {
		super("Attack");
	}

	@Override
	public void execute() {
		System.out.println("=> executing Attack (AtomicState)");
	}
}
