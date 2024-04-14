package SemiPrimes;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int N, int[] P, int[] Q) {
        // Implement your solution here
        boolean[] notPrime = new boolean[N];
        for(int i = 2; i < N/2; i++){
            for(int j = i*2;j < N; j+=i){
                notPrime[j] = true;
            }
        }

        ArrayList<Integer> primeList = new ArrayList<Integer>();
        for (int i = 0; i<notPrime.length;i++) {
            if(!notPrime[i]){
                primeList.add(i);
            }
        }

        int[] aggregatedSemiPrime = new int[N+1];
        for (int i = 2; i<primeList.size();i++){
            for(int j = i; j<primeList.size();j++){
                
                int iPrime = primeList.get(i);
                int jPrime = primeList.get(j);
                if((long)iPrime*jPrime>N+1){
                    break;
                }
                aggregatedSemiPrime[iPrime*jPrime] = 1;
            }
        }

        int c = 0;
        for (int i = 0; i < aggregatedSemiPrime.length; i++) {
            c += aggregatedSemiPrime[i];
            aggregatedSemiPrime[i] = c;
        }

        int[] resultArray = new int[P.length];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = aggregatedSemiPrime[Q[i]]-aggregatedSemiPrime[P[i] - 1 ];
        }

        return resultArray;
    }
    public static void main(String[] args) {
        
        int[] result = new Solution().solution(26, new int[]{1,4,16}, new int[]{26,10,20});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
