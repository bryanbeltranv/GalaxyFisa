package com.fisa;

import com.fisa.controller.MainFileController;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class MainFileControllerTest {
    private static MainFileController mainFileController;
    final Logger log = Logger.getLogger(MainFileControllerTest.class.getName());
    static final String FILE_PATH = "src/main/resources/texto.txt";

    @BeforeClass
    public static void beforeClass() {
        mainFileController = new MainFileController();
    }

    @Test
    public void readFileTextTest() {
        log.log(Level.FINE,"readFileTextTest");
        assertEquals("Error readFileTextTest", true, (mainFileController.readFileText(FILE_PATH)));
    }
    @Test
    public void readMainFileTest() {
        log.log(Level.FINE,"readMainFileTest");
        assertEquals("Error readMainFileTest", true, (mainFileController.readMainFile(FILE_PATH)));
    }
    @Test
    public void errorSentenceTest() {
        log.log(Level.FINE,"errorSentenceTest");
        assertEquals("Error errorSentenceTest", true, (mainFileController.errorSentence(FILE_PATH)));
    }
}
