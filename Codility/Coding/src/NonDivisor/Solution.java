 package NonDivisor;

import java.util.HashMap;

public class Solution {
    public int[] solution(int[] A){
        HashMap<Integer,Integer> countMap = new HashMap<Integer,Integer>();
        for (int i : A) {
            if(countMap.containsKey(i)){
                countMap.put(i, countMap.get(i)+1);
            }
            else{
                countMap.put(i, 1);
            }
        }
        HashMap<Integer,Integer> divisorCountMap = new HashMap<Integer,Integer>();
        for(int N:countMap.keySet()){
            int result = 0;
            for (int i = 1; i <= Math.sqrt(N); i++) {
                if(N%i==0){
                    if(i<Math.sqrt(N)){
                        if(countMap.containsKey(i)){
                            result+=countMap.get(i);
                        }
                        if(countMap.containsKey(N/i)){
                            result+=countMap.get(N/i);
                        }
                    }
                    else if(countMap.containsKey(i)){
                        result+=countMap.get(i);
                    }
                }
            }
            divisorCountMap.put(N, result);
        }
        int[] nonDivisorCount = new int[A.length];
        for (int i = 0;i< A.length;i++) {
            nonDivisorCount[i] = A.length-divisorCountMap.get(A[i]);
        }
        return nonDivisorCount;
    }
    public static void main(String[] args) {
//        int[] result = (new Solution().solution(new int[]{3,1,2,3,6}));
        int[] result = (new Solution().solution(new int[]{3,4}));

        for (int i : result) {
            System.out.println(i);
        }
    }
}
