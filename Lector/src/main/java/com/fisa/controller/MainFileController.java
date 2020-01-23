package com.fisa.controller;

import com.fisa.model.LineCode;
import com.fisa.model.MainFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFileController {
    MainFile mainFile = new MainFile();
    DictionaryController dictionaryController = new DictionaryController();
    final Logger log = Logger.getLogger(MainFileController.class.getName());

    public boolean errorSentence(String file){
        readMainFile(file);
        for(LineCode error : mainFile.getLineCodeList()){
            if(!error.isValidate()){
                System.out.println("I dont have idea in line" + error.getCode());
            }
        }
        return true;
    }

    public boolean readMainFile(String file){
        readFileText(file);
        System.out.println("RESPUESTAS: ");
        for(LineCode line : mainFile.getLineCodeList()){
            String code = line.getCode();
            dictionaryController.assignValueToWord(code);
                if(dictionaryController.assignValueToWord(code)){ line.setValidate(true); }
                if(dictionaryController.getValueOfProduct(code)){ line.setValidate(true);}
                if(dictionaryController.conversionQuery(code)){ line.setValidate(true);}
                if(dictionaryController.productQuery(code)){ line.setValidate(true);}
            }
        return true;
    }

    public boolean readFileText(String file){
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int numLinea = 1;
            System.out.println("ARCHIVO DE ENTRADA: " + file);
            while((linea = br.readLine()) != null){
                System.out.println(linea);
                mainFile.insertLine(numLinea , linea);
                numLinea++;
            }
            fr.close();
        }catch (Exception e){
            log.log(Level.WARNING,e.getMessage());
        }
        return true;
    }
}
