package BinaryGap;

import java.util.ArrayList;
import java.util.List;

public class BinaryGap {
    public int binaryGap(int N) {
        List<Integer> binaryList = binaryNumber(N);
        int bestZeroCounts = 0;
        int zeroCounts = 0;
        boolean startCount = false;
            for (int i = 0; i < binaryList.size(); i++) {
                
                if(binaryList.get(i) == 0 && startCount){
                    zeroCounts +=1;
                }
                else if(binaryList.get(i)== 1){
                    startCount = true;
                    if (zeroCounts >bestZeroCounts){
                        bestZeroCounts = zeroCounts;
                    }
                    zeroCounts = 0;
                }
    
            }
            return bestZeroCounts;
        // Implement your solution here
    }
    public List<Integer> binaryNumber(int N){
        List<Integer> binaryList = new ArrayList<Integer>();
        if(N==0){
            binaryList.add(0);
        }
        while (N > 0) {
            binaryList.add(N % 2);
            N = N/2;
        }
        return binaryList;
    }
    public static void main(String[] args) {
        BinaryGap b1 = new BinaryGap();
        System.out.println(b1.binaryGap(32));
    }
}
