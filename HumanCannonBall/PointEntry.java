package HumanCannonBall;
public class PointEntry implements Comparable<PointEntry>{
    Point prePoint;
    Point point;
    Double time;
    public PointEntry(Point prePoint,Point point,Double time){
        this.prePoint = prePoint;
        this.point = point;
        this.time = time;
    }
    public Point getPrePoint() {
        return prePoint;
    }

    public Point getPoint() {
        return point;
    }
    public Double getTime() {
        return time;
    }
    public void print(){
        System.out.println("--------");
        System.out.println("Prepoint:"+prePoint.getX()+","+prePoint.getY());
        System.out.println("Point:"+point.getX()+","+point.getY());
        System.out.println("Time:"+time);
        System.out.println("--------");
    }
    
    @Override
    public int compareTo(PointEntry o) {
        return this.getTime().compareTo(o.getTime());    
    }
}
