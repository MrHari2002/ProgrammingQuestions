package Permutation;
import java.util.*;
public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        HashSet<Integer> setOfA = new HashSet<Integer>();
        for(int i = 0; i<A.length;i++){
            if(!setOfA.add(A[i])){
                return 0;
            }
        }
        ArrayList<Integer> newList = new ArrayList<>(setOfA);
        Collections.sort(newList);
        for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i) != i+1){
                return 0;                
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] test =  new int[]{4,1,3,2};
        System.out.println(s1.solution(test));
        test =  new int[]{1};
        System.out.println(s1.solution(test));
    }
}
