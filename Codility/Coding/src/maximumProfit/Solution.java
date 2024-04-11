package maximumProfit;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        
        if(A.length<2){
            return 0;
        }

        int maximumProfit = 0;
        int maximumSlice = 0;


        for (int i = 1;i<A.length;i++) {
            int profit = A[i] - A[i-1];
            maximumProfit = Math.max(0, maximumProfit+profit);
            maximumSlice = Math.max(maximumProfit, maximumSlice);
        }
        return maximumSlice;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.solution(new int[]{23171,21011,21123,21366,21013,21367}));
    }
}
