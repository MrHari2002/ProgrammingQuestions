package CyclicRotation;

public class Solution {
    public int[] solution(int[] A, int K) {
        // Implement your solution here
        int[] copy = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            copy[(i+K)%A.length] = A[i]; 
        }
        return copy;
    
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] test = new int[]{3, 8, 9, 7, 6};
        s1.solution(test, 3);
    }
}
