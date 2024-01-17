package dataManipulations;

import java.lang.annotation.*;
@Inherited
@Retention(RetentionPolicy.RUNTIME)//Runtime,Class,Source
@Target({ElementType.METHOD, ElementType.TYPE})//type.method
public @interface DataProcessor {
}
