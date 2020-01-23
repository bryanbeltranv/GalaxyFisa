package com.fisa;


import com.fisa.controller.MainFileController;

public class Main {
        static final String FILE_PATH = "GalaxyMain/src/main/resources/input.txt";

    public static void main(String[] args) {
        MainFileController file = new MainFileController();
        file.errorSentence(FILE_PATH);
    }
}
