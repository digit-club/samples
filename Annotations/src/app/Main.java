package app;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        try {
            Class<?> clazz = MyClass.class;
            MyAnnotation myAnnotation;

            Method myAnnotatedWithDefaultsMethod = clazz.getMethod("myAnnotatedWithDefaultsMethod", String.class);
            myAnnotation = myAnnotatedWithDefaultsMethod.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation defaults: " + myAnnotation.name() + " " + myAnnotation.number());

            Method myAnnotatedMethod = clazz.getMethod("myAnnotatedMethod", int.class);
            myAnnotation = myAnnotatedMethod.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation custom members: " + myAnnotation.name() + " " + myAnnotation.number());

            boolean marked = MyClass.class.isAnnotationPresent(MyMarker.class);
            System.out.println(MyClass.class.getSimpleName() + (marked ? " is " : " is not ") + "marked with "
                    + MyMarker.class.getSimpleName() + " annotation.");

            MyAnnotation[] myAnnotations = MyClass.class.getAnnotationsByType(MyAnnotation.class);
            System.out.println("Annotations of type : " + MyAnnotation.class.getSimpleName());
            for (MyAnnotation annotation : myAnnotations) {
                System.out.println(annotation.name() + " : " + annotation.number());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
