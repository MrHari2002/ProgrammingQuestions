package DominatorLeader;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int size = 0;
        int value = -1;
        for (int i : A) {
            if(size == 0){
                value = i;
                size ++;
            }
            else if(value == i){
                size++;
            }
            else if(value != i){
                size--;
            }
        }
        int leader = -1;
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]==value){
                counter++;
            }
        }
        if(counter>A.length/2){
            leader = value;
        }

        int leadersInTheRight = counter;
        int leadersInTheLeft = 0;
        int countLeftSide = 0;
        int countRightSide = A.length;
        int equiPoints = 0;

        for (int i = 0; i < A.length; i++) {
            countLeftSide++;
            countRightSide--;
            if(A[i] == leader){
                leadersInTheLeft++;
                leadersInTheRight--;
            }            

            if(leadersInTheLeft > countLeftSide/2){
                if(leadersInTheRight > countRightSide/2){
                    equiPoints++;
                }
            }
        }

        return equiPoints;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.solution(new int[]{4,3,4,4,4,2}));
    }
}
