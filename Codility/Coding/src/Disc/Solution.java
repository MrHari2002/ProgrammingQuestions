package Disc;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        long[] startArray = new long[A.length];
        // initializing the startArray
        for (int i = 0; i < A.length; i++) {
            long startPos = (long)i - A[i];
            startPos = startPos<0? startPos = 0l: startPos;
            startArray[(int) startPos]++;
        }
        // total addition to populate the start array
       for (int i = 1; i < startArray.length; i++) {
            startArray[i] = startArray[i-1] + startArray[i];
        }
        // After total we calculate the number of intersections
        int totalIntersections = 0;
        for (long i = 0; i < startArray.length; i++) {
            long radius = A[(int) i];
            long endPos = i + radius;
            if(endPos > startArray.length - 1){
                endPos = startArray.length-1;
            }
            long intersections = startArray[(int) endPos] - i - 1;
            totalIntersections += intersections;
        }
        totalIntersections = totalIntersections > 10000000? -1:totalIntersections;
        return totalIntersections;

    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] test = new int[]{1,5,2,1,4,0};
        System.out.println(s1.solution(test));
    }
}
