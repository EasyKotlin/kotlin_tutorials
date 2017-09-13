package com.easy.kotlin;

import static java.lang.System.out;

public class PrimaryTypes {

    public static void main(String[] a) {
        //test1();
        //test2();
        test3();
    }

    static void test1() {
        // Integer的自动拆装箱的陷阱（整型数-128到127的值比较问题）
        out.println("-------------------");
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        out.println(x == y);
        out.println(x.equals(y));

        out.println("-------------------");
        Integer z = Integer.valueOf(123);
        Integer w = Integer.valueOf(123);
        out.println(z == w);
        out.println(z.equals(w));

        out.println("-------------------");
        Long a = Long.valueOf(127);
        Long b = Long.valueOf(127);
        out.println(a == b);
        out.println(a.equals(b));

        out.println("-------------------");
        Long c = Long.valueOf(128);
        Long d = Long.valueOf(128);
        System.out.println(c == d);
        System.out.println(c.equals(d));
    }

    static void test2() {
        // Integer的自动拆装箱的陷阱（整型数-128到127的值比较问题）
        out.println("-------------------");
        Integer x = new Integer(123);
        Long y = new Long(123);
        //out.println(x == y); // Error:(43, 23) java: incomparable types: java.lang.Integer and java.lang.Long
        out.println(x.equals(y));

        out.println("-------------------");
        Integer c = Integer.valueOf(128);
        Long d = Long.valueOf(128);
        //System.out.println(c == d);//Error:(49, 30) java: incomparable types: java.lang.Integer and java.lang.Long
        out.println(d.equals(c));
        //out.println(d.compareTo(c)); // Error:(53, 33) java: incompatible types: java.lang.Integer cannot be converted to java.lang.Long
    }

    static void test3(){
        double d1 = 1.0d;
        double d2 = 0.0d;
        for (int i=0; i<10; i++) {
            d2 += 0.1d;
        }
        System.out.println(d2 - d1);
    }
}
