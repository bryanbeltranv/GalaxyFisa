package com.fisa.controller;

import com.fisa.model.LineCode;
import com.fisa.model.MainFile;

import java.io.BufferedReader;
import java.io.FileReader;

public class MainFileController {
    MainFile mainFile = new MainFile();
    DictionaryController DC = new DictionaryController();

    public boolean errorSentence(String file){
        readMainFile(file);
        for(LineCode error : mainFile.getLineCodeMap()){
            if(!error.isValidate()){
                System.out.println("I dont have idea in line" + error.getCode());
            }
        }
        return true;
    }

    public boolean readMainFile(String file){
        readFileText(file);
        for(LineCode line : mainFile.getLineCodeMap()){
            String code = line.getCode();
            DC.assignValueToWord(code);
                if(DC.assignValueToWord(code)){ line.setValidate(true); }
                if(DC.getValueOfProduct(code)){ line.setValidate(true);}
                if(DC.conversionQuery(code)){ line.setValidate(true);}
                if(DC.productQuery(code)){ line.setValidate(true);}
            }
        return true;
    }

    public boolean isDeclarateOrder(String sentence){
        String[] array =  sentence.split(" ");
        int pos = 0;
        for(int i = 0; i < array.length ; i++){
            if((pos+2)<array.length){
                if(!DC.dictionary.TokensMap.get(array[i]).getType().equals("word")){
                    if(DC.dictionary.TokensMap.get(array[i+1]).getType().equals("assignment")){
                        if(!DC.dictionary.TokensMap.get(array[i+2]).getType().equals("word")){
                            return true;
                        }
                    }
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isOrderQuery(String sentence){
        String[] array =  sentence.split(" ");
        for(int i = 0; i < array.length ; i++){
            if(i+3<array.length){
                if(DC.dictionary.TokensMap.get(array[i]).getType().equals("query")){
                    if(DC.dictionary.TokensMap.get(array[i+1]).getType().equals("query")){
                        if(DC.dictionary.TokensMap.get(array[i+2]).getType().equals("assignment")
                        || DC.dictionary.TokensMap.get(array[i+2]).getType().equals("currency")){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean readFileText(String fichero){
        try{
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int numLinea = 1;
            while((linea = br.readLine()) != null){
                System.out.println(linea);
                mainFile.insertLine(numLinea , linea);
                numLinea++;
            }
            fr.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
