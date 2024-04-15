package NumberSolitaire;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int[] bestResult = new int[A.length];
        for (int i = 0; i < bestResult.length; i++) {
            if(i == 0){
                bestResult[i] = A[i];
            }
            else{
                int maxOnTheSquares = Integer.MIN_VALUE;
                for(int j = 1;j<=6;j++){
                    if(i-j>=0){
                        maxOnTheSquares = Math.max(maxOnTheSquares, bestResult[i-j]+A[i]);
                    }
                }
                bestResult[i] = maxOnTheSquares;
            }
        }
        return bestResult[A.length-1];
    }
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1,-2,0,9,-1,-2}));
    }
}
