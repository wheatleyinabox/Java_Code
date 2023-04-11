package assignment2;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ResizableArrayStack<T> implements StackInterface<T>
{
	private T[] stack; // array of stack entries
	private int topIndex; // index of top entry
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public ResizableArrayStack()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public ResizableArrayStack(int initialCapacity)
	{
		integrityOK = false;
		checkCapacity(initialCapacity);
		
		// the case is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		integrityOK = true;
	}
	
    private void checkIntegrity() 
    {
        if (!integrityOK) {
            throw new SecurityException("ResizibleArrayStack object is corrupt.");
        }
    }
    public void checkCapacity(int capacity) 
    {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a stack whose " +
                    "capacity exceeds allowed " +
                    "maximum of " + MAX_CAPACITY);
        }
    }
	
	public void push(T newEntry)
	{
		checkIntegrity();
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}
	
	public void ensureCapacity()
	{
		if (topIndex >= stack.length - 1) // if array is full double its size
		{
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		}
	}
	
	public T pop()
	{
		checkIntegrity();
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	}
	
	public T peek()
	{
		checkIntegrity();
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			return stack[topIndex];
		}
	}
	
	public boolean isEmpty()
	{
		return topIndex < 0;
	}
	
	public void clear()
	{
		checkIntegrity();
		
		// remove references to the objects in the stack,
		// but do not deallocate the array
		while(topIndex > -1)
		{
			stack[topIndex] = null;
			topIndex--;
		}
	}
}
