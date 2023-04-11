package Assignment_1;

import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T> {
    private T[] bag;
    private int numberOfEntries;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public ResizableArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ResizableArrayBag(int capacity) {
        if (capacity <= MAX_CAPACITY) {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[capacity];
            bag = tempBag;
            numberOfEntries = 0;
            integrityOK = true;
        } else {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum.");
        }
    }

    // implement BagInterface methods
    // Union
    public BagInterface<T> union(BagInterface secondBag) {
        BagInterface<T> unionBag = new ResizableArrayBag<T>();
        for (int i = 0; i < numberOfEntries; i++) 
        {
            unionBag.add(bag[i]);
        }
        T[] secondBagArray = secondBag.toArray();
        for (T element : secondBagArray)
        {
            unionBag.add(element);
        }
        return unionBag;
    }
    // Intersection
    // Difference

    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("ResizibleArrayBag object is corrupt.");
        }
    }

    public boolean add(T newEntry) {
        checkIntegrity();
        boolean result = true;
        if (isFull()) {
            doubleCapacity();
        } else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    public boolean isFull() {
        return numberOfEntries == bag.length;
    }

    public void doubleCapacity() {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }

    public void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a bag whose " +
                    "capacity exceeds allowed " +
                    "maximum of " + MAX_CAPACITY);
        }
    }

    public boolean remove(T anEntry) {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    public T remove() {
        checkIntegrity();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean found = false;
        int index = 0;

        while (!found && (index < numberOfEntries)) {
            if (anEntry.equals(bag[index])) {
                found = true;
                where = index;
            }
            index++;
        }
        return where;
    }

    private T removeEntry(int givenIndex) {
        T result = null;
        if (!isEmpty() && (givenIndex >= 0)) {
            result = bag[givenIndex];
            bag[givenIndex] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public int getFrequencyOf(T anEntry) {
        checkIntegrity();
        int counter = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                counter++;
            }
        }
        return counter;
    }

    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    public boolean contains(T anEntry) {
        checkIntegrity();
        return getIndexOf(anEntry) > -1;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i];
        }
        return result;
    }
}
