package CountConformingBitMask;

import java.util.ArrayList;
import java.util.List;

public class BinaryPermutations {

    public static void main(String[] args) {
        int length = 4; // Example length
        List<String> permutations = generatePermutations(length);
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }

    public static List<String> generatePermutations(int length) {
        List<String> result = new ArrayList<>();
        generatePermutationsRecursive("", length, result);
        return result;
    }

    private static void generatePermutationsRecursive(String current, int length, List<String> result) {
        if (current.length() == length) {
            result.add(current);
            return;
        }
        generatePermutationsRecursive(current + "0", length, result);
        generatePermutationsRecursive(current + "1", length, result);
    }
}
