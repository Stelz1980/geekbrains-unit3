package lesson1.task2;


import lesson1.task1.exceptions.ArrayException;

import java.util.ArrayList;
import java.util.Collections;

public class Executor {


    public static void main(String[] args) throws ArrayException {
        String [] array = {"ss","sas", "sds", "ssd", "ssqwqw"};
        System.out.println(arrayToArrayList(array));

    }

    public static <T> ArrayList<T> arrayToArrayList(T ... args) {
        ArrayList<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, args);
        return arrayList;
    }
}
