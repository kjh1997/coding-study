package com.aspect;

import org.aspectj.weaver.loadtime.ClassPreProcessorAgentAdapter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class MyJavaAgent {
    public static void premain(String agentArgs, Instrumentation instrumentation) {

        ClassFileTransformer transformer = new MyTransformer();
        instrumentation.addTransformer(transformer);
    }
}

