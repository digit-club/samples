package app;
//import org.apache.sum;

public class Main {

    public static void main(String[] args){

        Figure[] figures = new Figure[3];

        figures[0] = new Triangle(2.0);
        figures[1] = new Circle(10.0);
        figures[2] = new Square(1.0);

        for(int i = 0; i < 3; i++){
            System.out.print(figures[i]);
            System.out.println("  My area is: " + figures[i].area() + "  ; and my perimeter is " + figures[i].perimeter());

        }
    }

}
