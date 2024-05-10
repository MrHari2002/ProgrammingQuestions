package Leetcode.removingStarsFromAString;

import java.util.Stack;

public class Solution {
    public String removeStars(String s) {
        Stack<String> sStack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.substring(i, i+1).equals("*")){
                if(!sStack.empty()){
                    sStack.pop();
                }
            }
            else{
                sStack.push(s.substring(i, i+1));
            }
        }
        
        String newS = "";
        while(!sStack.isEmpty()){
            newS = sStack.pop()+newS;
        }
        return newS;
    }
    public static void main(String[] args) {
        //System.out.println(new Solution().removeStars("leet**cod*e"));
        
        System.out.println(new Solution().removeStars("erase*****"));

    }
}
