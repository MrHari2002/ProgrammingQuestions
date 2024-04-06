package FrogJMP;

public class Solution {
    public int solution(int X, int Y, int D) {
        // Implement your solution here
        
        return ((Y-X)% D == 0)?(Y - X) / D : ((Y-X)/D)+1;
    }
}
