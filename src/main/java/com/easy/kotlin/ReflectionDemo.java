/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

interface StudentService<T> {
    List<T> findStudents(String name, Integer age);
}

public class ReflectionDemo {

    public static void main(String[] args) {
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.save(new Student("Bob", 20));
        studentService.findStudents("Jack", 20);

        // 反射API调用示例
        final Class<? extends StudentServiceImpl> studentServiceClass = studentService.getClass();
        Class<?>[] classes = studentServiceClass.getDeclaredClasses();
        Annotation[] annotations = studentServiceClass.getAnnotations();
        ClassLoader classLoader = studentServiceClass.getClassLoader(); // Returns the class loader for the class
        Field[] fields = studentServiceClass.getDeclaredFields(); // 获取类成员变量
        Method[] methods = studentServiceClass.getDeclaredMethods(); // 获取类成员方法
        try {
            methods[0].getName(); // save
            methods[0].invoke(studentService, "Jack",20);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}

class StudentServiceImpl extends BaseService<Student> implements StudentService<Student> {

    public List<Student> findStudents(String name, Integer age) {
        return Arrays.asList(new Student[] {new Student("Jack", 20), new Student("Rose", 20)});
    }

    @Override
    public int save(Student student) {
        return 0;
    }
}

abstract class BaseService<T> {
    abstract int save(T t);
}

class Student {

    String name;
    Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
