package MinimumImpact;

public class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
       //first part fill the prefix array
       int[][] counterArray = new int[4][S.length()+1];
       int countA = 0;
       int countC = 0;
       int countG = 0;
       int countT = 0;
              
       for (int i = 0; i < counterArray.length; i++) {
            for (int j = 0; j < S.length(); j++) {
                if(i == 0){
                    if(S.charAt(j) == 'A'){
                        countA += 1;
                    };
                    counterArray[i][j+1] = countA;  
                }
                else if(i == 1){
                    if(S.charAt(j) == 'C'){
                        countC += 1;
                    };
                    counterArray[i][j+1] = countC;  

                }         
                else if(i == 2){
                    if(S.charAt(j) == 'G'){
                        countG += 1;

                    };
                    counterArray[i][j+1] = countG;  

                }     
                else{
                    if(S.charAt(j) == 'T'){
                        countT += 1;

                    };
                    counterArray[i][j+1] = countT;  
                }
            }
       }

    //Part 2 Fill The result Area;
    int[] result = new int[P.length];

       for (int i = 0; i < result.length; i++) {
            int minimum = 4;
            for (int j = 0; j < 4; j++) {
                //if we have found a match
                if(counterArray[j][P[i]]!=counterArray[j][Q[i]+1]){
                    minimum = j + 1;
                    break;
                }
            }
            result[i] = minimum;

       }

       return result;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        String S = "CAGCCTA";
        int[] P = new int[]{2, 5, 0};
        int[] Q = new int[]{4, 5, 6};
        int[] result = s1.solution(S, P, Q);
        for (int i : result) {
            System.out.println(i);
        }


        System.out.println("new test");

        S = "A";
        P = new int[]{0};
        Q = new int[]{0};
        result = s1.solution(S, P, Q);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
