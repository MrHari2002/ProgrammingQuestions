package OddOccurrencesInArray;
import java.util.HashMap; // import the HashMap class

public class Solution {
    public int solution(int[] A) {
        
        // Implement your solution here
        HashMap<Integer,Integer> wordMap = new HashMap<Integer,Integer>();
        for (int i : A) {
            //if it is not in the hashmap
            if(!wordMap.containsKey(i)){
                wordMap.put(i, 1);
            }
            else{
               wordMap.put(i, wordMap.get(i) + 1);
            }
        }

        for (int key : wordMap.keySet()) {
            if(wordMap.get(key)%2 == 1){
                return key;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] test = new int[]{9,3,9,3,9,7,9};
        s1.solution(test);
        System.out.println(        s1.solution(test)        );
    }
}
