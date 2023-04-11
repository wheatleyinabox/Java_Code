package Assignment_1;
import java.util.Arrays;

public class LinkedBagTest 
{
    public static void main(String[] args)
    {
        // test BagInterface methods

        System.out.println("Creating an empty bag.");
        BagInterface<String> aBag = new LinkedBag<>();
        System.out.println(Arrays.toString((aBag.toArray())));
        System.out.println(aBag.isEmpty());

        String[] testStrings1 = {"", "B"};
        for (int i = 0; i < testStrings1.length; i++)
        {
            aBag.add(testStrings1[i]);
        }
        System.out.println(aBag.getFrequencyOf(""));
        System.out.println(aBag.contains("B"));
        System.out.println(aBag.remove(""));
        System.out.println(Arrays.toString((aBag.toArray())));
        aBag.clear();

        String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D", ""};
        for (int i = 0; i < contentsOfBag.length; i++)
        {
            aBag.add(contentsOfBag[i]);
        }
        System.out.println(aBag.isEmpty());
        System.out.println(aBag.getFrequencyOf("A"));
        System.out.println(aBag.contains("D"));
        System.out.println(aBag.remove(""));
        System.out.println(Arrays.toString((aBag.toArray())));

        System.out.println("Clearing the bag:");
        aBag.clear();
        System.out.println(aBag.isEmpty());
        System.out.println(Arrays.toString((aBag.toArray())));

        // test Assignment methods
    }
}