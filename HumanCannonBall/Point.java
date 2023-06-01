package HumanCannonBall;
public class Point {
    double x;
    double y;
    public Point(double x,double y){
        this.x=x;
        this.y=y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getDistance(Point point){
        return Math.abs(Math.sqrt(Math.pow(x-point.getX(),2)+Math.pow(y-point.getY(),2)));
    }
}
