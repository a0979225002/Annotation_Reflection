package annotation;

//什麼是反射
public class Testo4 {
    public static void main(String[] args) {
        //通過反射拿取class
        try {
           Class myClass =  Class.forName("annotation.User");
           System.out.println(myClass);//class annotation.User

            //測試三個類是否同一個類
            //一個類的內存只會有一個Class對象
            //一個類被加載後，類的整個結構都會被封裝載Class對象中
            Class c1 = Class.forName("annotation.User");
            Class c2 = Class.forName("annotation.User");
            Class c3 = Class.forName("annotation.User");

            System.out.println(c1 == c2);//true
            System.out.println(c1.hashCode());//記憶體位置:804581391
            System.out.println(c2.hashCode());//記憶體位置:804581391
            System.out.println(c3.hashCode());//記憶體位置:804581391


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

//實體類
class User{
    private String name;
    private  int id;
    private  int age;

    public User(){

    }

    public User(String name,int id,int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
