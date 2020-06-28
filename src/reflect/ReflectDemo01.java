package reflect;


import doMain.Person;

import java.lang.reflect.Field;

/**
     Class對象的功能
     - 獲取成員變量
     - 獲取構造方法
     - 獲取成員方法
     - 獲取類名
     */

public class ReflectDemo01 {
   public static void main(String[] args) {
       //獲取person的class 對象
       Class personClass =  Person.class;

       /**
        * 01.獲取成員變量
        */
       //Field[]  .getFields()
       //獲取所有成員變量()
       Field[] fields =  personClass.getFields();
       for ( Field field :fields) {
           //只能獲取到public的成員變量
            System.out.println("field獲取成員變量:"+field);
           //field獲取成員變量:public java.lang.String reflect.Person.name
           //field獲取成員變量:public int reflect.Person.age
       }

       //獲得其中一個成員變量
       try {
           Field field = personClass.getField("name");
           //獲取變量的值
            Person p  = new Person();
            Object value =  field.get(p);
            System.out.println(value);//null
           //給予String name 一個值
           field.set(p,"lipin");
           System.out.println(p);//Person{name='lipin', age=0, sex=false}
           //從新獲取name的值
           Object value01 =  field.get(p);
           System.out.println(value01);//lipin

           System.out.println("============================");


           /**
            * 02.獲取成員變量
            */
           //Field[] .getDeclaredFields()
           //獲取所有的成員變量,不考慮任何修飾符
           Field[] declaredFields = personClass.getDeclaredFields();
           for (Field declaredField:declaredFields){
               System.out.println(declaredField);
               //public java.lang.String reflect.Person.name
               //public int reflect.Person.age
               //private boolean reflect.Person.sex
           }

           //private屬性能獲取值,給值媽？
           Field field02 = personClass.getDeclaredField("teacher");

           //如果要訪問private屬性,需要讓java忽略系統權限修飾符的安全檢查
           field02.setAccessible(true);//暴力反射,怕怕,學了反射,封包已蕩然無存

           field02.set(p,"brad");

           Object o = field02.get(p);

           System.out.println(o);//brad



       } catch (Exception e) {
           e.printStackTrace();
       }

   }
}
