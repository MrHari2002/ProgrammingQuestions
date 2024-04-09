package MaxOfThree;
import java.util.*;
public class Solution {
    public int solution(int[] A) {
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        for (Integer integer : A) {
            sortedList.add(integer);
        }
        Collections.sort(sortedList);
        
        int maximum = 0;
        
        int maximumPositive = sortedList.get(sortedList.size()-1) * sortedList.get(sortedList.size()-2) * sortedList.get(sortedList.size()-3);
        
        int maximumNegative = sortedList.get(0) * sortedList.get(1) * sortedList.get(sortedList.size()-1);
        
        return Math.max(maximumPositive, maximumNegative);
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        // int[] test = new int[]{-3,1,2,-2,5,6};
        // System.out.println(s1.solution(test));

        int[] test1 = new int[]{-100,-0,2,-2,5,6};
        System.out.println(s1.solution(test1));

        
        int[] test2 = new int[]{-100,-10,0,1};
        System.out.println(s1.solution(test2));
    }
}
