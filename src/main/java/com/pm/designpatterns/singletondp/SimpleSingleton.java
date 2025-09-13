package com.pm.designpatterns.singletondp;
// Singleton Design Pattern : to create a class which can only have one object
// 1. create a private constructor.
// 2. create a static instance that returns the same instance every time.

public class SimpleSingleton {
    private static SimpleSingleton instance = null;

    private SimpleSingleton() {
        System.out.println("Singleton Constructor called");
    }

    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        SimpleSingleton s1 = SimpleSingleton.getInstance();
        SimpleSingleton s2 = SimpleSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}