package assignment2;

import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode; // refers the first node in the chain
	
	public LinkedStack()
	{
		topNode = null;
	}
	
	public void push(T newEntry)
	{
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
		//topNode = new Node(newEntry, topNode); // alternative code
	}
	
	public T pop()
	{
		if (isEmpty())
		{
            throw new EmptyStackException();
		}
		T top = peek(); // Might throw EmptyStackException
		if (topNode != null)
		{
			topNode = topNode.getNextNode();
		}
		
		return top;
	}
	
	public T peek()
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			return (T) topNode.getData();
		}
	}
	
	public boolean isEmpty()
	{
		return topNode == null;
	}
	
	public void clear ()
	{
		topNode = null;
	}
	
}
	
class Node<T>
{
		private T data; // entry in stack
		private Node next; // link to next node
		
	    Node(T dataPortion)
	    {
	        this(dataPortion, null);
	    }
	    Node(T dataPortion, Node nextNode)
	    {
	        data = dataPortion;
	        next = nextNode;
	    }

	    T getData()
	    {
	        return data;
	    }
	    
	    void setData(T newData)
	    {
	        data = newData;
	    }

	    Node getNextNode()
	    {
	        return next;
	    }
	    
	    private void setNextNode(Node nextNode)
	    {
	        next = nextNode;
	    }
}