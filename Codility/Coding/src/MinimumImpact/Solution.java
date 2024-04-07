package MinimumImpact;

public class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        // Implement your solution here
        int[] minimalImpactFatctor = new int[P.length];
        for(int i = 0;i<P.length;i++){
            String word = S.substring(P[i],Q[i]);

            int minimumImpact = 5;
            int impact = 0;

            for(char c:word.toCharArray()){
                if(c == 'A'){
                    impact = 1;
                }
                else if(c == 'G'){
                    impact = 2;
                }
                else if(c == 'T'){
                    impact = 3;
                }
                else{
                    impact = 4;
                }
                if(impact < minimumImpact){
                    minimumImpact = impact;
                }
            }
            minimalImpactFatctor[i] = minimumImpact;
        }
        return minimalImpactFatctor;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        String S = "CAGCCTA";
        int[] P = new int[]{2, 5, 0};
        int[] K = new int[]{4, 5, 6};
        int[] result = s1.solution(S, P, K);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
