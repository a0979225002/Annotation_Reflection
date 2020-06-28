package annotation;

//自定義註解

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class Test03 {
    @MyAnnotation(name = "註解測試",schools = {"清華大學"})
    private void test(){

    }
}
@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    //註解的參數:參數的類型，參數名();
    //default = 默認值,當使用註解時,不傳參時,會使用默認值
    String name() default "";
    int age() default 0;
    boolean sex() default false;
    String[] schools();

}
