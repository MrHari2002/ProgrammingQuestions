package Leetcode.DecodeString;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        char[] charArray = s.toCharArray();
        Stack<Integer> intStack = new Stack<>();
        String curString = "";
        Stack<String> stringStack = new Stack<>(); 
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        boolean addMode = false;

        while(counter<charArray.length){


            Character c = charArray[counter];
            if(Character.isDigit(c)){
                Integer cInt = c - '0';
                intStack.push(cInt);
                counter++;
            }

            else if(c == 91){
                addMode = true;
                counter++;
            }

            else if(c == 93){
                if(!intStack.isEmpty()){
                    int popped = intStack.pop();
                    String stackNow = stringStack.pop();
                    for(int i = 0;i<popped;i++){
                        sb.append(stackNow);
                    }
                }
                curString = "";
                stringStack.push(curString);
                counter++;
                addMode = false;
            }

            else if(addMode){
                curString += c.toString();
                counter++;
            }





        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String test1 = "3[a]2[bc]";
        String test2 = "3[a2[c]]";
        Solution s1 = new Solution();
        System.out.println(s1.decodeString(test2));
    }
}
