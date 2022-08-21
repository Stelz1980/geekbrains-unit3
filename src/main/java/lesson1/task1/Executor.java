package lesson1.task1;



import lesson1.task1.exceptions.ArrayException;

import java.util.Arrays;

public class Executor {

    public static void main(String[] args) throws ArrayException {
        String [] array = {"ss","sas", "sds", "ssd", "ssqwqw"};
        System.out.println(Arrays.toString(swapElementsInArray(array, 2, 2)));

    }

    public static <T> T[] swapElementsInArray(T[] array, int from, int to) throws ArrayException {
        if (from < 0 || from > array.length - 1) {
            throw new ArrayException(String.format("Значение from %d меньше нуля или больше длины массива %d", from,  array.length));
        }

        if (to < 0 || to > array.length - 1) {
            throw new ArrayException(String.format("Значение to %d меньше нуля или больше длины массива %d", to,  array.length));
        }

        if (from != to) {
            T value;
            value = array[to];
            array[to] = array[from];
            array[from] = value;
        }
        return array;
    }
}
