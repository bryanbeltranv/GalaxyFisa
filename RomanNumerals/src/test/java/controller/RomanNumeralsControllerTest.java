package controller;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RomanNumeralsControllerTest {

    private static RomanNumeralsController romanNumeralsController;

    @BeforeClass
    public static void beforeClass() {
        romanNumeralsController = new RomanNumeralsController();
    }

    @Test
    public void subtractionAnalyzerTest() {
        System.out.println("subtractionAnalyzerTest");
        assertEquals("Error subtractionAnalyzerTest", true, (romanNumeralsController.subtractionAnalyzer("I", "X")));
    }

    @Test
    public void orderNumberMayorMinorTest() {
        System.out.println("orderNumberMayorMinor");
        assertEquals("Error orderNumberMayorMinor", true, (romanNumeralsController.orderNumberMayorMinor("M", "I")));
    }

    @Test
    public void validateMaximumNumberOfRepetitionsTest() {
        System.out.println("validateMaximumNumberOfRepetitionsTest");
        assertEquals("Error validateMaximumNumberOfRepetitionsTest", true, (romanNumeralsController.validateMaximumNumberOfRepetitions("XXIX")));
    }
    @Test
    public void ruleRepetition3LowerValueTest() {
        System.out.println("ruleRepetition3LowerValueTest");
        assertEquals("Error ruleRepetition3LowerValueTest", true, (romanNumeralsController.ruleRepetition3LowerValue("CCC")));
    }

    @Test
    public void ruleRepetition4LowerValueTest() {
        System.out.println("ruleRepetition4LowerValueTest");
        assertEquals("Error ruleRepetition4LowerValueTest", true, (romanNumeralsController.ruleRepetition4LowerValue("XXXIX")));
    }

    @Test
    public void RomanNumeralSemanticValidatorTest() {
        System.out.println("RomanNumeralSemanticValidatorTest");
        assertEquals("Error RomanNumeralSemanticValidatorTest", true, (romanNumeralsController.RomanNumeralSemanticValidator("MCCXXIX")));
    }

    @Test
    public void validRomanNumeralStructureTest() {
        System.out.println("validRomanNumeralStructureTest");
        assertEquals("Error validRomanNumeralStructureTest", true, (romanNumeralsController.validRomanNumeralStructure("MCCXXIX")));
    }
}
