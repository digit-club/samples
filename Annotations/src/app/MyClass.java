package app;

@MyMarker
public class MyClass {

    @MyAnnotation(name = "myAnnotation", number = 20)
    public void myAnnotatedMethod(int val){

    }

    @MyAnnotation
    public void myAnnotatedWithDefaultsMethod(String val){

    }

}
