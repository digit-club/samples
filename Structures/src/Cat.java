class Cat {
    String name;
    double weight;
    int age;
    String color;

    Cat(String name, double weight, int age, String color){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
    }

    void eat(double food) {
        weight += food;
    }

    void sleep(int hours) {
        System.out.println("Cat slept " + hours + " hours.");
        weight -= hours * 0.1;
    }

    void move(int kms) {
        System.out.println("Cat ran " + kms + " kms.");
        weight -= 0.2 * kms;
    }

    void showState() {
        System.out.println("Cat " + name + ", weigth: " + weight + ", age: " + age);
    }
}
