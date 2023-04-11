package assignment2;

import java.util.Scanner;

public class ArrayStackTest
{
	
	private static Character getVariableValue(Character var)
	{
		if (var == 'a' || var == 'A')
		{
			return (char) ('2' - '0');
		}
		if (var == 'b' || var == 'B')
		{
			return (char) ('3' - '0');
		}
		if (var == 'c' || var == 'C')
		{
			return (char) ('4' - '0');
		}
		if (var == 'd' || var == 'D')
		{
			return (char) ('5' - '0');
		}
		if (var == 'e' || var == 'E')
		{
			return (char) ('6' - '0');
		}
		return ('0');
	}
	
	private static Character evaluatePostfix(String postfix)
	{
		// Evaluates an postfix expression ASSUMING INPUT HAS NUMBERS NOT VARIABLES
		StackInterface<Character> valueStack = new ResizableArrayStack<Character>();
		int count = 0, result = 0;
		postfix.replace(" ", "");
		Character nextCharacter;
		
		while (count < postfix.length())
		{
			nextCharacter = postfix.charAt(count);
			if (Character.isAlphabetic(nextCharacter))
			{
				valueStack.push(getVariableValue(nextCharacter));
			}
			else
			{
				switch(nextCharacter)
				{
					case '+' : case '-' : case '*' : case '/' : case '^':
					{
						int operandTwo = valueStack.pop();
						int operandOne = valueStack.pop();
						
						if (nextCharacter == '+')
						{
							result = operandOne + operandTwo;
						}
						else if (nextCharacter == '-')
						{
							result = operandOne - operandTwo;
						}
						else if (nextCharacter == '*')
						{
							result = operandOne * operandTwo;
						}
						else if (nextCharacter == '/')
						{
							result = operandOne / operandTwo;
						}
						else if (nextCharacter == '^')
						{
							result = (int) Math.pow(operandOne, operandTwo);
						}
						valueStack.push((char) result);
						break;
					}
					default: break; // Ignore unexpected characters
				}
			}
			count++;
		}
		return valueStack.peek();
	}
	
	public static void main(String[] args) 
	{
		// testing method functionality
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a postfix expression:");
		String userExpression = input.nextLine();
		
		System.out.println((int) evaluatePostfix(userExpression));
		input.close();
		
		System.out.println("\nMore examples: ");
		String postfix_expression = "ab*ca-/de*+";
		System.out.println(postfix_expression + " = " + (int) (evaluatePostfix(postfix_expression)));
		// returns 33
		postfix_expression = "ab*";
		System.out.println(postfix_expression + " = " + (int) (evaluatePostfix(postfix_expression)));
		// returns 6
		postfix_expression = "ab+c*";
		System.out.println(postfix_expression + " = " + (int) (evaluatePostfix(postfix_expression)));
		// returns 20
		postfix_expression = "abc*+";
		System.out.println(postfix_expression + " = " + (int) (evaluatePostfix(postfix_expression)));
		// returns 14
		postfix_expression = "ab-c+";
		System.out.println(postfix_expression + " = " + (int) (evaluatePostfix(postfix_expression)));
		// returns 3
		postfix_expression = "ac^";
		System.out.println(postfix_expression + " = " + (int) (evaluatePostfix(postfix_expression)));
		// returns 16
		
		//=================== UNCOMMENT TO TEST CLASSES ===================
		// strings
//		StackInterface<String> resizableStringStack = new ResizableArrayStack<>();
//		resizableStringStack.push("Jim");
//		resizableStringStack.push("Jess");
//		resizableStringStack.push("Jill");
//		resizableStringStack.push("Jane");
//		resizableStringStack.push("Joe");
//		
//		String topStr = resizableStringStack.peek(); // Returns "Joe"
//		System.out.println(topStr + " is at the top of the stack.");
//		
//		topStr = resizableStringStack.pop(); // Removes and returns "Joe"
//		System.out.println(topStr);
//		
//		topStr = resizableStringStack.peek(); // Returns "Jane"
//		System.out.println(topStr + " is at the top of the stack.");
//		
//		topStr = resizableStringStack.pop(); // Removes and returns "Jane"
//		System.out.println(topStr + " is removed from the stack.");
//		
//		resizableStringStack.clear();
//		//System.out.println("The stack has been cleared: " + linkedStringStack.peek()); 
//		// returns EmptyStackException
//		
//		System.out.println();
//		
//		// integers
//		StackInterface<Integer> resizableIntStack = new ResizableArrayStack<>();
//		resizableIntStack.push(1);
//		resizableIntStack.push(2);
//		resizableIntStack.push(3);
//		resizableIntStack.push(4);
//		resizableIntStack.push(5);
//		
//		int topInt = resizableIntStack.peek(); // Returns "5"
//		System.out.println(topInt + " is at the top of the stack.");
//		
//		topInt = resizableIntStack.pop(); // Removes and returns "5"
//		System.out.println(topInt + " is removed from the stack.");
//		
//		topInt = resizableIntStack.peek(); // Returns "4"
//		System.out.println(topInt + " is at the top of the stack.");
//		
//		topInt = resizableIntStack.pop(); // Removes and returns "4"
//		System.out.println(topInt + " is removed from the stack.");
//		
//		resizableIntStack.clear();
//		//System.out.println("The stack has been cleared: " + linkedIntStack.peek()); 
//		// returns EmptyStackException	
	}
}
