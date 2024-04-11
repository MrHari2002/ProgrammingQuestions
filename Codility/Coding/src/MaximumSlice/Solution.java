package MaximumSlice;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        long maximumEnd = Integer.MIN_VALUE;
        long maximumSlice =Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            maximumEnd = Math.max(A[i], maximumEnd+A[i]);
            maximumSlice = Math.max(maximumEnd,maximumSlice);
        }
        return (int)maximumSlice;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{3,2,-6,4,0}));
        System.out.println(new Solution().solution(new int[]{-3,-2,-6,-4,-1}));

    }
}
