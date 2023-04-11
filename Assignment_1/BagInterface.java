package Assignment_1;

/** An interface that describes the operations of a bag of objects. */
public interface BagInterface<T> 
{
    /** Gets the current number of entries in this bag.
        @return The integer number of entries currently in the bag. */
    public int getCurrentSize();
    /** Sees whether this bag is empty.
        @return True if the bag is empty, or false if not. */
    public boolean isEmpty();
    /** Adds a new entry to this bag.
        @param newEntry The object to be added as a new entry.
        @return True if the addition is successful, or false if not. */
    public boolean add(T newEntry);
    /** Removes one unspecified entry from this bag, if possible.
        @return Either the removed entry, if the removal was successful, or null. */
    public T remove();
    /** Removes one occurrence of a given entry from this bag, if possible.
        @param anEntry The entry to be removed.
        @return True if the removal was successful, or false if not. */
    public boolean remove(T anEntry);
    /** Removes all entries from this bag. */
    public void clear();
    /** Counts the number of times a given entry appears in this bag.
        @param anEntry The entry to be counted.
        @return The number of times anEntry appears in the bag. */
    public int getFrequencyOf(T anEntry);
    /** Tests whether this bag contains a given entry.
        @param anEntry The entry to find.
        @return True if the bag contains anEntry, or false if not. */
    public boolean contains(T anEntry);
    /** Retrieves all entries that are in this bag.
        @return A newly allocated array of all the entries in the bag. Note: If the bag is empty, the returned array is empty. */
    public T[] toArray();
    /** Combines a bag's contents with the current bag. (DUPS OKAY)
        @param b1 (Linked/ResizableArrayBag) Bag to be added
        @return A newly build bag with the elements of two bags. */
    public BagInterface<T> union(BagInterface bag);
    /** Takes the common values in the current bag and another bag. (DUPS OKAY)
        @param bag (Linked/ResizableArrayBag) Bag to be compared
        @return A new bag that contains only the common items from both bags */
    public Bag intersection(Bag bag);
    /** Takes the difference of the amount of values in the current bag and another bag. (DUPS OKAY)
        @param bag (Linked/ResizableArrayBag) Bag to be compared
        @return A new bag that contains the difference of the amount of values from both bags */
    public Bag difference(Bag bag);
}
