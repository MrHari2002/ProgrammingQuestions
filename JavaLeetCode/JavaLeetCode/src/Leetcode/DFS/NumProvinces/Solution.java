package Leetcode.DFS.NumProvinces;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<Integer> visited = new HashSet<>();

    public int findCircleNum(int[][] isConnected) {
        int numberOfProvinces = 0;
        for(int i = 0; i< isConnected.length;i++){
            if(!visited.contains(i)){
                numberOfProvinces++;
                dfs(i,isConnected);
            }
        }    
        return numberOfProvinces;
    }

    private void dfs(int i, int[][] isConnected){
        visited.add(i);
        for(int j = 0; j< isConnected[i].length;j++){
            if(!visited.contains(j) && isConnected[i][j] == 1){
                dfs(j, isConnected);
            }
        }
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(s1.findCircleNum(isConnected));        
    }
}