package MaxCounter;

public class Solution {
    public int[] solution(int N, int[] A) {
        // Implement your solution here
        int[] newArray = new int[N];
        
        for (int i = 0; i<newArray.length;i++) {
            newArray[i] = 0;
        }

        int minValue = 0;
        int maxCounter = 0;
        for(int i = 0; i<A.length;i++){
            
            if(A[i]<=N && A[i]>=0){
                //Increment Operation
                newArray[A[i]-1] = Math.max(minValue+1,newArray[A[i]-1]+1);        
                if(newArray[A[i]-1]>maxCounter){
                    maxCounter = newArray[A[i]-1];
                }

            }
            else if(A[i] == N+1){
                minValue = maxCounter;
            }
        }
        for (int i = 0; i<newArray.length;i++) {
            newArray[i] = Math.max(minValue, newArray[i]);
        }
        return newArray;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] test = new int[]{3,4,4,6,1,4,4};
        int[] result = s1.solution(5, test);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
