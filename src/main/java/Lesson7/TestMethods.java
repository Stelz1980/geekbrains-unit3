package Lesson7;

import Lesson7.Annotations.AfterSuite;
import Lesson7.Annotations.BeforeSuite;
import Lesson7.Annotations.Test;

public class TestMethods {

    @BeforeSuite
    public static void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public static void AfterSuite() {
        System.out.println("AfterSuite");
    }

    @Test(priority = 1)
    public static void test1() {
        System.out.println("test1");
    }

    @Test(priority = 2)
    public static void test2() {
        System.out.println("test2");
    }

    @Test(priority = 3)
    public static void test3() {
        System.out.println("test3");
    }

    @Test(priority = 4)
    public static void test4() {
        System.out.println("test4");
    }

    @Test(priority = 5)
    public static void test5() {
        System.out.println("test3");
    }

    @Test(priority = 6)
    public static void test6() {
        System.out.println("test4");
    }

    @Test(priority = 7)
    public static void test7() {
        System.out.println("test7");
    }

    @Test(priority = 8)
    public static void test8() {
        System.out.println("test8");
    }

    @Test(priority = 9)
    public static void test9() {
        System.out.println("test9");
    }

    @Test(priority = 10)
    public static void test10() {
        System.out.println("test10");
    }

    @Test
    public static void testDefault() {
        System.out.println("testDefault");
    }

}
