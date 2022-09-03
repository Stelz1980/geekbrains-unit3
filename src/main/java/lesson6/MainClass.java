package lesson6;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainClass {

        public static void main(String[] args) {
        System.out.println(Arrays.toString(getValuesInArrayAfterLast4(new int [] {1, 2,3,4,5,6,7,8})));
        System.out.println(ifArrayConsistsOnlyOf1And4(new int [] {1, 1,1,1}));
    }

    public static int [] getValuesInArrayAfterLast4(int[] array) {
        int position = IntStream.rangeClosed(1, array.length)
                .mapToObj(i -> array[array.length - i]).collect(Collectors.toList()).indexOf(4);
        if (position == -1) {
            throw new RuntimeException("Нет четверок в массиве");
        }
        return Arrays.stream(array).skip(array.length - position).toArray();
    }

    public static boolean ifArrayConsistsOnlyOf1And4(int[] array) {
        return Arrays.equals(Arrays.stream(array).distinct().sorted().toArray(), new int [] {1, 4});
    }

}
