package Leetcode.AsteroidCollision;

import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> intStack = new Stack<>();
        for(int i:asteroids){
           if(intStack.isEmpty()){
            intStack.push(i);
           }
           else{
                boolean equal = false;
                boolean small = false;
                while(!intStack.isEmpty()&&intStack.peek()>0 && i<0){
                    if(Math.abs(intStack.peek())<Math.abs(i)){
                        intStack.pop();
                    }
                    else if(Math.abs(intStack.peek())==Math.abs(i)){
                        equal = true;
                        intStack.pop();
                        break;
                    }
                    else{
                        small = true;
                        break;
                    }
                }
                if(!equal&&!small){
                    intStack.push(i);
                }
           }
        }

        int[] newArray = new int[intStack.size()];
        int counter = 0;
        while(!intStack.isEmpty()){
            newArray[newArray.length-counter-1] = intStack.pop();
            counter++;
        }
        return newArray;
    }
    public static void main(String[] args) {
        int[] asteroids = {1,-2,-2,-2};
        Solution s1 = new Solution();
        System.out.println(s1.asteroidCollision(asteroids));
    }
}
