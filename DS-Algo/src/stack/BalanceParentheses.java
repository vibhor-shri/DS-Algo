package stack;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Given an expression string expression ,
 *  write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in expression.
 *  
 *  Given below are 2 approach, although approach 2 is just to show results of multiple expressions inside 
 *  an array list, it increases the time complexity of the solution. Therefore, approach 2 is not to be used, it is
 *  just for ease and convenience, and better illustration.
 */

public class BalanceParentheses {

	public static void main(String[] args) {
		ArrayList<String> expressionsList = new ArrayList<>();
		expressionsList.add("[()]{}{[()()]()}");
		expressionsList.add("()");
		expressionsList.add("{}");
		expressionsList.add("[]");
		expressionsList.add(")");
		expressionsList.add("(");
		expressionsList.add("[(])");

//		String expression = "[()]{}{[()()]()}";
		// String expression = "()";
		// String expression = "{}";
		// String expression = "[]";
		// String expression = ")";
		// String expression = "(";
		// String expression = "[(])";
//		System.out.println(isValid(expression));
		isValid(expressionsList);

	}

	/*
	 * Approach 1, using a stack to determine is the given expression of parentheses is balanced or not.
	 * 
	 *  Time complexity O(n)
	 *  Space complexity O(n)
	 */
	
	
	private static boolean isValid(String expression) {

		if (expression == null) {
			throw new NullPointerException("Initialize string");
		}
		int length = expression.length();
		if (length == 0 || length == 1)
			return false;

		Stack<Character> characterStack = new Stack<>();
		for (int i = 0; i < length; i++) {

			char c = expression.charAt(i);

			if (c == '(' || c == '{' || c == '[') {
				characterStack.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (characterStack.isEmpty()) {
					return false;
				} else {
					char peek = characterStack.peek();
					if ((peek == '(' && c == ')') || (peek == '{' && c == '}') || (peek == '[' && c == ']')) {
						characterStack.pop();
					}
				}
			}
		}
		return characterStack.isEmpty() ? true : false;
	}
	
	/*
	 * Approach 2 only build up on approach one, just the difference being, 
	 * instead of passing a single expression to the function, we are passing an
	 * ArrayList with multiple expressions.
	 * 
	 * Time complexity O(n^2)
	 * Space complexity O(n)
	 */
	
	
	private static void isValid(ArrayList<String> expressionList) {
	
		if(expressionList == null || expressionList.size() == 0) {
			throw new NullPointerException("Initialize list");
		}
		
		for (String string : expressionList) {
			System.out.println(isValid(string));
		}
	
	}

}
