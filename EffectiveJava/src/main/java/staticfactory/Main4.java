package staticfactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

public class Main4 {
    public static void main(String[] args) {
        Supplier<? extends Internet> child = Lan::new;
        Supplier<? extends Internet> child2 = Wan::new;
        Supplier<Internet2> cchild = Lan2::new;
        Supplier<Internet2> cchild2 = Wan2::new;

    }
}

interface Internet2{
    void Hello();
}

class Lan2 implements Internet2{

    @Override
    public void Hello() {
        System.out.println("lan");
    }
}

class Wan2 implements Internet2 {

    @Override
    public void Hello() {
        System.out.println("Wan");
    }
}
interface Internet{
    void Hello();
}

class Lan implements Internet{

    @Override
    public void Hello() {
        System.out.println("lan");
    }
}

class Wan implements Internet {

    @Override
    public void Hello() {
        System.out.println("Wan");
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Library {
    private String name;
    public Library(Supplier<String> data) {
        this.name = data.get();
    }
}