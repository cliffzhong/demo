package com.example.demo;

public class Todo {

    //No.1 thing to do, private constructor(s)
//    private Singleton(){
//
//    }
//

    //No.2 create a private static class variable to itself

    private static Singleton singleton1;// = new Singleton();


    //No.3 create a public static method to return Singleton instance

    public static Singleton getInstance(){
        if(singleton1 == null) // this is lazy initialization, race condition can happen
            singleton1 = new Singleton();
        // silence above 2 and un silence No.2, realize eager initialization
        return singleton1;

    }

    /*
     * No.1 thing to do, private a constructor or constructors
     */

    /*
     * No.2 create a private static class variable to itself
     */

    /*
     * No3. create a public static method to return HelloWorld instance
     */

}
