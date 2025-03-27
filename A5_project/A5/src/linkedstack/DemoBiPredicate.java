package linkedstack;

import java.util.function.BiPredicate;

public class DemoBiPredicate {

	public static void push(LinkedStack s, String str, BiPredicate<String, String> p) {
		String top = s.peek();
		System.out.print("push " + str + "?: ");
		boolean pushed = s.pushIf(str, p);
		System.out.print(pushed + ", ");
		if (pushed) {
			System.out.println(str + " comes before " + top);
		}
		else {
			System.out.println(str + " comes after " + top);
		}
	}
	
	public static void main(String[] args) {
		BiPredicate<String, String> p = new StringLessThan();
		LinkedStack s = new LinkedStack();
		
		String str = "zebra";
		s.push(str);
		System.out.println(s);
		
		str = "monkey";
		push(s, str, p);
		
		str = "turtle";
		push(s, str, p);
		
		str = "koala";
		push(s, str, p);
		
		System.out.println(s);
	}

}
