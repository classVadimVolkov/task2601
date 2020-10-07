package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new Integer[] {13, 8, 15, 5, 18})));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        if (array.length % 2 == 0) {
            return sortEvenArray(array);
        } else {
            return sortOddArray(array);
        }
    }

    public static Integer[] sortEvenArray(Integer[] array) {
        Arrays.sort(array);

        for (Integer element : array)
            System.out.print(element + ", ");
        System.out.println();

        int sumOfTwoNumbers = array[array.length/2] + array[(array.length/2) - 1];
        Integer median = Math.round(sumOfTwoNumbers/2);
        System.out.println("Median is " + median);
        Arrays.sort(array, (o1, o2) -> Math.abs(o1 - median) - Math.abs(o2 - median));
        return array;
    }

    public static Integer[] sortOddArray(Integer[] array) {
        Arrays.sort(array);

        for (Integer element : array)
            System.out.print(element + ", ");
        System.out.println();

        Integer median = array[(array.length - 1)/2];
        System.out.println("Median is " + median);
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o2, Integer o1) {
                return Math.abs(o2 - median) - Math.abs(o1 - median);
            }
        });
        //                  5-8-13-15-18
        // 1: o2=8, o1=5; return -3; 5-8-13-15-18
        // 2: o2=13, o1=8; return -5; 13-8-5-15-18
        // 3: o2=15, o1=13; return 2; 13-8-5-15-18
        // 4: o2=15, o1=8; return -3; 13-15-8-5-18
        // 5: o2=15, o1=13; return 2; 13-15-8-5-18
        // 6: o2=18, o1=8; return 0; 13-15-8-5-18
        // 7: o2=18, o1=5; return -3; 13-15-8-18-5
        // 8

        return array;
    }


}
