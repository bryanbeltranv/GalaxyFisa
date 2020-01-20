package com.fisa;

import com.fisa.controller.DictionaryController;
import com.fisa.controller.MainFileController;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainFileControllerTest {
    private static MainFileController mainFileController;
    @BeforeClass
    public static void beforeClass() {
        mainFileController = new MainFileController();
    }

    @Test
    public void readFileTextTest() {
        System.out.println("readFileTextTest");
        assertEquals("Error readFileTextTest", true, (mainFileController.readFileText("src/main/java/com/fisa/controller/texto.txt")));
    }
    @Test
    public void readMainFileTest() {
        System.out.println("readMainFileTest");
        assertEquals("Error readMainFileTest", true, (mainFileController.readMainFile("src/main/java/com/fisa/controller/texto.txt")));
    }
    @Test
    public void errorSentenceTest() {
        System.out.println("errorSentenceTest");
        assertEquals("Error errorSentenceTest", true, (mainFileController.errorSentence("src/main/java/com/fisa/controller/texto.txt")));
    }
}
