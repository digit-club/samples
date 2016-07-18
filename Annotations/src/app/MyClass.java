package app;

@MyMarker
@MyAnnotation(name = "myClassLevelAnnotation1")
@MyAnnotation(name = "myClassLevelAnnotation2", number = 2)
public class MyClass {

    @MyAnnotation(name = "myAnnotation", number = 20)
    public void myAnnotatedMethod(int val){

    }

    @MyAnnotation
    public void myAnnotatedWithDefaultsMethod(String val){

    }

}
