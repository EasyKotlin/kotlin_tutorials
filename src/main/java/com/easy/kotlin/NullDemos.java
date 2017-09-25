package com.easy.kotlin;

public class NullDemos {
    public static void main(String args[]) {
        NullDemos nullObject = null;
        nullObject.callStaticMethod();// 可以使用静态方法来使用一个值为null的引用类型变量。因为静态方法使用静态绑定，不会抛出空指针异常。
        nullObject.doMethod();
    }

    private static void callStaticMethod() {
        System.out.println("I am static method, can be called by null reference");
    }

    private void doMethod() {
        System.out.println("I am NON static method, don't date to call me by null");
    }
}
