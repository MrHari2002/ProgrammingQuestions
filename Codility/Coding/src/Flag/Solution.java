package Flag;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        List<Integer> flagArray = new ArrayList<Integer>();
        
        for (int i = 1; i < A.length-1; i++) {
            if(A[i]>A[i-1] && A[i]>A[i+1]){
               flagArray.add(i); 
            }
        }
        if(flagArray.isEmpty()){
            return 0;
        }
        if(flagArray.size() == 1){
            return 1;
        } 



        int totalDistance = flagArray.get(flagArray.size()-1)-flagArray.get(0);
        int maximumFlags = (int)Math.sqrt(totalDistance);
        int flagsPlaced = 2;
        int leftIndex = 0;
        int rightIndex = flagArray.size()-1;
        int startFlag = flagArray.get(leftIndex);
        int endFlag = flagArray.get(rightIndex);
        for (int i = maximumFlags; i > 1; i--) {
            while (leftIndex<rightIndex) {
                leftIndex++;
                rightIndex--;
                if(flagArray.get(leftIndex)>=startFlag+i){
                    if(flagArray.get(leftIndex)<=endFlag-i){
                        flagsPlaced++;
                        startFlag = flagArray.get(leftIndex);
                    }
                }

                if(flagArray.get(rightIndex)>=startFlag+i){
                    if(flagArray.get(leftIndex)<=endFlag-i){
                        flagsPlaced++;
                        endFlag = flagArray.get(rightIndex);
                    }
                }
                if(flagsPlaced == i){
                    return i;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
    System.out.println(new Solution().solution(new int[]{0, 0, 0, 0, 0, 1, 0, 1, 0, 1}));
    //  System.out.println(new Solution().solution(new int[]{1,5,3,4,3,4,1,2,3,4,6,2}));

    }
}
