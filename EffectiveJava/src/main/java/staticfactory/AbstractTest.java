package staticfactory;

import org.aspectj.weaver.ast.ITestVisitor;

public abstract class AbstractTest {
    public void hello() {
        System.out.println("test");

    }

    abstract void absHello();
}
