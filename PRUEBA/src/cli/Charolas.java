package cli;

import java.util.Stack;

public class Charolas {
	// Declare the stack of trays
	static Stack<Integer> charola = new Stack<>();
	
	// Refill trays
	public void refillTrays() {
		for (int i = 0; i < 10; ++i) {
			charola.push(i);
		}
		System.out.println("Trays have been refilled");
	}
}



