package reflect;
import doMain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
     Class對象的功能
     - 獲取成員變量
     - 獲取構造方法
     - 獲取成員方法
     - 獲取類名
     */

public class ReflectDemo02 {
   public static void main(String[] args) {

       //獲取person的class 對象
       Class personClass =  Person.class;

       //獲取建構方法
       try {
          Constructor constructor =  personClass.getConstructor(String.class,int.class,boolean.class,String.class);

          System.out.println(constructor);
          //public doMain.Person(java.lang.String,int,boolean,java.lang.String)

          //創建對象
          Object person =  constructor.newInstance("lipin",27,true,"brad");
          System.out.println(person);
          //Person{name='lipin', age=27, sex=true, teacher='brad'}

          System.out.println("===========================================");
//---------------------------------------------------------------------------------------
           //不傳參寫法
           Constructor constructor01 =  personClass.getConstructor();

           //創建對象
           Object person01 =  constructor01.newInstance();
           System.out.println(person01);
           //Person{name='null', age=0, sex=false, teacher='null'}
           System.out.println("===========================================");
//---------------------------------------------------------------------------------------
           //簡化寫法,如果不傳參的話 Class這個類自己就有這個方法Class..newInstance()
          Object o = personClass.newInstance();
          System.out.println(o);
          //Person{name='null', age=0, sex=false, teacher='null'}


       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}



