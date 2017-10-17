package com.easy.kotlin;

import java.util.ArrayList;
import java.util.List;

public class TypeVariance {

    public static void main(String[] agrs) {
        //Class listStr = List<String>.class;

        //List<? extends Number> list0 = new ArrayList<Object>();
        List<? extends Number> list1 = new ArrayList<Number>();
        List<? extends Number> list2 = new ArrayList<Integer>();
        List<? extends Number> list3 = new ArrayList<Double>();
        testProducer(list1);
        testProducer(list2);
        testProducer(list3);

        List<? super Number> list4 = new ArrayList<Object>();
        List<? super Number> list5 = new ArrayList<Number>();
        testConsumer(list4);
        testConsumer(list5);

    }

    public static void testProducer(List<? extends Number> list) {
        //list 中元素的类型是  Number类型 或者 Number的子类型
        list.add(null); // ok
        list.add(null); // ok
        //list1.add(new Integer(1)); // error
        //list2.add(new Float(1.1f)); // error

    }

    public static void testConsumer(List<? super Number> list) {
        // list 是 List<Number> 的子类型，可以安全地写入 Number 的子类对象
        list.add(new Integer(3)); // list 中元素类型是 Number类型 或者Number父类型
        list.add(new Float(1.0));
        //list.add(new Object()); // error
    }

}
