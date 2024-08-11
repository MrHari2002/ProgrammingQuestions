package Leetcode.KeysAndRooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
        Set<Integer> visited = new HashSet<>();

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            dfs(0, rooms);
        return visited.size() == rooms.size();
    }

        public void dfs(Integer room,List<List<Integer>> rooms){
            visited.add(room);
            for(Integer i: rooms.get(room)){
                if(!visited.contains(i)){
                    dfs(i, rooms);
                }
            }
        }

        public static void main(String[] args) {
        Solution s1 = new Solution();
        List<List<Integer>> rooms = new ArrayList<>();
        
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));        

        System.out.println(s1.canVisitAllRooms(rooms));
        
    }
        
}
