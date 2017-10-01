package com.easy.kotlin;

public class StaticVarVSClassloader {
    public static void main(String[] args) {
        Singleton1 mysingleton1 = Singleton1.GetInstence();
        System.out.println(mysingleton1.a); // 1
        System.out.println(mysingleton1.b); // 0

        Singleton2 mysingleton2 = Singleton2.GetInstence();
        System.out.println(mysingleton2.a); // 1
        System.out.println(mysingleton2.b); // 1
    }
}

class Singleton1 {
    //类中的静态块static块也是顺序地从上到下执行的
    public static Singleton1 singleton = new Singleton1();
    public static int a;
    public static int b = 0;

    private Singleton1() {
        super();
        a++;
        b++;
    }

    public static Singleton1 GetInstence() {
        return singleton;
    }

}

class Singleton2 {

    public static int a;
    public static int b = 0;
    public static Singleton2 singleton = new Singleton2();

    private Singleton2() {
        super();
        a++;
        b++;
    }

    public static Singleton2 GetInstence() {
        return singleton;
    }

}


/**

 1. 类在JVM中的工作原理
 要想使用一个Java类为自己工作，必须经过以下几个过程
 1)：类加载load：从字节码二进制文件——.class文件将类加载到内存，从而达到类的从硬盘上到内存上的一个迁移，所有的程序必须加载到内存才能工作。将内存中的class放到运行时数据区的方法区内，之后在堆区建立一个java.lang.Class对象，用来封装方法区的数据结构。这个时候就体现出了万事万物皆对象了，干什么事情都得有个对象。就是到了最底层究竟是鸡生蛋，还是蛋生鸡呢?类加载的最终产物就是堆中的一个java.lang.Class对象。
 2)：连接：连接又分为以下小步骤
 验证：出于安全性的考虑，验证内存中的字节码是否符合JVM的规范，类的结构规范、语义检查、字节码操作是否合法、这个是为了防止用户自己建立一个非法的XX.class文件就进行工作了，或者是JVM版本冲突的问题，比如在JDK6下面编译通过的class(其中包含注解特性的类)，是不能在JDK1.4的JVM下运行的。
 准备：将类的静态变量进行分配内存空间、初始化默认值。(对象还没生成呢，所以这个时候没有实例变量什么事情)
 解析：把类的符号引用转为直接引用(保留)
 3)：类的初始化： 将类的静态变量赋予正确的初始值，这个初始值是开发者自己定义时赋予的初始值，而不是默认值。
 2. 类的主动使用与被动使用
 以下是视为主动使用一个类，其他情况均视为被动使用!
 1)：初学者最为常用的new一个类的实例对象(声明不叫主动使用)
 2)：对类的静态变量进行读取、赋值操作的。
 3)：直接调用类的静态方法。
 4)：反射调用一个类的方法。
 5)：初始化一个类的子类的时候，父类也相当于被程序主动调用了(如果调用子类的静态变量是从父类继承过来并没有复写的，那么也就相当于只用到了父类的东东，和子类无关，所以这个时候子类不需要进行类初始化)。
 6)：直接运行一个main函数入口的类。
 所有的JVM实现(不同的厂商有不同的实现，有人就说IBM的实现比Sun的要好……)在首次主动调用类和接口的时候才会初始化他们。

 */
