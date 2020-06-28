package annotation;

//測試class類
public class Text05 {

    public static void main(String[] args) {
        Person person = new Student();
        System.out.println("這個人是:"+person.name);//這個人是:學生

        /**
         * 獲得類的四種反射加載方式
         */
        //若已知具體的類,透過此種方式最為安全可靠
        Class c0 = Person.class;
        System.out.println(c0);//class annotation.Person

        //通過對象獲取
        Class c1 = person.getClass();
        System.out.println(c1.getName());//209813603


        //方式二：forName獲得
        try {
            Class c2 =  Class.forName("annotation.Student");
            System.out.println(c2.hashCode());//209813603
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //方式三:通過類名.class獲得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());//209813603

        //方法四:透過TYPE獲取
        Class c4 = Integer.TYPE;
        System.out.println(c4);

        //獲得父類類型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);//class annotation.Person


    }

}

class Person{
    String name;

    public Person(){

    }
    public Person(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{

    public Student(){
        this.name = "學生";
    }
}

class Teacher extends Person{

    public Teacher(){
        this.name = "老師";
    }
}

