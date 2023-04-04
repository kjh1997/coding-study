package staticfactory;

//public class Singleton {
//
//    private Singleton() {
//    }
//
//    private static final Singleton SINGLETON = new Singleton();
//
//    private static Singleton getSingleton() {
//        return SINGLETON;
//    }
//
//}

import java.io.Serializable;

public class Singleton implements Serializable {
    public static Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }

    public void hello() {
        System.out.println("hello singleTon");
    }

    private Object readResolve() {
        return singleton;
    }


    private Singleton() {
        if (singleton != null) {
            throw new IllegalStateException();
        }
    }

}