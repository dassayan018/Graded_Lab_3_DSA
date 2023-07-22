package com.gl.Sayan_Das.stacksqueue.LAB3;
import java.util.*;
public class BalancedBrackets {
	
	static boolean areBracketsBalanced(String expr) {
		
		Deque<Character> stack = new ArrayDeque<Character>();
		
		for(int i=0;i< expr.length();i++) {
			char x = expr.charAt(i);
			
			if (x=='(' || x=='[' || x=='{') {
				stack.push(x);
				continue;
			}
			
			if (stack.isEmpty())
				return false;
			
			char check;
			switch(x) {
			case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
			}
		}
		
		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the expression");
		
//		String expr = "([{}]))";
		String expr = sc.nextLine();
		 
        // Function call
        if (areBracketsBalanced(expr))
            System.out.println("Given expression is Balanced ");
        else
            System.out.println("Given expression is Not Balanced ");

	}

}
