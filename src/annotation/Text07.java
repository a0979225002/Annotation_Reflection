package annotation;

public class Text07 {
    static {
        System.out.println("Main類被加載");
    }

    public static void main(String[] args) {
//        Son son = new Son();

        //反射也會通過主動引用
//        try {
//            Class.forName("annotation.Son");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        //不會產生類的引用方法,無加載子類
//        System.out.println(Son.b);
        //Main類被加載
        //父類被加載
        //2

//        Son[] array = new Son[5];
        //Main類被加載

        System.out.println(Son.M);
        //Main類被加載
        //1

    }
}
class Father{

    static  int b = 2;

    static {
        System.out.println("父類被加載");
    }
}
class Son extends Father{
    static {
        System.out.println("子類被加載");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;
}