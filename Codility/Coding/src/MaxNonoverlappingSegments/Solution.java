package MaxNonoverlappingSegments;

public class Solution {
    public int solution(int[] A, int[] B) {
        // Implement your solution here
        int segments = 0;
        int currentPosition = -1;
        for (int i = 0; i < A.length; i++) {
            if(A[i]>currentPosition){
                currentPosition = B[i];
                segments++;
            }   
        }
        return segments;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1,3,7,9,9}, new int[]{5,6,8,9,10}));
    }
}
