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

        for (Method method : clazz.getMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                try {
                    method.invoke(null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        List<Method> testMethodList = new ArrayList<>();

        for (Method method : clazz.getMethods()) {
            if (method.getAnnotation(Test.class) != null) {
                testMethodList.add(method);
            }
        }

        for (Method method : clazz.getMethods()) {
            if (method.getAnnotation(AfterSuite.class) != null) {
                try {
                    method.invoke(null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }




    }
}
