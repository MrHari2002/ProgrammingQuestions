package HumanCannonBall;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Map.Entry;

public class HumanCannonBall {
    Point startPos;
    Point endPos;
    int numOfLines;
    ArrayList<Point> cannonballs;
    double cannonTime;
    double runningSpeed;
    double cannonDistance;
    //Adjacency graph for the shortest time traveled
    ArrayList<HashMap<Point,Double>> listOfAdjacencyGraph;
    ArrayList<PointEntry> dijkstraForTheShortestTime;
    
    public HumanCannonBall(Point startPos,Point endPos,int numOfLines,ArrayList<Point> cannonballs){
        this.startPos = startPos;
        this.endPos = endPos;
        this.numOfLines = numOfLines;
        this.cannonballs = cannonballs;
        listOfAdjacencyGraph = new ArrayList<>();
        dijkstraForTheShortestTime = new ArrayList<>();
        cannonTime = 2.0;
        runningSpeed = 5.0;
        cannonDistance = 50.0;


        initializeMap();
        doDijkstra();
        for (PointEntry dijkstra : dijkstraForTheShortestTime) {
            if(dijkstra.getPoint().equals(endPos)){
                System.out.println(dijkstra.getTime());
                //System.out.println(Math.round(dijkstra.getTime()*1000000.0)/1000000.0);
            }
        }
    }
    //The First Part
    private void initializeMap(){
        for (int i = 0; i < cannonballs.size(); i++) {
            HashMap<Point,Double> adjacencyGraph = new HashMap<>();
            for (int j=0;j<=cannonballs.size();j++){
                //Consider the end position
                if(j==cannonballs.size()){
                    double time = cannonTime+(cannonballs.get(i).getDistance(endPos)-cannonDistance)/runningSpeed;
                    adjacencyGraph.put(endPos,time);
                }
                else{
                //The matrix doesn't consider itself
                if(i!=j){
                            Double time = cannonTime+(cannonballs.get(i).getDistance(cannonballs.get(j))-cannonDistance)/runningSpeed;
                            adjacencyGraph.put(cannonballs.get(j), time);
                    }
                }
                }
            listOfAdjacencyGraph.add(adjacencyGraph);
            }

        //Adding the starting point in a different loop.
        HashMap<Point,Double> startingPointMap = new HashMap<>();
            for(Point point:cannonballs){
                Double time = point.getDistance(startPos)/runningSpeed;
                startingPointMap.put(point, time);
            }
            startingPointMap.put(endPos, startPos.getDistance(endPos)/runningSpeed);
            listOfAdjacencyGraph.add(0, startingPointMap);

        //Adding the ending point graph
        HashMap<Point,Double> endPosMap = new HashMap<>();
        for(Point point:cannonballs){
            Double time = cannonTime+(endPos.getDistance(point)-cannonDistance)/runningSpeed;
            endPosMap.put(point, time);
        }
        endPosMap.put(startPos, endPos.getDistance(startPos)/5);
        listOfAdjacencyGraph.add(endPosMap);

        }
    

    private void doDijkstra(){
        PriorityQueue<PointEntry> allTheEntries = new PriorityQueue<PointEntry>();
        
        ArrayList<Point> visited = new ArrayList<Point>();

        ArrayList<Point> allThePoints = new ArrayList<>();
        allThePoints.add(startPos);
        for (Point point : cannonballs) {
            allThePoints.add(point);
        }
        allThePoints.add(endPos);
        //Add the starting entries in the priorityQueue;
        for(Entry<Point,Double> entry:listOfAdjacencyGraph.get(0).entrySet()){
            allTheEntries.add(new PointEntry(startPos, entry.getKey(), entry.getValue()));
        }
        visited.add(startPos);
        while(visited.size()!=allThePoints.size()
        ){
            PointEntry polledEntry = allTheEntries.poll();
            //If the polled entry's point has been visited then next one
            while(visited.contains(polledEntry.getPoint())){
                polledEntry = allTheEntries.poll();
            }
            visited.add(polledEntry.getPoint());
            dijkstraForTheShortestTime.add(polledEntry);
            //find the graph of the pulled entry then added it to the addTheEntries excluding the visited one
            int polledIndex = -1;
            for(int i =0;i<allThePoints.size();i++){
                if(polledEntry.getPoint().equals(allThePoints.get(i))){
                    polledIndex = i;
                } 
            }
            if(polledIndex!=-1){
                for(Entry<Point,Double> entry:listOfAdjacencyGraph.get(polledIndex).entrySet()){
                    allTheEntries.add(new PointEntry(allThePoints.get(polledIndex), entry.getKey(), entry.getValue()+polledEntry.getTime()));
                }
            }
        }
    }
          

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
                Point startPos = new Point(scanner.nextDouble(),scanner.nextDouble());
                Point endPos = new Point(scanner.nextDouble(),scanner.nextDouble());
                int numOfLines = scanner.nextInt();
                ArrayList<Point> cannons = new ArrayList<>();
                while(numOfLines!=0){
                    Point position = new Point(scanner.nextDouble(),scanner.nextDouble());
                    cannons.add(position);
                    numOfLines--;
                }
                HumanCannonBall humanCannonBall = new HumanCannonBall(startPos, endPos, numOfLines, cannons);
            scanner.close();    
        } catch (Exception e) {
            System.out.println(e);
        }
        //System.out.println(6.800735254367721+8.031219541881399+);
    }

}
