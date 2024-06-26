package Leetcode.DotaSenate;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String predictPartyVictory(String senate) {
        char[] charArray = senate.toCharArray();
        Deque<Integer> RQueue = new ArrayDeque<>();
        Deque<Integer> DQueue = new ArrayDeque<>();

        for (int i = 0; i<charArray.length;i++) {
            if(charArray[i] == 'R'){
                RQueue.add(i);
            }
            else{
                DQueue.add(i);
            }    
        }

        while (!DQueue.isEmpty() && !RQueue.isEmpty()) {
            int r = RQueue.poll();
            int q = DQueue.poll();
            if(r<q){
                RQueue.add(r+charArray.length);
            }
            else{
                DQueue.add(q+charArray.length);
            }
        }

        if(DQueue.isEmpty()){
            return "Radiant";
        }
        else{
            return "Dire";
        }
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.predictPartyVictory("RDD"));
    }
}
