package Chocolate;

public class Solution {
    public int solution(int N, int M) {
        // Implement your solution here
        return N/gcd(N, M,1);
    }

    public int gcd(int a,int b,int res){
        if(a == b){
            return res * a;
        }
        else if ((a % 2 == 0) && (b % 2 == 0)){
            return gcd(a / 2, b / 2, 2 * res);
        }
        else if (a % 2 == 0){
            return gcd(a / 2, b, res);
        }
        else if (b % 2 == 0){
            return gcd(a, b / 2, res);
        }
        else if (a > b){
            return gcd(a- b, b, res);
        }
        else{
            return gcd(a, b- a, res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(10, 4));
    }
}
