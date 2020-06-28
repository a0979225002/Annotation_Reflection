package doMain;

public class Person {
    public String name;
    public int age;
    private  boolean sex;
    private String teacher;
    public Person(){

    }
    public Person(String name,int age,boolean sex,String teacher){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.teacher = teacher;
    }

    //額外補充,獨立者模式,當private建構式時,目的為了防止產生多個實體
    //使用static的方法,達成命名規則:getInstance()
    public static Person person;
    public static Person getInstance(){
        if (person == null){
            person = new Person();
            return person;
        }
        return null;
    }

    public void eat(){
        System.out.println("eat......");
    }
    public void eat(String food){
        System.out.println("eat.."+food);
    }
    private void eat(String food,String food2){
        System.out.println("eat.."+food+","+food2);
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
