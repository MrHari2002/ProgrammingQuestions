package Leetcode.BFS.NearestExit;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import Leetcode.Util.IntTuple;

public class Solution {
    // Implementing BFS
    // Queue And Poll From Queue?
    char[][] maze;
    int rowLength;
    int colLength; 
    int[][] distanceMap;
    Deque<Triple> q; 

    public int nearestExit(char[][] maze, int[] entrance) {


        this.maze = maze;
        this.rowLength = maze.length;
        this.colLength = maze[0].length;
        this.distanceMap = new int[rowLength][colLength];


        //Entrance
        int sx = entrance[0];
        int sy = entrance[1];

        //Queue
        q = new ArrayDeque<>();
        int MaxInt = Integer.MAX_VALUE;
        //InitializedMap with Max Int
        for(int i = 0; i<rowLength;i++){
            for(int j = 0; j< colLength;j++){
                distanceMap[i][j] = MaxInt;
            }
        }

        //Directions List As String
        List<IntTuple> directions = new ArrayList<>();
        directions.add(new IntTuple(1, 0));
        directions.add(new IntTuple(0, 1));
        directions.add(new IntTuple(-1, 0));
        directions.add(new IntTuple(0, -1));

        enqueue(sx, sy, 0);

        while (q.size()>0) {
            Triple triple = q.pop();

            //See if the win conditions has been met
            if(triple.x == 0 || triple.x == rowLength-1 || triple.y == 0 || triple.y == colLength -1 ){
                if(triple.x!=sx && triple.y != sy){
                    return triple.d;
                }
            }
            
            //Go to different directions
            for(IntTuple direction: directions){
                int nx = triple.x+direction.x;
                int ny = triple.y+direction.y;

                if(0<= nx && nx < rowLength && 0<= ny && ny< colLength && maze[nx][ny]!='+' && distanceMap[nx][ny] == MaxInt){
                    enqueue(nx, ny, triple.d+1);
                    //if at the winning condition
                    if(nx == 0 || nx == rowLength-1 || ny == 0 || ny == colLength-1){
                        return triple.d +1;
                    }

                }
            }

        }
        return -1;
    }

    public void enqueue(int x, int y, int d){
        distanceMap[x][y] = d;
        q.add(new Triple(x, y, d));
        
    }
    public static void main(String[] args) {
        char[][] charArray = {
            {'+', '+', '.', '+'},
            {'.', '.', '.', '+'},
            {'+', '+', '+', '.'}
        };
        int[] entrance = {1,2};
        Solution s1 = new Solution();


        char[][] charArray1 = {
            {'+','-'}
        };

        int[] entrance1 = {0,1};

        
        for (char[] row : charArray1) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        System.out.println(s1.nearestExit(charArray1, entrance1));

    }
}


/**
 * Triple */
class Triple {
    public int x;
    public int y;
    public int d;
    public Triple(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
    
}
