package MaximumDoubleSlice;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int[] startMaximumArray = new int[A.length];
        int[] endMaximumArray = new int[A.length];
        int maxAtIStart = 0;
        int maxAtIEnd = 0;
        int max = 0;

        for (int i = 1; i < A.length-1; i++) {
            maxAtIStart = Math.max(A[i],startMaximumArray[i-1]+A[i]);
            startMaximumArray[i] = maxAtIStart;
            if(startMaximumArray[i]<0){
                startMaximumArray[i] =0;
            }
        }
        for (int i = A.length-2; i > 0 ; i--) {
            maxAtIEnd = Math.max(A[i],endMaximumArray[i+1]+A[i]);
            endMaximumArray[i] = maxAtIEnd;
            if(endMaximumArray[i]<0){
                endMaximumArray[i] = 0;
            }
        }
        for (int i = 1; i < A.length-1; i++) {
            max = Math.max(startMaximumArray[i-1] + endMaximumArray[i+1], max);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{0, 10, -5, -2, 0}));
    }
}
