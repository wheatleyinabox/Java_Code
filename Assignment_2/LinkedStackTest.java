package assignment2;

import java.util.Scanner;

public class LinkedStackTest 
{
	private static int precedence(Character operator)
	{
		if (operator == '(')
		{
			return 1;
		}
		if (operator == '*' || operator == '/')
		{
			return 3;
		}
		if (operator == '+' || operator == '-')
		{
			return 2;
		}
		return 0;
	}
	private static String convertToPostfix(String infix)
	{
		// converts an infix expression to an equivalent postfix expression
		StackInterface<Character> operatorStack = new LinkedStack<Character>();
		String postfix = "";
		infix.replace(" ", "");
		Character topOperator, nextCharacter;
		int count = 0;
	
		while (count < infix.length())
		{
			nextCharacter = infix.charAt(count);
			if (Character.isAlphabetic(nextCharacter))
			{
				postfix += nextCharacter;
			}
			else
			{
				switch (nextCharacter)
				{
					case '^':
					{
						operatorStack.push(nextCharacter);
						break;
					}
					case '+' : case '-' : case '*' : case '/':
					{
						while (!operatorStack.isEmpty() && precedence(nextCharacter) <= precedence(operatorStack.peek()))
						{
							postfix += operatorStack.peek();
							operatorStack.pop();
						}
						operatorStack.push(nextCharacter);
						break;
					}
					case '(':
					{
						operatorStack.push(nextCharacter);
						break;
					}
					case ')': // Stack is not empty if infix expression is valid
					{
						topOperator = operatorStack.pop();
						while (topOperator != '(')
						{
							postfix += topOperator;
							topOperator = operatorStack.pop();
						}
						break;
					}
					default: 
					{
						break;
					}
				}
			}
			count++;
		}
	
		while (!operatorStack.isEmpty())
		{
			topOperator = operatorStack.pop();
			postfix += topOperator;
		}
	
		return postfix;
	}
	
	public static void main(String[] args) 
	{
		// testing method functionality
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an infix expression:");
		String userExpression = input.nextLine();
		
		System.out.println(convertToPostfix(userExpression));
		input.close();
		
		System.out.println("\nMore examples: ");
		String expression = "a / b * (c + (d - e))";
		System.out.println(convertToPostfix(expression));
		// returns ab/cde-+*
		expression = "a * b / (c - a) + d * e";
		System.out.println(convertToPostfix(expression));
		// returns ab*ca-/de*+
		expression = "a * b";
		System.out.println(convertToPostfix(expression));
		// returns ab*
		expression = "(a + b) * c";
		System.out.println(convertToPostfix(expression));
		// returns ab+c*
		expression = "a + b * c";
		System.out.println(convertToPostfix(expression));
		// returns abc*+
		expression = "a - b + c";
		System.out.println(convertToPostfix(expression));
		// returns ab-c+
		expression = "a ^ b ^ c";
		System.out.println(convertToPostfix(expression));
		// returns abc^^
		
		
		//=================== UNCOMMENT TO TEST CLASSES ===================
//		// integers
//		StackInterface<Integer> linkedIntStack = new LinkedStack<>();
//		linkedIntStack.push(1);
//		linkedIntStack.push(2);
//		linkedIntStack.push(3);
//		linkedIntStack.push(4);
//		linkedIntStack.push(5);
//		
//		int topInt = linkedIntStack.peek(); // Returns "5"
//		System.out.println(topInt + " is at the top of the stack.");
//		
//		topInt = linkedIntStack.pop(); // Removes and returns "5"
//		System.out.println(topInt + " is removed from the stack.");
//		
//		topInt = linkedIntStack.peek(); // Returns "4"
//		System.out.println(topInt + " is at the top of the stack.");
//		
//		topInt = linkedIntStack.pop(); // Removes and returns "4"
//		System.out.println(topInt + " is removed from the stack.");
//		
//		linkedIntStack.clear();
//		//System.out.println("The stack has been cleared: " + linkedIntStack.peek()); 
//		// returns EmptyStackException	
//		
//		System.out.println();
//		
//		StackInterface<String> linkedStringStack = new LinkedStack<>();
//		linkedStringStack.push("Jim");
//		linkedStringStack.push("Jess");
//		linkedStringStack.push("Jill");
//		linkedStringStack.push("Jane");
//		linkedStringStack.push("Joe");
//		
//		String topStr = linkedStringStack.peek(); // Returns "Joe"
//		System.out.println(topStr + " is at the top of the stack.");
//		
//		topStr = linkedStringStack.pop(); // Removes and returns "Joe"
//		System.out.println(topStr);
//		
//		topStr = linkedStringStack.peek(); // Returns "Jane"
//		System.out.println(topStr + " is at the top of the stack.");
//		
//		topStr = linkedStringStack.pop(); // Removes and returns "Jane"
//		System.out.println(topStr + " is removed from the stack.");
//			
//		linkedStringStack.clear();
//		//System.out.println("The stack has been cleared: " + linkedStringStack.peek()); 
//		// returns EmptyStackException
	}
}
