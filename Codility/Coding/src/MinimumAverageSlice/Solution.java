package MinimumAverageSlice;

class Solution {
    public int solution(int[] A) {
        int N = A.length;
        // Assume the minimum average is very large.
        double minAvg = Double.MAX_VALUE;
        // Initialize the starting position of the slice with the minimal average.
        int minIndex = 0;
        
        // Loop through the array to find the slice with the minimal average.
        for (int i = 0; i < N - 1; i++) {
            // Check slices of length 2.
            if (i < N - 1) {
                double avg2 = (A[i] + A[i + 1]) / 2.0;
                if (avg2 < minAvg) {
                    minAvg = avg2;
                    minIndex = i;
                }
            }
            // Check slices of length 3.
            if (i < N - 2) {
                double avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                if (avg3 < minAvg) {
                    minAvg = avg3;
                    minIndex = i;
                }
            }
        }
        
        // Return the starting position of the slice with the minimal average.
        return minIndex;
    }
}