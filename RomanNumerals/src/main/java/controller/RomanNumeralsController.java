package controller;

import lombok.Getter;
import model.RomanNumber;
import model.RomanNumerals;
import java.util.ArrayList;

@Getter

public class RomanNumeralsController {
    RomanNumerals romanNumeralsFinal = new RomanNumerals();
    ArrayList <RomanNumber> listRomanNumberValues = new ArrayList<>();


    public boolean validRomanNumeralStructure(String sentence){
        if(romanNumeralSemanticValidator(sentence) && (validateOrderOfRomanNumeralValues())){
                return getSumOfListRomanNumerals();
        }
        return false;
    }
    public boolean getSumOfListRomanNumerals(){
        int acum = 0;
        for(RomanNumber romanNumber :listRomanNumberValues){
            acum = acum +  romanNumber.getValue();
        }
        romanNumeralsFinal.setFinalValue(acum);
        return true;
    }


    public boolean validateOrderOfRomanNumeralValues(){
        boolean validate = true;
        for(int i = 0 ; i <= listRomanNumberValues.size(); i++){
            if(i+1<listRomanNumberValues.size()){
                int firstValue = listRomanNumberValues.get(i).getValue();
                int secondValue = listRomanNumberValues.get(i+1).getValue();
                if(firstValue<secondValue){
                    validate = false;
                    break;
                }
            }
        }
        return validate;
    }

    public boolean romanNumeralSemanticValidator(String sentence){
        ArrayList listRomanNumerals = new ArrayList();
        listRomanNumberValues.clear();
        if(validateMaximumNumberOfRepetitions(sentence)) {
            sentence.chars().forEach((c -> listRomanNumerals.add((char) c)));
            for (int i = 0; i < listRomanNumerals.size(); i++) {
                String first = "" + listRomanNumerals.get(i);
                if ((i + 1) < listRomanNumerals.size()) {
                    String second = "" + listRomanNumerals.get(i + 1);
                    if (orderNumberMayorMinor(first, second)) {
                        insertFirstRomanNumber(first);
                    } else {
                        if (first.equals(second)) {
                            if ((i + 2) < listRomanNumerals.size()) {
                                String third = "" + listRomanNumerals.get(i + 2);
                                if (first.equals(third)) {
                                    insert3ValuesRomanNumber(first , second , third);
                                    i = i + 2;
                                } else {
                                    insert2ValuesRomanNumber(first , second);
                                    i = i + 1;
                                }
                            } else {
                                insert2ValuesRomanNumber(first , second);
                                i = i + 1;
                            }
                        } else {
                            if (subtractionAnalyzer(first, second)) {
                                insertSubtractionValuesRomanNumber(first,second);
                                i = i + 1;
                            } else {
                                return false;
                            }
                        }
                    }
                } else {
                    insertFirstRomanNumber(first);
                }
            }
        }else{
            return false;
        }
        return true;
    }

    public void insertFirstRomanNumber(String first){
        RomanNumber romanNumber = new RomanNumber();
        romanNumber.setSymbol(first);
        romanNumber.setValue(romanNumeralsFinal.getValueRomanNumber(first));
        listRomanNumberValues.add(romanNumber);
    }

    public void insertSubtractionValuesRomanNumber(String first,String second){
        RomanNumber romanNumber = new RomanNumber();
        romanNumber.setSymbol(first+second);
        romanNumber.setValue(romanNumeralsFinal.getValueRomanNumber(second) - romanNumeralsFinal.getValueRomanNumber(first));
        listRomanNumberValues.add(romanNumber);
    }

    public void insert2ValuesRomanNumber(String first,String second){
        RomanNumber romanNumber = new RomanNumber();
        romanNumber.setSymbol(first+second);
        romanNumber.setValue(romanNumeralsFinal.getValueRomanNumber(first)+romanNumeralsFinal.getValueRomanNumber(second));
        listRomanNumberValues.add(romanNumber);
    }

    public void insert3ValuesRomanNumber(String first,String second, String third){
        RomanNumber romanNumber = new RomanNumber();
        romanNumber.setSymbol(first+second+third);
        romanNumber.setValue(romanNumeralsFinal.getValueRomanNumber(first)+romanNumeralsFinal.getValueRomanNumber(second)+romanNumeralsFinal.getValueRomanNumber(third));
        listRomanNumberValues.add(romanNumber);
    }

    public boolean validateMaximumNumberOfRepetitions(String sentence) {
        for (String symbol : romanNumeralsFinal.getSymbols()) {
            long repeat = repeatedSymbols(sentence, symbol);
            if ((symbol.contains("I")) || (symbol.contains("X")) || (symbol.contains("C")) || (symbol.contains("M")))  {
               switch ((int) repeat){
                   case(3):
                       return ruleRepetition3LowerValue(sentence);
                   case(4):
                       return ruleRepetition4LowerValue(sentence);
               }
                if(repeat>4){
                    return false;
                }
            }
            if(symbol.contains("V") || (symbol.contains("L")) || (symbol.contains("D")))  {
                if(repeat>1){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean ruleRepetition3LowerValue(String sentence){
        ArrayList listRomanNumerals = new ArrayList();
        sentence.chars().forEach((c -> listRomanNumerals.add((char) c)));
        for(int i = 0; i < listRomanNumerals.size(); i++) {
            if ((i + 4) < listRomanNumerals.size()) {
                String pos1 = "" + listRomanNumerals.get(i);
                String pos2 = "" + listRomanNumerals.get(i + 2);
                String pos3 = "" + listRomanNumerals.get(i + 3);
                String pos4 = "" + listRomanNumerals.get(i + 4);
                if(pos1.equals(pos2) && pos2.equals(pos3) && pos3.equals(pos4)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean ruleRepetition4LowerValue(String sentence){
        ArrayList listRomanNumerals = new ArrayList();
        sentence.chars().forEach((c -> listRomanNumerals.add((char) c)));
        for(int i = 0; i < listRomanNumerals.size(); i++){
            if((i+4)< listRomanNumerals.size()) {
                String pos1 = "" + listRomanNumerals.get(i);
                String pos2 = "" + listRomanNumerals.get(i + 1);
                String pos3 = "" + listRomanNumerals.get(i + 2);
                String pos4 = "" + listRomanNumerals.get(i + 3);
                String pos5 = "" + listRomanNumerals.get(i + 4);
                if(pos1.equals(pos2) && pos2.equals(pos3) && pos3.equals(pos4)){
                    return false;
                }else{
                    if ((pos1.equals(pos2) && pos2.equals(pos3)) &&(romanNumeralsFinal.getValueRomanNumber(pos4) >romanNumeralsFinal.getValueRomanNumber(pos5))){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public long repeatedSymbols(String sentence, String symbol) {
           return  sentence.chars()
                    .mapToObj(i -> (char) i)
                    .filter(l -> l == symbol.charAt(0))
                    .count();
    }
    public boolean orderNumberMayorMinor(String firstSymbol, String secondSymbol){
        return (romanNumeralsFinal.getValueRomanNumber(firstSymbol) > romanNumeralsFinal.getValueRomanNumber(secondSymbol));
    }

    public boolean subtractionAnalyzer(String firstSymbol, String secondSymbol){
        if(firstSymbol.equals("I")){ return (secondSymbol.equals("V") || secondSymbol.equals("X"));
        }
        if(firstSymbol.equals("X")){ return (secondSymbol.equals("L") || secondSymbol.equals("C"));
        }
        if(firstSymbol.equals("C")){ return (secondSymbol.equals("D") || secondSymbol.equals("M"));
        }
        return false;
    }
}
