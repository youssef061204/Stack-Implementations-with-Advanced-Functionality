package linkedstack;

import java.util.function.Predicate;

public class DemoPredicate {
	
	public static void push(LinkedStack s, String str, Predicate<String> p) {
		System.out.print("push " + str + "?: ");
		boolean pushed = s.pushIf(str, p);
		System.out.print(pushed + ", ");
		if (pushed) {
			System.out.println(str + " starts with C");
		}
		else {
			System.out.println(str + " does not start with C");
		}
	}

	public static void main(String[] args) {
		Predicate<String> p = new StringStartsWith('C');
		LinkedStack s = new LinkedStack();
		
		String str = "CISC102";
		push(s, str, p);
		
		str = "CISC121";
		push(s, str, p);
		
		str = "MATH111";
		push(s, str, p);
		
		str = "CISC124";
		push(s, str, p);
		
		System.out.println(s);
	}

}
