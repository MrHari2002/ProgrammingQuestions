package PermMissingElem;
import java.util.*;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        if (A.length == 0) {
            return 1;
        }

        ArrayList<Integer> newList = new ArrayList<>();
        for (Integer integer : A) {
            newList.add(integer);
        }
        Collections.sort(newList);
        for (int i = 0; i < newList.size() - 1; i++) {
            if (newList.get(i) + 1 != newList.get(i+1)){
                return newList.get(i) + 1;                
            }
        }
        return newList.get(newList.size()-1)+1 > (A.length + 1)? 1 : newList.get(newList.size()-1)+1;
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] test = new int[]{1};
        System.out.println(s1.solution(test));
    }
}
