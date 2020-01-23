package com.fisa.controller;

import com.fisa.model.Dictionary;
import controller.RomanNumeralsController;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DictionaryController {

    final Logger log = Logger.getLogger(DictionaryController.class.getName());
    Dictionary dictionary = new Dictionary();
    RomanNumeralsController romanNumeralsController = new RomanNumeralsController();
    String sentenceCurrency = " ";
    int currencyValueTransformed = 0;

    public boolean traslateWordsToValue(String sentence){
        String[] array =  sentence.split(" ");
        StringBuilder romanNumeralAcum = new StringBuilder();
        for(String s : array){
            if(isWordToken(s)) {
                romanNumeralAcum.append(dictionary.wordsMap.get(s).getTraslation());
            }
        }
        String romanNumeral = romanNumeralAcum.toString();
        romanNumeralsController.validRomanNumeralStructure(romanNumeral);
        currencyValueTransformed = romanNumeralsController.getRomanNumeralsFinal().getFinalValue();
        return true;
    }

    public boolean assignValueToWord(String sentence){
        romanNumeralsController.getListRomanNumberValues().clear();
        String[] array =  sentence.split(" ");
        int pos = 0;
        if((pos+2)<array.length){
            String word = array [pos];
            String assign = array[pos+1];
            String romanSymbol = array[pos+2];
            if(!isWordToken(word) && (isAssignToken(assign)) && (isRomanSymbol(romanSymbol))) {
                dictionary.insertWord(word,romanSymbol);
                System.out.println("Value of Word : " + word + " as " + romanSymbol);
            }
        }
        return true;
    }

    public boolean productQuery(String sentence){
        romanNumeralsController.getListRomanNumberValues().clear();
        try{
            String[] array = sentence.split(" ");
            int pos = 0;
            String how = array[pos];
            String many = array[pos + 1];
            String credits = array[pos + 2];
            String is = array[pos+3];
            if (isQueryToken(how) && (isQueryToken(many)) && (isCurrencyToken(credits)) && (isAssignToken(is))) {
                int wordPos = pos + 4;
                String currencyText = "" + array[wordPos];
                while (isWordToken(array[wordPos + 1])) {
                    wordPos = wordPos + 1;
                    currencyText = currencyText + " " + array[wordPos];
                }
                String product = array[wordPos + 1];
                if (existProductToken(product) && (isQueryToken(array[wordPos+2]))){
                        getSentenceCurrency(0, currencyText);
                        traslateWordsToValue(sentenceCurrency);
                        double valProduct = getValueProductUnique(array[wordPos + 1]);
                        System.out.println(currencyText +" "+ product +"  is : " + currencyValueTransformed * valProduct + " credits");
                }
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean conversionQuery(String sentence) {
        romanNumeralsController.getListRomanNumberValues().clear();
        String[] array = sentence.split(" ");
        int pos = 0;
        String how = array[pos];
        try {
            String many = array[pos + 1];
            String is = array[pos + 2];
            if (isQueryToken(how) && (isQueryToken(many)) && (isAssignToken(is))){
                int wordPos = pos + 3;
                String currencyText = "" + array[wordPos];
                while (isWordToken(array[wordPos + 1])) {
                    wordPos = wordPos + 1;
                    currencyText = currencyText + " " + array[wordPos];
                }
                if (isQueryToken(array[wordPos + 1])) {
                    getSentenceCurrency(0, currencyText);
                    traslateWordsToValue(sentenceCurrency);
                    System.out.println(currencyText + " is : " + currencyValueTransformed);
                }
            }
        }catch (Exception e){
            return false;
        }
    return true;
    }

    public boolean getValueOfProduct(String sentence){
        romanNumeralsController.getListRomanNumberValues().clear();
        String[] array =  sentence.split(" ");
        int pos = getSentenceCurrency(0,sentence) + 1;
        traslateWordsToValue(sentenceCurrency);
        if((pos+3)<array.length){
            String product = array[pos];
            String assignment = array[pos+1];
            String value = array[pos+2];
            String currency = array[pos+3];
            if( !existProductToken(product) && isAssignToken(assignment) &&  isValueToken(value) && isCurrencyToken(currency) ) {
                    double valueDouble = Double.parseDouble(value);
                    double productValue = valueDouble / currencyValueTransformed;
                    dictionary.insertProduct(product, productValue);
                    System.out.println("Value of Product :" + product + " as " + productValue + "");
                }
        }
        return true;
    }


    public double getValueProductUnique(String product){
       return dictionary.productsMap.get(product).getValue();
    }

    public int getSentenceCurrency(int initialPos, String sentence){
        sentenceCurrency = "";
        String[] array =  sentence.split(" ");
        int pos = initialPos;
        for(int s = pos; s < array.length ; s++){
           try {
               String word = array[s];
               if (isWordToken(word)){
                   sentenceCurrency = sentenceCurrency + " " + word;
                   pos = s;
               }
           }catch(Exception e){
               log.log(Level.INFO,"Not found token");
           }
        }
        return pos;
    }

    public boolean isQueryToken(String token){
        try {
            return dictionary.tokensMap.get(token).getType().equals("query");
        }catch (Exception e){
            return false;
        }
    }

    public boolean isWordToken(String token){
        try {
            return dictionary.tokensMap.get(token).getType().equals("word");
        }catch (Exception e){
            return false;
        }
    }
    public boolean existProductToken(String token){
        try {
            return dictionary.tokensMap.get(token).getType().equals("product");
        }catch (Exception e){
            return false;
        }
    }

    public boolean isAssignToken(String token){
        try {
            return dictionary.tokensMap.get(token).getType().equals("assignment");
        }catch (Exception e){
            return false;
        }
    }

    public boolean isValueToken(String token){
        if (token.matches("\\d*")){
            return true;
        }
        return true;
    }

    public boolean isCurrencyToken(String token){
        try {
            return dictionary.tokensMap.get(token).getType().equals("currency");
        }catch (Exception e){
            return false;
        }
    }

    public boolean isRomanSymbol(String token){
        try {
             romanNumeralsController.getRomanNumeralsFinal().getRomanNumeralsMap().get(token);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
