import java.util.*;

public class UniqueSetCollection {
    public static void main(String[] args) {
        Set<Set<Integer>> uniqueSets = new HashSet<>();

        // Convert lists into sets
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 0, -1));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(0, 1, -1));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(2, 3, 4)); // A different set

        // Add the first set
        uniqueSets.add(set1);

        // Check if set2 exists before adding it
        if (uniqueSets.contains(set2)) {
            System.out.println("Duplicate set detected: " + set2);
        } else {
            uniqueSets.add(set2);
        }

        // Adding a different set
        if (!uniqueSets.contains(set3)) {
            uniqueSets.add(set3);
        }

        // Print unique sets
        System.out.println("Unique Sets: " + uniqueSets);
    }
}
