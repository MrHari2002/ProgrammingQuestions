package Leetcode.DFS.ReorderRoutes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    HashSet<String> edges = new HashSet<>();
    HashMap<Integer, List<Integer>> neighbors = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    Integer result = 0;

    public int minReorder(int n, int[][] connections) {
        for(int i = 0; i< connections.length;i++){
            edges.add(connections[i][0]+" "+connections[i][1]);
        } 


        for(int i = 0; i< connections.length; i++){
            if(neighbors.containsKey(connections[i][0])){
                List<Integer> newList = neighbors.get(connections[i][0]);
                newList.add(connections[i][1]);
                neighbors.put(connections[i][0], newList);
            }
            else{
                List<Integer> newList1 = new ArrayList<>();
                newList1.add(connections[i][1]);
                neighbors.put(connections[i][0], newList1);
            }

            if(neighbors.containsKey(connections[i][1])){
                List<Integer> newList = neighbors.get(connections[i][1]);
                newList.add(connections[i][0]);
                neighbors.put(connections[i][1], newList);
            }
            else{

                List<Integer> newList2 = new ArrayList<>();
                newList2.add(connections[i][0]);
                neighbors.put(connections[i][1], newList2);
            }

        }
        
        visited.add(0);
        dfs(0);


        return result;
    }

    public void dfs(Integer city){
        if(neighbors.get(city).size()!=0){
            for(Integer i:neighbors.get(city)){
                if(visited.contains(i)){
                    continue;
                }
                if(!edges.contains(i+" "+city)){
                    result++;
                }
                visited.add(i);
                dfs(i);
            }

        }
    }

    public static void main(String[] args) {
        Solution s1 =new Solution();
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int[][] connections1 = {{1,0},{2,0}};

        System.out.println(s1.minReorder(0, connections1));
    }
}
