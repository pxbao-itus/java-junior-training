package com.tma.pxbao.java_core.reflection;

// Java Program to demonstrate the Use of Reflection

// Importing required classes

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Class 1
// Of Whose object is to be created
class Test {
    // creating a private field
    private String s;
    // Public constructor
    public Test() {
        s = "Reflection";
    }
    // no arguments
    public void method1() {
        System.out.println("Method 1 is executed: The string is " + s);
    }
    // int as argument
    public void method2(int n) {
        System.out.println("\nMethod 2 is executed: The number is " + n);
    }
    // Private method
    private void method3() {
        System.out.println("Method 3 is executed: Private method invoked");
    }
}

// Class 2
// Main class
class Reflection {

    // Main driver method
    public static void main(String args[]) throws Exception {
        Test obj = new Test();
        Class cls = obj.getClass();
        System.out.println("\nThe name of class is " + cls.getName());

        // get constructor
        Constructor constructor = cls.getConstructor();
        System.out.println("The name of constructor is " + constructor.getName());

        // get all public methods
        System.out.print("The public methods of class are : ");
        Method[] methods = cls.getMethods();
        for (Method method : methods)
            System.out.print(method.getName()+ ", ");

        //execute methods without calling them include private and public method
        Method methodcall2 = cls.getDeclaredMethod("method2", int.class);
        methodcall2.invoke(obj, 19);

        Field field = cls.getDeclaredField("s");
        field.setAccessible(true);
        field.set(obj, "JAVA");
        Method methodcall1 = cls.getDeclaredMethod("method1");
        methodcall1.invoke(obj);

        Method methodcall3 = cls.getDeclaredMethod("method3");
        methodcall3.setAccessible(true);
        methodcall3.invoke(obj);
    }
}

