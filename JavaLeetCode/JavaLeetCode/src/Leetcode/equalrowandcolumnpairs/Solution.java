package Leetcode.equalrowandcolumnpairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<int[],Integer> colMap = new HashMap<>();
        HashMap<int[],Integer> rowMap = new HashMap<>();
        for(int i = 0;i<grid.length;i++){
            rowMap.put(grid[i],i);
        }

        for(int i = 0;i<grid[0].length;i++){
            int[] colArray = new int[grid[0].length];
            for(int j = 0; j<grid.length;j++){
                colArray[j] = grid[j][i];
            }
            colMap.put(colArray, i);
        }
        int counter = 0;
        for(Entry<int[],Integer> rowEntry:rowMap.entrySet()){
            for(Entry<int[],Integer> colEntry:colMap.entrySet()){
                if(Arrays.equals(rowEntry.getKey(), colEntry.getKey())){
                    counter++;
                }
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        int[][] grid = new int[][]{{3,2,1},{1,7,6},{2,7,7}};
        int[][] newGrid = new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        
        Solution s1 = new Solution();
        System.out.println(s1.equalPairs(newGrid));
    }
}
