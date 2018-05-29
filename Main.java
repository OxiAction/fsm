import java.io.*;
import java.util.*;

import custom.*;
import event.*;
import fsm.*;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		
	// SETUP STATES
		
		// AI FSM (root)
		StateNormal ai = new StateNormal(new StateBasic("AI"));
		
		// Movement FSM
		StateNormal movement = new StateNormal(new StateBasic("Movement"));
		StateAtomic idle = new Idle(new StateBasic("Idle"));
		StateAtomic approach = new Approach(new StateBasic("Approach"));
		movement.addChild(idle);
		movement.addChild(approach);
		ai.addChild(movement);
		
		// Combat FSM
		StateNormal combat = new StateNormal(new StateBasic("Combat"));
		StateAtomic attack = new Attack(new StateBasic("Attack"));
		StateAtomic defend = new Defend(new StateBasic("Defend"));
		combat.addChild(attack);
		combat.addChild(defend);
		ai.addChild(combat);

	// SETUP TRANSITIONS
		
		idle.addTransition(new Transition(approach, "enemy-line-of-sight"));
		
		approach.addTransition(new Transition(idle, "enemy-dead"));
		approach.addTransition(new Transition(attack, "enemy-in-range"));
		
		attack.addTransition(new Transition(defend, "defense-available-AND-defense-alert"));
		attack.addTransition(new Transition(approach, "!enemy-in-range"));
		// OR
		attack.addTransition(new Transition(approach, "enemy-dead"));
		
		defend.addTransition(new Transition(attack, "!defense-available"));
		// OR
		defend.addTransition(new Transition(attack, "!defense-alert"));

	// SET DEFAULT
		
		idle.setActive(true);
		
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

				System.out.println("\n*** AI updateTransitions() ***");
				ai.updateTransitions();

				System.out.println("\n*** AI execute() ***");
				ai.execute();

				Event.setName("");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
