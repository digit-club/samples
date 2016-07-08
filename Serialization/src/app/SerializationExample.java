package app;

public class SerializationExample {

    static final String FILE = "bin/output.txt";

    public static void main(String[] args) {
        SerializableClass object = new SerializableClass("object1", 1);
        object.save(FILE);

        SerializableClass objectClone = SerializableClass.read(FILE);
        System.out.println(objectClone.getObjectName() + " : " + objectClone.getIntValue());
    }

}
