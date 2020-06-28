package reflect;
import doMain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
     Class對象的功能
     - 獲取成員方法
     */

public class ReflectDemo03 {
   public static void main(String[] args) {

       //獲取person的class 對象
       Class personClass = Person.class;

       //獲取Method,空參
       try {
           Method eat_Method = personClass.getMethod("eat");
           Person p = new Person();

           eat_Method.invoke(p);//eat......

//---------------------------------------------------------------------------------------

       //獲取Method,並給予參數
            Method eat_Method02 = personClass.getMethod("eat", String.class);
            eat_Method02.invoke(p,"麥當勞");//eat..麥當勞

//---------------------------------------------------------------------------------------
        //獲取private屬性的Method,並給予參數
           Method eat_Method03 = personClass.getDeclaredMethod("eat", String.class, String.class);
           eat_Method03.setAccessible(true);
           eat_Method03.invoke(p,"麥當勞","肯德基");//eat..麥當勞,肯德基


//---------------------------------------------------------------------------------------
       //獲取所有方法
            Method[] eat_Method04 = personClass.getMethods();
            for (Method method: eat_Method04){
                System.out.println(method);
                //public void doMain.Person.eat(java.lang.String)
                //public void doMain.Person.eat()
                //public java.lang.String doMain.Person.toString()
                //public static doMain.Person doMain.Person.getInstance()
                //public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
                //public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
                //public final void java.lang.Object.wait() throws java.lang.InterruptedException
                //public boolean java.lang.Object.equals(java.lang.Object)
                //public native int java.lang.Object.hashCode()
                //public final native java.lang.Class java.lang.Object.getClass()
                //public final native void java.lang.Object.notify()
                //public final native void java.lang.Object.notifyAll()


                //可以透過此方式獲得方法名獲取方法名
                String name = method.getName();
                System.out.println(name);
            }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}



