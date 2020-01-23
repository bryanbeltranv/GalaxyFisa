package com.fisa.controller;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class DictionaryControllerTest {
    private static DictionaryController dictionaryController;
    final Logger log = Logger.getLogger(DictionaryControllerTest.class.getName());

    @BeforeClass
    public static void beforeClass() {
        dictionaryController = new DictionaryController();
    }

    @Test
    public void traslateWordsToValueTest() {
        log.log(Level.FINE,"traslateWordsToValueTest");
        assertEquals("Error traslateWordsToValueTest", true, (dictionaryController.traslateWordsToValue("GLOP GLOP SPOK")));
    }
    @Test
    public void getValueOfProductTest() {
        log.log(Level.FINE,"getValueOfProductTest");
        assertEquals("Error getValueOfProductTest", true, (dictionaryController.getValueOfProduct("GLOP GLOP SPOK SILVER IS 930 CREDITS")));
    }

    @Test
    public void assignValueToWordTest() {
        log.log(Level.FINE,"assignValueToWordTest");
        assertEquals("Error assignValueToWordTest", true, (dictionaryController.assignValueToWord("TAKA IS C")));
    }

    @Test
    public void conversionQueryTest() {
        log.log(Level.FINE,"conversionQueryTest");
        assertEquals("Error conversionQueryTest", true, (dictionaryController.conversionQuery("HOW MUCH IS GLOP GLOP SPOK ?")));
    }

    @Test
    public void productQueryTest() {
        log.log(Level.FINE,"productQueryTest");
        assertEquals("Error productQueryTest", true, (dictionaryController.productQuery("HOW MANY CREDITS IS GLOP GLOP SPOK SILVER ?")));
    }
}
