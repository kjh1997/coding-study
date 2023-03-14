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

public class Singleton {
    private static Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }

}