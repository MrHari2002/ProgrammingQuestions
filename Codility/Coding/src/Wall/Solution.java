package Wall;

import java.util.Stack;

public class Solution {
    public int solution(int[] H) {
        // Implement your solution here
        Stack<Integer> remainingSquareStack = new Stack<>();
        int counter = 0;
        for (int i = 0; i < H.length; i++) {
            while (!remainingSquareStack.isEmpty() && remainingSquareStack.peek()>H[i]) {
                remainingSquareStack.pop();
            }
            if(!remainingSquareStack.isEmpty()&&remainingSquareStack.peek()==H[i]){

            }
            else{
                counter++;
                remainingSquareStack.push(H[i]);
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{8,8,5,7,9,8,7,4,8}));
    }
}
