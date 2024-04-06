package FrogJumRiver;
import java.util.*;
public class Solution {
    public int solution(int X, int[] A) {
        // Implement your solution here
        HashSet<Integer> setOfLeaves = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            if(A[i]<=X){
                setOfLeaves.add(A[i]);
            }
            if(setOfLeaves.size()==X){
                return i;
            }
        }
        
        return -1;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] test = new int[]{1,3,1,4,2,3,5,4};
        System.out.println(s1.solution(5, test));
    }
}
