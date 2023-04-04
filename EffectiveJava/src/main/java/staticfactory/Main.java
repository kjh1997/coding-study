package staticfactory;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Singleton singleton = Singleton.getSingleton();
//        Constructor<Singleton> singleton1 = Singleton.class.getDeclaredConstructor();
//        singleton1.setAccessible(true);
//        Singleton singleton2 = singleton1.newInstance();
//        singleton2.hello();
//        singleton.hello();
//        System.out.println(singleton2.hashCode());
//        System.out.println(singleton.hashCode());

        Child abs = new Child();
        abs.absHello();
        abs.hello();


    }
}
