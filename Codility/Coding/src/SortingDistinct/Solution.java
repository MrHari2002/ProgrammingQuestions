import java.util.*;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        HashSet<Integer> aMap = new HashSet<Integer>();
        for (int i : A) {
            aMap.add(i);
        }
        return aMap.size();
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] test = new int[]{2,1,1,2,3,1};
        System.out.println(s1.solution(test));
    }
}
