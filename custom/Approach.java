package custom;

import fsm.*;

public class Approach extends StateAtomic {
	
	public Approach() {
		super("Approach");
	}

	@Override
	public void execute() {
		System.out.println("=> executing Approach (AtomicState)");
	}
}
