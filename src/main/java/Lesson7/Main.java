package Lesson7;

import Lesson7.Annotations.AfterSuite;
import Lesson7.Annotations.BeforeSuite;
import Lesson7.Annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        TestMethods testMethods = new TestMethods();
        testClass(testMethods.getClass());
    }

    public static void testClass(Class clazz) {
        List<Method> beforeMethodList = new ArrayList<>();
        List<Method> afterMethodList = new ArrayList<>();
        List<Method> testMethodList = new ArrayList<>();

        for (Method method : clazz.getMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                beforeMethodList.add(method);
            } else if (method.getAnnotation(AfterSuite.class) != null) {
                afterMethodList.add(method);
            } else if (method.getAnnotation(Test.class) != null) {
                testMethodList.add(method);
            }
        }

        runMethods(beforeMethodList);
        Collections.sort(testMethodList, (o1, o2) -> (
                o1.getAnnotation(Test.class).priority() > o2.getAnnotation(Test.class).priority()) ? 1 : -1);
        runMethods(testMethodList);
        runMethods(afterMethodList);

    }

    private static void runMethods(List<Method> methodList) {
        for (Method m : methodList) {
            try {
                m.invoke(null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
