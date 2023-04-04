
package com.aspect;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestObject {
    private String name = "kjh";

    public void myName() {
        System.out.println(this.name);
    }

    public void hello() {
        System.out.println("hello");

    }
}
