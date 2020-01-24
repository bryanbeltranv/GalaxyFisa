package controller;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;


public class RomanNumeralsControllerTest {

    private static RomanNumeralsController romanNumeralsController;
    final Logger log = Logger.getLogger(RomanNumeralsControllerTest.class.getName());
    static final String ROMAN_NUMBER_TEST = "MMMCMXXIX";

    @BeforeClass
    public static void beforeClass() {
        romanNumeralsController = new RomanNumeralsController();
    }

    @Test
    public void subtractionAnalyzerTest() {
        log.log(Level.FINE,"subtractionAnalyzerTest");
        assertEquals("Error subtractionAnalyzerTest", true, (romanNumeralsController.subtractionAnalyzer("I", "X")));
    }

    @Test
    public void orderNumberMayorMinorTest() {
        log.log(Level.FINE,"orderNumberMayorMinor");
        assertEquals("Error orderNumberMayorMinor", true, (romanNumeralsController.orderNumberMayorMinor("M", "I")));
    }

    @Test
    public void validateMaximumNumberOfRepetitionsTest() {
        log.log(Level.FINE,"validateMaximumNumberOfRepetitionsTest");
        assertEquals("Error validateMaximumNumberOfRepetitionsTest", true, (romanNumeralsController.validateMaximumNumberOfRepetitions(ROMAN_NUMBER_TEST)));
    }
    @Test
    public void ruleRepetition3LowerValueTest() {
        log.log(Level.FINE,"ruleRepetition3LowerValueTest");
        assertEquals("Error ruleRepetition3LowerValueTest", true, (romanNumeralsController.ruleRepetition3LowerValue(ROMAN_NUMBER_TEST)));
    }

    @Test
    public void ruleRepetition4LowerValueTest() {
        log.log(Level.FINE,"ruleRepetition4LowerValueTest");
        assertEquals("Error ruleRepetition4LowerValueTest", true, (romanNumeralsController.ruleRepetition4LowerValue(ROMAN_NUMBER_TEST)));
    }

    @Test
    public void romanNumeralSemanticValidatorTest() {
        log.log(Level.FINE,"RomanNumeralSemanticValidatorTest");
        assertEquals("Error RomanNumeralSemanticValidatorTest", true, (romanNumeralsController.romanNumeralSemanticValidator(ROMAN_NUMBER_TEST)));
    }

    @Test
    public void validRomanNumeralStructureTest() {
        log.log(Level.FINE,"validRomanNumeralStructureTest");
        assertEquals("Error validRomanNumeralStructureTest", true, (romanNumeralsController.validRomanNumeralStructure(ROMAN_NUMBER_TEST)));
    }

}
