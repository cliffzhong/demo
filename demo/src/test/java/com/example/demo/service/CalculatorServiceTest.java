package com.example.demo.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeAll
    public static void initAll(){

    }

    @AfterAll
    public static void teardownAll(){

    }

    @BeforeEach
    public void setupEach(){
        calculatorService = new CalculatorService();
    }

    @AfterEach
    public void cleanupEach(){
        calculatorService = null;

    }

    @Test
    public void testMinus(){
        int expectedResult = 3;
        int result = calculatorService.minus(10,7);
        assertEquals(expectedResult, result, "10 - 7 should be 3");
    }

    @Test
    public void testSum(){
        int result = calculatorService.sum(10,7);
        assertEquals(17, result, "Sum of 10 and 7 should be 17");
    }

    @Test
    public void testAdd(){
        int result = calculatorService.add(10,7);
        assertEquals(17, result, "10 + 7 should be 17");
    }

    @Test
    public void testDivide(){
        int result = calculatorService.divide(10,5);
        assertEquals(2, result, "10 / 5 should be 2");
    }

    @Test
    public void testDivideByZeroThrowArithmetic(){
        String exceptionMessage = "Cannot be divided by 0";
        Exception exception = assertThrows(ArithmeticException.class,() -> calculatorService.divide(1,0));
        assertEquals(exceptionMessage, exception.getMessage());
        assertTrue(exception.getMessage().contains(exceptionMessage));
    }

    ///@Test
    public void testDivideByZeroThrowArithmeticSecondTry(){
        String exceptionMessage = "Cannot be divided by 0";
        ///try{
            calculatorService.divide(1,0);

        ///};catch{

        }
    ///}

    @Test
    public void testMultiply(){
        int result = calculatorService.multiply(10,5);
        assertEquals(50, result, "10 * 5 should be 50");
    }
}
