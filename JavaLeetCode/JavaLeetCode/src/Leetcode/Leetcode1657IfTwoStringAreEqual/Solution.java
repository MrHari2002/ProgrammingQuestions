package Leetcode.Leetcode1657IfTwoStringAreEqual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean closeStrings(String word1, String word2) {
        //If The Frequence happening is the same

        Map<String,Integer> sequenceMapA = addToMap(word1);
        Map<String,Integer> sequenceMapB = addToMap(word2);

        if(sequenceMapA.keySet().equals(sequenceMapB.keySet())){
            List<Integer> listA = new ArrayList<>(sequenceMapA.values());
            List<Integer> listB = new ArrayList<>(sequenceMapB.values());
            Collections.sort(listA);
            Collections.sort(listB);
            if(listA.equals(listB)){
                return true;
            }
        }

        return false;
    }


    public Map<String,Integer> addToMap(String words){
        Map<String,Integer> sequenceMap = new HashMap<>();
        for(int i = 0; i<words.length(); i++){
            
            if(sequenceMap.containsKey(words.substring(i, i+1))){
                sequenceMap.put(words.substring(i,i+1), sequenceMap.get(words.substring(i,i+1))+1);
            }
            else{
                sequenceMap.put(words.substring(i,i+1), 1);
            }

        }
        return sequenceMap;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        String word1 = "abc";
        String word2 = "bca";
        word1 = "a";
        word2 = "aa";
        word1 = "cabbba";
        word2 = "abbccc";
        System.out.println(s1.closeStrings(word1, word2));
    }
}
