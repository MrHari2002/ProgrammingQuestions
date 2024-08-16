import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.management.Query;

import java.util.Deque;

class Solution {

    HashMap<String, List<Tuple>> adjMap = new HashMap<>(); 

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Create an adjacency list for the Hashmap String, List<Tuple> 
        for (int i = 0; i < equations.size(); i++) {
            //If there is no hashmap for a we build one

            //Case A -> B (B, values of A / B)
            if(!adjMap.containsKey(equations.get(i).get(0))){
                Tuple tuple = new Tuple(equations.get(i).get(1), values[i]);
                List<Tuple> tuples = new ArrayList<>();
                tuples.add(tuple);
                adjMap.put(equations.get(i).get(0), tuples);
            }
            else{
                Tuple tuple = new Tuple(equations.get(i).get(1), values[i]);
                List<Tuple> tuples = adjMap.get(equations.get(i).get(0));
                tuples.add(tuple);
                adjMap.put(equations.get(i).get(0), tuples);
            }

            //Case B -> A (A, values of B / A)
            if(!adjMap.containsKey(equations.get(i).get(1))){
                Tuple tuple = new Tuple(equations.get(i).get(0), 1/values[i]);
                List<Tuple> tuples = new ArrayList<>();
                tuples.add(tuple);
                adjMap.put(equations.get(i).get(1), tuples);
            }
            else{
                Tuple tuple = new Tuple(equations.get(i).get(0), 1/values[i]);
                List<Tuple> tuples = adjMap.get(equations.get(i).get(1));
                tuples.add(tuple);
                adjMap.put(equations.get(i).get(1), tuples);
            }
        }

        //Return Sections
        double[] returnArray = new double[queries.size()];
        int i = 0;
        for(List<String> query:queries){
            returnArray[i] = bfs(query.get(0), query.get(1));
            i++;
        }

        return returnArray;
    }

    public double bfs(String src, String target){
        if(!adjMap.containsKey(src) || !adjMap.containsKey(target)){
            return -1;
        }
        Deque<Tuple> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new Tuple(src, 1));
        visited.add(src);
        while(!q.isEmpty()){
            Tuple popped = q.pop();
            String n = popped.getLetter();
            Double w = popped.getValues();
            if(n.equals(target)){
                return w;
            }
            for(Tuple tuple: adjMap.get(n)){
                if(!visited.contains(tuple.getLetter())){
                    q.add(new Tuple(tuple.getLetter(), w * tuple.getValues()));
                    visited.add(tuple.getLetter());
                }
            }
        } 
        return -1;
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));
        equations.add(new ArrayList<>(Arrays.asList("b", "c")));
        double[] values = new double[]{2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a", "c")));
        queries.add(new ArrayList<>(Arrays.asList("b", "a")));
        queries.add(new ArrayList<>(Arrays.asList("a", "e")));
        queries.add(new ArrayList<>(Arrays.asList("a", "a")));
        queries.add(new ArrayList<>(Arrays.asList("x", "x")));

        double[] results = s1.calcEquation(equations, values, queries);
        for(double d:results){
            System.out.println(d);
        }
    }
}

/**
 * tuple
 */
class Tuple {

    public String letter;
    public double values;
    public Tuple(String s, double d){
        letter = s;
        values = d;
    }
    public String getLetter() {
        return letter;
    }
    public double getValues() {
        return values;
    }
}