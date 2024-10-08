package Peak;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int solution(int[] A) {

        if (A.length < 3) {
            return 0;
        }
        // Implement your solution here
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i]) {
                if (A[i + 1] < A[i]) {
                    peaks.add(i);
                }
            }
        }

        // 3，5，10

        if (peaks.size() == 0) {
            return 0;
        }

        // At least 3 values and at least 1 peak

        for (int blockLength = 3; blockLength <= A.length / 2; blockLength++) {
            if (A.length % blockLength != 0) {
                continue;
            }

            int currentPeak = 0;

            boolean ok = true;

            for (int blockStart = 0; blockStart < A.length; blockStart += blockLength) {
                boolean foundPeak = false;
                while (currentPeak < peaks.size()) {
                    if (peaks.get(currentPeak) < blockStart+blockLength) {
                        foundPeak = true;
                        currentPeak++;
                    } else if(peaks.get(currentPeak)>= blockStart+ blockLength){
                        break;
                    }

                }
                if (!foundPeak) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return A.length / blockLength;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 }));
        System.out.println(new Solution().solution(new int[] { 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1 }));

    }
}
