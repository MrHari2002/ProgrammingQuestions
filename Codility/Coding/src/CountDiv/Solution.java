package CountDiv;
public class Solution {
    public int solution(int A, int B, int K) {
        // Implement your solution here
      int base = (int)Math.ceil((double)A/K);
      int baseTimesK = base * K;
      B = B - baseTimesK;
      int count = (int)Math.floor((double)B/K);
      count++;
        return count;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.solution(0, 0, 11));
    }
}
