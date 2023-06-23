package com.example.demo.service;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class DepartmentServiceTest {
    private DepartmentService departmentService;

    @BeforeAll
    public static void initAll(){

    }

    @AfterAll
    public static void teardownAll(){

    }

    @BeforeEach
    public void setupEach(){
        departmentService = new DepartmentService();

    }

    @AfterEach
    public void cleanupEach(){
        departmentService = null;

    }

    @Test
    public void testFindAllDepartmentService(){

    }

    @Test
    public void testFindDepartmentByName(){

    }

    /// private void assertDepartment(){

    /// }
}
