package com.fisa.controller;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DictionaryControllerTest {
    private static DictionaryController dictionaryController;

    @BeforeClass
    public static void beforeClass() {
        dictionaryController = new DictionaryController();
    }

    @Test
    public void traslateWordsToValueTest() {
        System.out.println("traslateWordsToValueTest");
        assertEquals("Error traslateWordsToValueTest", true, (dictionaryController.traslateWordsToValue("GLOP GLOP SPOK")));
    }
    @Test
    public void getValueOfProductTest() {
        System.out.println("getValueOfProductTest");
        assertEquals("Error getValueOfProductTest", true, (dictionaryController.getValueOfProduct("GLOP GLOP SPOK SILVER IS 930 CREDITS")));
    }

    @Test
    public void assignValueToWordTest() {
        System.out.println("assignValueToWordTest");
        assertEquals("Error assignValueToWordTest", true, (dictionaryController.assignValueToWord("TAKA IS C")));
    }

    @Test
    public void conversionQueryTest() {
        System.out.println("conversionQueryTest");
        assertEquals("Error conversionQueryTest", true, (dictionaryController.conversionQuery("HOW MUCH IS GLOP GLOP SPOK ?")));
    }

    @Test
    public void productQueryTest() {
        System.out.println("productQueryTest");
        assertEquals("Error productQueryTest", true, (dictionaryController.productQuery("HOW MANY CREDITS IS GLOP GLOP SPOK SILVER ?")));
    }
}
