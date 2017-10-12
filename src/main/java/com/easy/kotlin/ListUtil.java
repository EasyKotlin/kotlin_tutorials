package com.easy.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

interface Predicate<T> {
    Boolean predicate(T t);
}

public class ListUtil<T> {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6, 7});
        ListUtil<Integer> listUtil = new ListUtil();
        List<Integer> result = listUtil.filter(list, (it) -> it % 2 == 1);
        out.println(result); // [1, 3, 5, 7]
    }

    public List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.predicate(t)) {
                result.add(t);
            }
        }
        return result;
    }
}




