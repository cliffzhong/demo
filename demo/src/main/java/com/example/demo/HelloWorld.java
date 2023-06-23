package com.example.demo;

import com.example.demo.controller.Hello;

public class HelloWorld extends Hello {
    private String myName;

//    public HelloWorld(int aaa, String name) {
//        ///
//    }
//    public HelloWorld() {
//        //...
//    }

    /*
     * No.1 thing to do, private a constructor or constructors
     */
    private HelloWorld(int aaa, String name) {}
    private HelloWorld() {}
//    public HelloWorld() {    }

    /*
     * No.2 create a private static class variable to itself
     */
//    private static HelloWorld singletonHelloWorld;   // = new HelloWorld(10, "Mike");
    private static HelloWorld singletonHelloWorld = new HelloWorld(10, "Mike");

    /*
     * No3. create a public static method to return HelloWorld instance
     */
    public static HelloWorld getInstance() {
//        if(singletonHelloWorld == null)
//            singletonHelloWorld = new HelloWorld(10, "Mike");
        return singletonHelloWorld;
    }


    public void sayHello(String name) {

        System.out.println("Hello " + name);
    }

    public String greeting(String name) {

        return "How are you doing? " + name;
    }

    public int addNumbers(int num1, int num2) {
        return num1 + num2;
    }

    public boolean isOldEnough(int age) {
        boolean oldFlag = false;
        if(age > 60)
            oldFlag = true;
        return oldFlag;
    }

    public String getGoodName(String name) {
        String goodName = null;
        if(name.contains("Mo") || name.contains("Nate"))
            goodName = name;
        return goodName;
    }

}
