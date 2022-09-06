package Lesson6;

import lesson6.MainClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class TestMainClass {

    private MainClass mainClass;

    @BeforeEach
    public void init() {
        mainClass = new MainClass();
    }

    @ParameterizedTest
    @MethodSource("dataForCheckIfArrayConsistsOf1And4")
    void TestIfArrayConsistsOf1And4(int[] array, boolean result) {
        Assertions.assertEquals(result, mainClass.ifArrayConsistsOnlyOf1And4(array));
    }

    public static Stream<Arguments> dataForCheckIfArrayConsistsOf1And4() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4}, false));
        out.add(Arguments.arguments(new int[]{1, 4, 4, 1, 1, 4, 3}, false));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForGetValuesInArrayAfterLast4")
    void TestGetValuesInArrayAfterLast4(int[] array, int[] result) {
        Assertions.assertArrayEquals(result, mainClass.getValuesInArrayAfterLast4(array));
    }

    public static Stream<Arguments> dataForGetValuesInArrayAfterLast4() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4, 3, 5}, new int[]{3, 5}));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1, 4, 5, 6, 6}, new int[]{5, 6, 6}));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4, 5, 6, 7}, new int[]{5, 6, 7}));
        return out.stream();
    }
}
