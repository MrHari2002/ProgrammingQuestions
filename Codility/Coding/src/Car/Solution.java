package Car;

import java.util.ArrayList;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        // How many 0 cars one is going to counter
        ArrayList<Integer> oneCarsCounterList = new ArrayList<Integer>();
        int carCount = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]==0){
                carCount+=1;
            }
            else{
                oneCarsCounterList.add(carCount);
            }
        }
        int sum = 0;
        for (Integer integer : oneCarsCounterList) {
            if(sum >1000000000){
                return -1;
            }
            sum += integer;
        }
        return sum;
    }
}
