package com.easy.kotlin;

import java.util.Arrays;
import java.util.List;

public class ForEachDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[] {1, 2, 3, 4, 5});
        int size = list.size();
        for (int index = 0; index < size; index++) {
            list.set(index, list.get(index) * list.get(index));
        }
        System.out.println(list);
    }
}
