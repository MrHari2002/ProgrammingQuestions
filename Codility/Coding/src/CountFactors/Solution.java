package CountFactors;

public class Solution {
    public int solution(int N) {
        // Implement your solution here
        int result = 0;
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if(N%i==0){
                if(i<Math.sqrt(N)){
                    result+=2;
                }
                else{
                    result++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().solution(24));
    } 
}
