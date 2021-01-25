package practice;

import java.util.*;

public class BalanceParentheses {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		if(balanceParentheses(s)) {
			System.out.println("BALANCED");
		}
		else {
			System.out.println("NOT BALANCED");
		}
		

	}
	
	static boolean balanceParentheses(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		boolean flag = true;
		for(int i=0; i<s.length(); i++) {
			
			if(stack.isEmpty()) {
				stack.push(s.charAt(i));
				continue;
			}
			
			if(s.charAt(i)==']') {
				if(stack.peek()=='[') {
					stack.pop();
				}else {
					return false;
				}
			}else if(s.charAt(i)=='}') {
				if(stack.peek()=='{') {
					stack.pop();
				}else {
					return false;
				}
			}else if(s.charAt(i)==')') {
				if(stack.peek()=='(') {
					stack.pop();
				}else {
					return false;
				}
			}else {
				stack.push(s.charAt(i));
			}
			
		}
		
		if(!stack.isEmpty()) {
			flag = false;
		}
		
		
		return flag;
		
		
	}

}
