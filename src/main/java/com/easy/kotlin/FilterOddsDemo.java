package com.easy.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class FilterOddsDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6, 7});
        out.println(filterOdds(list));
    }

    public static List<Integer> filterOdds(List<Integer> list) {
        List<Integer> result = new ArrayList();
        for (Integer i : list) {
            if (isOdd(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isOdd(Integer i) {
        return i % 2 != 0;
    }
}
