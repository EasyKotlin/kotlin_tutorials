/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

abstract class BaseObject<T> {
}

public class ParameterizedTypeDemo<T> extends BaseObject<Integer> { // 实例化T 为 Integer
    public static void main(String[] agrs) {
        ParameterizedTypeDemo parameterizedTypeDemo = new ParameterizedTypeDemo<Integer>();
        parameterizedTypeDemo.test(1);
    }

    void test(T t) {
        System.out.println(t);

        //java中的泛型采用擦拭法。无法得到自己本身的泛型。而调用getGenericSuperclass()方法得到的是父类的泛型。
        //getGenericSuperclass()是Generic继承的特例，
        //对于这种情况子类会保存父类的Generic参数类型，返回一个ParameterizedType，这时可以获取到父类的T.class了，这也正是子类确定应该继承什么T的方法。
        Type genType = this.getClass().getGenericSuperclass();
        Type[] typeArguments = ((ParameterizedType)genType).getActualTypeArguments();
        for (Type type : typeArguments) {
            System.out.println(type.getTypeName());
        }

    }
}
