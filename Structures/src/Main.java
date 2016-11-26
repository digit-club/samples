public class Main {

    public static void main(String[] args) {
        Cat grisha = new Cat("Grisha", 2.5, 2, "Black");
        grisha.showState();

        grisha.eat(2.5);
        grisha.showState();

        grisha.sleep(2);
        grisha.move(10);
        grisha.showState();
    }

}
