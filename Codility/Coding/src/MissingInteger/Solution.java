package MissingInteger;

import java.util.HashSet;

public class Solution {
    public int solution(int[] A) {
    HashSet<Integer> numSet = new HashSet<Integer>();
    for (int i = 1; i <= A.length+1; i++) {
        numSet.add(i);
    }
    for (Integer integer : A) {
        numSet.remove(integer);
    }
    return numSet.iterator().next();
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] test = new int[]{1,3,6,4,1,2};
        System.out.println(s1.solution(test));
     
    }
}
