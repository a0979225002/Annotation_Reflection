package annotation;

import javax.lang.model.element.Element;
import java.lang.annotation.*;

@Myannotation
public class Test02 {
    //在方法中能用了
    @Myannotation
    public void test(){

    }
}

//自訂定義註解格式,只能用在方法上
//@Target 表示註解能用在哪些地方,這裏能放在方法與類上面
@Target(value ={ElementType.METHOD,ElementType.TYPE})
//表示我們註解在什麼地方才有效(RUNTIME = .class 與編譯期都有效)
@Retention(RetentionPolicy.RUNTIME)
@Documented //javaDoc
@Inherited  //子類可以父類的註解
@interface Myannotation{

}