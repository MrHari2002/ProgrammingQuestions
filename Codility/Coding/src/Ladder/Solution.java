package Ladder;

public class Solution {
    public int[] solution(int[] A, int[] B) {
        // Implement your solution here
        int[] fibs = new int[A.length+1];
        fibs[0] = 1;
        fibs[1] = 1;
        for(int i = 2;i<fibs.length;i++){
            fibs[i] = (fibs[i-2]+fibs[i-1])% (int)Math.pow(2, 30);
        }

        int[] result = new int[A.length];
        for(int i = 0;i<result.length;i++){
            int m = (int)Math.pow(2, B[i]);
            result[i] = fibs[A[i]] % m;
        }

        return result;
    }
    public static void main(String[] args) {
        int[] result = new Solution().solution(new int[]{4,4,5,5,1}, new int[]{3,2,4,3,1});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
