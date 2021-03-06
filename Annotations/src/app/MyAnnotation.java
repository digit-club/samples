package app;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyAnnotations.class)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
public @interface MyAnnotation {
    String name() default "defaultName";
    int number() default 0;
}
