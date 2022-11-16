package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        try {
            Class classInRuntime = Class.forName(MyClass.class.getName());
            Class[] params = {int.class, String.class};

            Constructor constructor1 = myClass.getClass().getDeclaredConstructor(params);
            constructor1.setAccessible(true);

            myClass = (MyClass) constructor1.newInstance(25,"Andrew");

            Constructor[] constructors = classInRuntime.getConstructors();
            for (Constructor constructor : constructors) {
                Class[] paramTypes = constructor.getParameterTypes();
                for (Class paramType : paramTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }


        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(myClass);


    }
}

class MyClass {
    private int age;
    private String name = "default";

    public MyClass() {
    }


    private MyClass(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        System.out.println("GET AGE");
        return age;
    }

    public void setAge(int age) {
        System.out.println("SET AGE");
        this.age = age;
    }

//        public String getName() {
//            return name;
//        }

    public void setName(String name) {
        System.out.println("SET NAME");
        this.name = name;
    }

    private void printData() {
        System.out.println("PRINT DATA");
        System.out.println(age + " " + name);
    }
}