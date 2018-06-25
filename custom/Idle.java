package custom;

import fsm.*;

public class Idle extends StateAtomic {
	
	public Idle() {
		super("Idle");
	}

	@Override
	public void execute() {
		System.out.println("=> executing Idle (AtomicState)");
	}
}
