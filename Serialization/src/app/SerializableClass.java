package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableClass implements Serializable{

    private String objectName;
    private Integer intValue;

    public SerializableClass(String objectName, Integer intValue) {
        this.objectName = objectName;
        this.intValue = intValue;
    }

    public void save(String fileName){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(this);
        }
        catch (IOException ei){
            System.out.println(ei.getMessage());
        }
    }

    public static SerializableClass read(String fileName) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            return (SerializableClass) in.readObject();
        }
        catch (IOException | ClassNotFoundException ioe){
            System.out.println(ioe.getMessage());
        }
        return null;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }
}
