package Leetcode.DecodeString;

import java.util.Stack;

public class Solution {

    public String decodeString(String s){
        char[] charArray = s.toCharArray();
        Stack<Character> charStacks = new Stack<>();
        for(Character c:charArray){
            // if c != "]"
            if(c!=93){
                charStacks.add(c);
            }
            else{
                String subString = "";
                //if c! = "["
                while(charStacks.peek()!=91){
                    subString = charStacks.pop()+subString;
                }
                charStacks.pop();
                String k = "";
                while(!charStacks.isEmpty() && Character.isDigit(charStacks.peek())){
                    k = charStacks.pop() +k;
                }
                
                int numberOfTimes = Integer.parseInt(k);

                for(int i = 0; i< numberOfTimes;i++){
                    for(Character b :subString.toCharArray()){
                        charStacks.add(b);
                    }
                }

            }
        }

        String answer = "";
        while(!charStacks.isEmpty()){
            answer = charStacks.pop()+answer;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        String answer = s1.decodeString("100[leetcode]");
        System.out.println(answer);
    }
    
}