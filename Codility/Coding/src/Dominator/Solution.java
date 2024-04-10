package Dominator;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int size = 0;
        int value = -1;
        for (int i : A) {
            if(size == 0){
                value = i;
                size ++;
            }
            else if(value == i){
                size++;
            }
            else if(value != i){
                size--;
            }
        }
        int leader = -1;
        int counter = 0;
        int leaderIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if(A[i]==value){
                counter++;
                leaderIndex = i;
            }
        }
        if(counter>A.length/2){
            leader = value;
            return leaderIndex;
        }

        return leader;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        
        System.out.println(s1.solution(new int[]{3,4,3,2,3,-1,3,3}));
        
    }
}
