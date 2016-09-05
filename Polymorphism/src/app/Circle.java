package app;
/**
 * Created by Павел on 19.08.2016.
 */
public class Circle extends Figure {

    private double radius;

    public String toString(){
        return "I'm a circle with radius" + this.radius;
    }

    Circle(double radius){
        this.radius = radius;
    }

    public double area(){
        return Math.PI*radius*radius;
    }

    public double perimeter(){
        return Math.PI*2*radius;
    }
}
