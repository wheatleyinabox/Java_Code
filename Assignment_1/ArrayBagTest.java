package Assignment_1;

import java.util.Arrays;

public class ArrayBagTest {
    public static void main(String[] args) {
        // test BagInterface methods (ResizableArrayBag)

        System.out.println("Creating an empty bag.");
        BagInterface<String> bag = new ResizableArrayBag<String>();
        System.out.println(Arrays.toString((bag.toArray())));
        System.out.println(bag.isEmpty());

        String[] testStrings1 = { "", "B" };
        for (int i = 0; i < testStrings1.length; i++) {
            bag.add(testStrings1[i]);
        }
        System.out.println(bag.getFrequencyOf(""));
        System.out.println(bag.contains("B"));
        System.out.println(bag.remove(""));
        System.out.println(Arrays.toString((bag.toArray())));
        bag.clear();

        String[] contentsOfBag = { "A", "D", "B", "A", "C", "A", "D", "" };
        for (int i = 0; i < contentsOfBag.length; i++) {
            bag.add(contentsOfBag[i]);
        }
        System.out.println(bag.isEmpty());
        System.out.println(bag.getFrequencyOf("A"));
        System.out.println(bag.contains("D"));
        System.out.println(bag.remove(""));
        System.out.println(Arrays.toString((bag.toArray())));

        System.out.println("Clearing the bag:");
        bag.clear();
        System.out.println(bag.isEmpty());
        System.out.println(Arrays.toString((bag.toArray())));

        // test Assignment methods

        // Union Method
        BagInterface<String> secondBag = new ResizableArrayBag<String>();
        String[] contentsOfSecondBag = { "A", "B", "B" };
        for (int i = 0; i < contentsOfSecondBag.length; i++) {
            secondBag.add(contentsOfSecondBag[i]);
        }

        String[] contentsOfFirstBag = { "B", "C", "D", "E" };
        for (int i = 0; i < contentsOfFirstBag.length; i++) {
            bag.add(contentsOfFirstBag[i]);
        }
        BagInterface<String> everything = bag.union(secondBag);
        System.out.println(Arrays.toString((everything.toArray())));
    }
}
