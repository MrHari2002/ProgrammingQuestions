package AbsDistinct;
import java.util.*;
public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int counter = 0;

        HashSet<Long> wordSet = new HashSet<>();

        for (int i : A) {
            if(wordSet.add(Math.abs((long)i))){
                counter++;
            }            
        }

        return counter;
    }
    public static void main(String[] args) {
        
    }
}
