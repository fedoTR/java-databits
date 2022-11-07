package cli;

import java.util.Stack;

public class Charolas {
	// Declare the stack of trays
	public Stack<Integer> charola = new Stack<>();
}

// Uses a context to prevent using static
class UsesCharolas {
	final Charolas charolas;
	public UsesCharolas(Charolas charolas ) {
		this.charolas = charolas;
	}
	
	public void refillTrays() {
		for (int i = 0; i < 10; ++i) {
			charolas.charola.push(i);
		}
		System.out.println("Trays have been refilled");
	}
}
