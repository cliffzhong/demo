package com.example.demo.service;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

public class ColorBagServiceTest {

    private ColorBagService colorBagService;

    @BeforeAll
    public static void initAll() {

    }

    @AfterAll
    public static void teardownAll() {

    }

    @BeforeEach
    public void setupEach() {
        colorBagService = new ColorBagService();
        colorBagService.add("green");
        colorBagService.add("blue");
        colorBagService.add("red");
        colorBagService.add("yellow");
        colorBagService.add("purple");


    }

    @AfterEach
    public void cleanupEach() {
        colorBagService = null;
    }

    @Test
    public void testSize() {
        int size = colorBagService.size();
        assertEquals(5, size, "the original size should be 5");
        colorBagService.add("pink");
        size = colorBagService.size();
        assertEquals(6, size, "The new size should be 6");

    }

    @Test
    public void testRemove() {
        String testColor = "yellow";
        boolean colorExistingFlag = colorBagService.contains(testColor);
        assertTrue(colorExistingFlag, testColor + " should be in the original bag");
        colorBagService.remove(testColor);
        colorExistingFlag = colorBagService.contains(testColor);
        assertFalse(colorExistingFlag, testColor + " is removed already");
    }

    @Test
    public void testAdd() {
        String testColor = "brown";
        boolean colorExistingFlag = colorBagService.contains(testColor);
        assertFalse(colorExistingFlag, "Should not contain " + testColor);
        colorBagService.add(testColor);
        colorExistingFlag = colorBagService.contains(testColor);
        assertTrue(colorExistingFlag, testColor + " should be added");
    }

    @Test
    public void testContains() {
        String testColor = "yellow";
        boolean colorExistingFlag = colorBagService.contains(testColor);
        assertTrue(colorExistingFlag, testColor + " not found");
    }

    @Test
    public void testToList() {
        List<String> originList = Arrays.asList("green", "blue", "red", "yellow", "purple");
        List<String> testList = colorBagService.toList();
        assertThat(originList).containsExactlyInAnyOrderElementsOf(testList);

    }
}
