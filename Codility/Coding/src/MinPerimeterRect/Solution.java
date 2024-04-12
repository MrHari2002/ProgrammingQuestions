package MinPerimeterRect;

public class Solution {
    public int solution(int N) {
        // Implement your solution here
        
        int minPerimeter = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if(N%i==0){
                int perimeter = 0;
                perimeter = (i+N/i)*2;
                minPerimeter =  Math.min(perimeter, minPerimeter);
            }
        }
        return minPerimeter;
    }
public static void main(String[] args) {
    System.out.println(new Solution().solution(30));
}
}
