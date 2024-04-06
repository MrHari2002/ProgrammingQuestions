package TapeEquilibruim;

public class Solution {
    public int solution(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        int minimal = 999999999;
        int currentRightSum = sum;
        int currentLeftSum = 0;

        for (int i = 0; i < A.length-1; i++) {
            currentLeftSum+=A[i];
            currentRightSum-=A[i];;
            int absouluteDiff = currentRightSum>currentLeftSum? currentRightSum-currentLeftSum: currentLeftSum-currentRightSum; 
            if(absouluteDiff<minimal){
                minimal = absouluteDiff;
            }
        }
        // Implement your solution here
        return minimal;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] test = new int[]{-1000,1000};
        System.out.println(s1.solution(test));
    }
}
