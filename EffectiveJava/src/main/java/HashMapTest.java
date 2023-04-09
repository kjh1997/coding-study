import java.util.HashMap;
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "test");
        map.put(1, "test2");
        System.out.println(map);
    }
}
