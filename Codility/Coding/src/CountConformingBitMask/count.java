package CountConformingBitMask;

import java.util.ArrayList;
import java.util.List;

public class count {
    public int solution(int A,int B,int C){
        String aString = Integer.toBinaryString(A);
        String bString = Integer.toBinaryString(B);
        String cString = Integer.toBinaryString(C);

        String[] stringList = rephase(aString, bString, cString);
        List<String> permutations = generatePermutations(stringList[0].length());
        int numMatched = 0;
        for (String string : permutations) {
            boolean aMatch = match(stringList[0],string);
            boolean bMatch = match(stringList[1],string);
            boolean cMatch = match(stringList[2],string);
            boolean matched = aMatch | bMatch | cMatch;
            numMatched += matched? 1:0;
        }
        return numMatched;
    }

    public boolean match(String matchString, String testString){
        boolean matched = true;
        for (int i = 0; i < matchString.length(); i++) {
                if(matchString.charAt(i) == '1'){
                    if(testString.charAt(i) != '1'){
                        return false;
                    }
                }
        }
        return matched;
    }

    public List<String> generatePermutations(int length) {
        List<String> result = new ArrayList<>();
        generatePermutationsRecursive("", length, result);
        return result;
    }

    private void generatePermutationsRecursive(String current, int length, List<String> result) {
        if (current.length() == length) {
            result.add(current);
            return;
        }
        generatePermutationsRecursive(current + "0", length, result);
        generatePermutationsRecursive(current + "1", length, result);
    }

    public String[] rephase (String A,String B,String C){
        String[] rephaseStrings = new String[3];
        StringBuilder resultA = new StringBuilder();
        StringBuilder resultB = new StringBuilder();
        StringBuilder resultC = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char charA = A.charAt(i);
            char charB = B.charAt(i);
            char charC = C.charAt(i);
            if (!(charA == '1' && charB == '1' && charC == '1')) {
                resultA.append(charA);
                resultB.append(charB);
                resultC.append(charC);
            }
        }
        rephaseStrings[0] = resultA.toString();
        rephaseStrings[1] = resultB.toString();
        rephaseStrings[2] = resultC.toString();

        return rephaseStrings;
    }


   

public static void main(String[] args) {
    count c1 = new count();
    System.out.println(c1.solution(1073741727, 1073741631, 1073741679));
}    

}

