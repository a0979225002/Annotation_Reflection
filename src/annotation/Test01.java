package annotation;

import java.util.ArrayList;
import java.util.List;

public class Test01 {

    //他是一個重寫的註解

    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated //不推薦使用但是可以使用
    public static void test01(){
        System.out.println("Deprecated測試");
    }

    //加入SuppressWarnings("all")註解後,警告已消失
    @SuppressWarnings("all")
    public void test02(){
       List list = new ArrayList();
    }

    public static void main(String[] args) {
        test01();
    }
}
