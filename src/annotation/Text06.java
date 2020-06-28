package annotation;

public class Text06 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}
class A{

    static {
        System.out.println("A類靜態初始化");
        m = 300;
    }

    static int m = 100;

    public A(){
        System.out.println("A類無參建構是初始化");
    }
}
