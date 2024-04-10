package Brackets;
// you can also use imports, for example:
// import java.util.*;


import java.util.Stack;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // Implement your solution here
        Stack<Character> openBracketStack = new Stack<Character>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c == 40||c == 91||c == 123){
                openBracketStack.add(c);
            }
            else{
                if(openBracketStack.empty()){
                    return 0;
                }
                char popped = openBracketStack.pop();
                if(!(c-popped==1 || c-popped==2)){
                    return 0;
                }
            }
        }
        if(!openBracketStack.isEmpty()){
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        String test = "{[()()]}";
        System.out.println(s1.solution(test));
    }
}
