package custom;

import fsm.*;

public class Defend extends StateAtomic {
	
	public Defend() {
		super("Defend");
	}

	@Override
	public void execute() {
		System.out.println("=> executing Defend (AtomicState)");
	}
}
