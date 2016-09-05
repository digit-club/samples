package app;

/**
 * Created by Павел on 19.08.2016.
 */
public class Triangle extends Figure{

    private double side;

    Triangle(double side){
        this.side = side;
    }

    public String toString(){
        return "I'm a Triangle with side " + this.side;
    }

    public double area(){
        return Math.sqrt(3)/4*side*side;
    }

    public double perimeter(){
        return 3*side;
    }
}
