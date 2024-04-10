package Fish;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int solution(int[] A, int[] B) {
        // Implement your solution here
        Stack<Integer> oneDirectionFishes = new Stack<>();
        int survivalZeroFishes = 0;
        for (int i = 0; i < B.length; i++) {
            if(B[i] == 1){
                oneDirectionFishes.push(A[i]);
            }
            else{
                boolean survived = true;
                while(!oneDirectionFishes.isEmpty()){
                    if(A[i]<oneDirectionFishes.peek()){
                        survived = false;
                        break;
                    }
                    else{
                        oneDirectionFishes.pop();
                    }
                }
                if(survived){
                    survivalZeroFishes ++;
                }
            }
        }
        return oneDirectionFishes.size()+survivalZeroFishes;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        
        System.out.println(s1.solution(new int[]{4,3,2,1,5}, new int[]{0,1,0,0,0}));
    }
}
