package Triangle;
import java.util.*;
public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        ArrayList<Integer> solutionArray = new ArrayList<Integer>();
        for (Integer integer : A) {
            solutionArray.add(integer);
        }
        Collections.sort(solutionArray);
        for (int i = 0; i < solutionArray.size()-2; i++) {
            if(triangle(solutionArray.get(i), solutionArray.get(i+1), solutionArray.get(i+2))){
                return 1;
            }
        }
        return 0;
    }
    public boolean triangle(int A,int B, int C){
        if(A!=0 && B!=0 && C!=0){
        return A+B>C && A+C>B && B+C>A;
        }
        else{return false;}
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] newTest = new int[]{10,2,5,1,8,20};
        System.out.println(s1.solution(newTest));
    }
}
