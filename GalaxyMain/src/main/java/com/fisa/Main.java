package com.fisa;


import com.fisa.controller.MainFileController;

public class Main {
    public static void main(String[] args) {
        MainFileController file = new MainFileController();
        file.errorSentence("/home/bryanbeltran/Documentos/GalaxyFisa/GalaxyMain/src/main/resources/texto.txt");
    }
}
