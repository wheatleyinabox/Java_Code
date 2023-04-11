package Assignment_1;

public class LinkedBag<T> implements BagInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    // implement BagInterface methods
    // Union
    // Intersection
    // Difference

    public boolean add(T newEntry)
    {
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;

        firstNode = newNode;
        numberOfEntries++;
        return true;
    }
    
    public T remove()
    {
        T result = null;
        if (firstNode != null)
        {
            result = (T) firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return result;
    }
    public boolean remove(T anEntry)
    {
        boolean result = false;
        Node nodeN = getReferenceOf(anEntry);
        if (nodeN != null)
        {
            nodeN.setData(firstNode.getData());
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            result = true;
        }
        return result;
    }

    private Node getReferenceOf(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.getNextNode();
            }
        }
        return currentNode;
    }

    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    public void clear()
    {
        while(!isEmpty())
        {
            remove();
        }
    }

    public int getFrequencyOf(T anEntry)
    {
        int frequency = 0;
        int counter = 0;

        Node currentNode = firstNode;
        while((counter < numberOfEntries) && (currentNode != null))
        {
            if(anEntry.equals(currentNode.getData()))
            {
                frequency++;
            }
            counter++;
            currentNode = currentNode.getNextNode();
        }
        return frequency;
    }

    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = (T) currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }
        return result;
    }
}

class Node<T>
{
    private T data;
    Node next;

    Node(T dataPortion)
    {
        this(dataPortion, null);
    }
    private Node(T dataPortion, Node nextNode)
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