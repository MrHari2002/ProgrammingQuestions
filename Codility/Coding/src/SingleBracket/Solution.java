package SingleBracket;

import java.util.Stack;

public class Solution {
    public int solution(String S) {
        // Implement your solution here
        Stack<Character> stackCharacters = new Stack<>(); 
        char[] sCharArray = S.toCharArray();
        if (sCharArray.length==0) {
            return 1;
        }
        for (char c : sCharArray) {
            if( c == 40){
                stackCharacters.push(c);
            }
            else{
                if(stackCharacters.isEmpty()){
                    return 0;
                }
                else if(stackCharacters.peek() == 40){
                    stackCharacters.pop();
                }
                else{
                    return 0;
                }
            }
        }
        
        if (stackCharacters.size()!=0) {
            return 0;
        }

        return 1;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.solution("())"));
    }
}
