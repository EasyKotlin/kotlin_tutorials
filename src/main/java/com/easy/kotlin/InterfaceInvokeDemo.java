package com.easy.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface G {
    Integer apply(String s);
}

interface F {
    Boolean apply(Integer x);
}

interface H {
    Boolean apply(String s);
}

public class InterfaceInvokeDemo {
    public static void main(String[] args) {
        G g = (s) -> s.length();
        F f = (x) -> x % 2 != 0;
        H h = (s) -> f.apply(g.apply(s));

        List<String> strings = Arrays.asList(new String[] {"a", "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg"});
        List<String> result = new ArrayList();

        for (String s : strings) {
            if (h.apply(s)) {
                result.add(s);
            }
        }

        System.out.println(result);
    }
}
