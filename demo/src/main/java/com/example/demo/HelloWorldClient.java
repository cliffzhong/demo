package com.example.demo;

public class HelloWorldClient {

    public static void main(String[] args) {

//        HelloWorld helloEric = new HelloWorld();
        HelloWorld helloEric = HelloWorld.getInstance();

        helloEric.sayHello("Eric");

//        HelloWorld helloJennifer = new HelloWorld();
        HelloWorld helloJennifer = HelloWorld.getInstance();

        helloJennifer.sayHello("Jennifer");

//        HelloWorld helloLaura = new HelloWorld();
        HelloWorld helloLaura = HelloWorld.getInstance();

        helloLaura.sayHello("laura");

        if(helloEric == helloJennifer)
            System.out.println(("helloeric is the same as helloJennifer"));
        else
            System.out.println(("helloeric is NOT the same as helloJennifer"));

        if(helloLaura == helloJennifer)
            System.out.println(("helloLaura is the same as helloJennifer"));
        else
            System.out.println(("helloLaura is NOT the same as helloJennifer"));

        if(helloLaura == helloEric)
            System.out.println(("helloLaura is the same as helloEric"));
        else
            System.out.println(("helloLaura is NOT the same as helloEric"));


    }
}
