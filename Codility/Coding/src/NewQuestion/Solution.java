package NewQuestion;

public class Solution{
    public void solution(int N) {
        int enable_print = N % 10 == 0 ? 0 : 1;
        while (N > 0) {
            if (enable_print == 1) {
                System.out.println(N % 10);
            }
            N = N / 10;
            enable_print = (N % 10 != 0 || enable_print == 1) ? 1 : 0;
        }
    }
    public static void main(String[] args) {
       new Solution().solution(100); 
    }
}