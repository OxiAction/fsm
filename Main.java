import java.io.*;
import java.util.*;

import custom.*;
import event.*;
import fsm.*;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		
	// FINITE STATE MACHINES
		
		StateComposite ai = new StateComposite("AI");
		StateComposite movement = new StateComposite("Movement");
		StateComposite combat = new StateComposite("Combat");
		
	// MOVEMENT SETUP
		movement.addTransition(new Transition(combat, "enemy-in-range"));
		
		StateAtomic idle = new Idle();
		StateAtomic approach = new Approach();
		
		movement.addChild(idle);
		movement.addChild(approach);
		// DEFAULT
		movement.setDefault(idle);
		
		idle.addTransition(new Transition(approach, "enemy-line-of-sight"));
		approach.addTransition(new Transition(idle, "enemy-dead"));
		
	// COMBAT SETUP
		combat.addTransition(new Transition(movement, "!enemy-in-range"));
		// OR
		combat.addTransition(new Transition(movement, "enemy-dead"));
		
		StateAtomic attack = new Attack();
		StateAtomic defend = new Defend();
		
		combat.addChild(attack);
		combat.addChild(defend);
		// DEFAULT
		combat.setDefault(attack);
		
		attack.addTransition(new Transition(defend, "defense-available-AND-defense-alert"));
		defend.addTransition(new Transition(attack, "!defense-available"));
		// OR
		defend.addTransition(new Transition(attack, "!defense-alert"));
		
	// AI
		ai.addChild(movement);
		ai.addChild(combat);
		// DEFAULT & ACTIVE
		ai.setDefault(movement);
		ai.setActive(movement);
		
		movement.setActive(movement.getDefault());
		
	// MISC

		// write the name of an event in the console (e.g.
		// "enemy-line-of-sight")
		// to trigger updates of transitions and execute active states
		while (true) {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("\nEnter a new Transition Event Name (or just hit ENTER):");
			try {
				String eventName = bufferedReader.readLine();
				Event.setName(eventName.trim());

				System.out.println("\n*** AI update() ***");
				ai.update();

				Event.setName("");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
