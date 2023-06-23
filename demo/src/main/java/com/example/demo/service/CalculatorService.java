package com.example.demo.service;

import com.example.demo.DemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    public int sum(int a, int b) {
        return a + b;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) {
//        return a / b;
        if(b != 0)
            return a / b;
        else
            throw new ArithmeticException("cannot be / by zero");

        //dfdsfdsf
        //if else
    }

    public int multiply(int a, int b) {
        return a * b;
    }

}
