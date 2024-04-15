package MinMaxDivision;

public class Solution {
    public int solution(int K, int M, int[] A) {
        // Implement your solution here
        int max = 0;
        int min = Integer.MIN_VALUE;
        int mid = 0;
        int bestAnswer = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            max += A[i];
            min = Math.max(min, A[i]);
        }
        while(min<=max){
         
            mid = (max+min)/2;
   
            if(checkBlocks(mid, A)>K){
                min = mid + 1;
            }
            else{
                max = mid - 1;
                if(mid<bestAnswer){
                    bestAnswer = mid;
                }
            }
        }
        return bestAnswer;
    }
    public int checkBlocks(int guess,int[] A){
        int blocks = 1;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
            if(sum>guess){
                sum = A[i];
                blocks++;
            }
        }
        return blocks;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, 5, new int[]{2,1,5,1,2,2,2}));
    }
}
