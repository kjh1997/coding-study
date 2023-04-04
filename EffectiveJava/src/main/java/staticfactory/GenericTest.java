package staticfactory;

import java.util.function.Supplier;

public class GenericTest<T> {
    private static GenericTest<Object> INSTANCE = new GenericTest<>();

//    private GenericTest() {}

    public static <E> GenericTest<E> getInstance() {
        return (GenericTest<E>) INSTANCE;
    }

//    public T


    public void say(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        GenericTest<String> g1 = GenericTest.getInstance();
        GenericTest<Integer> g2 = GenericTest.getInstance();
        System.out.println(g1);
        System.out.println(g2);
        g1.say("tes");
        g2.say(123);
        GenericTest<Boolean> g3 = GenericTest.getInstance();
        GenericTest<String> test = new GenericTest<>();

        GenericTest<Integer> test2 = new GenericTest<>();
        Supplier<Object> test3 = () -> {
            int num = (int) (Math.random() * 6) + 1;
            return num;
        };
        System.out.println(test3.get());



    }
}
