package controller;

import lombok.Getter;
import model.RomanNumber;
import model.RomanNumerals;
import java.util.ArrayList;

@Getter

public class RomanNumeralsController {
    RomanNumerals rN = new RomanNumerals();
    ArrayList <RomanNumber> ListRomanNumberValues = new ArrayList<RomanNumber>();

    public boolean validRomanNumeralStructure(String sentence){
        //rN.setFinalValue(0);
        if(RomanNumeralSemanticValidator(sentence)){
            if(validateOrderOfRomanNumeralValues()) {
                return getSumOfListRomanNumerals();
            }
        }
        return false;
    }
    public boolean getSumOfListRomanNumerals(){
        int acum = 0;
        for(RomanNumber romanNumber :ListRomanNumberValues){
            acum = acum +  romanNumber.getValue();
        }
        rN.setFinalValue(acum);
        return true;
    }


    public boolean validateOrderOfRomanNumeralValues(){
        boolean validate = true;
        for(int i = 0 ; i <= ListRomanNumberValues.size(); i++){
            if(i+1<ListRomanNumberValues.size()){
                int valueActual = ListRomanNumberValues.get(i).getValue();
                int valuePosterior = ListRomanNumberValues.get(i+1).getValue();
                if(valueActual<valuePosterior){
                    validate = false;
                    break;
                }
            }
        }
        return validate;
    }

    public boolean RomanNumeralSemanticValidator(String sentence){
        ArrayList listRomanNumerals = new ArrayList();
        if(validateMaximumNumberOfRepetitions(sentence)) {
            sentence.chars().forEach((c -> listRomanNumerals.add((char) c)));
            for (int i = 0; i < listRomanNumerals.size(); i++) {
                String actual = "" + listRomanNumerals.get(i);
                if ((i + 1) < listRomanNumerals.size()) {
                    String posterior = "" + listRomanNumerals.get(i + 1);
                    if (orderNumberMayorMinor(actual, posterior)) {
                        insertActualRomanNumber(actual);
                    } else {
                        if (actual.equals(posterior)) {
                            if ((i + 2) < listRomanNumerals.size()) {
                                String tercero = "" + listRomanNumerals.get(i + 2);
                                if (actual.equals(tercero)) {
                                    insert3ValuesRomanNumber(actual , posterior , tercero);
                                    i = i + 2;
                                } else {
                                    insert2ValuesRomanNumber(actual , posterior);
                                    i = i + 1;
                                }
                            } else {
                                insert2ValuesRomanNumber(actual , posterior);
                                i = i + 1;
                            }
                        } else {
                            if (subtractionAnalyzer(actual, posterior)) {
                                insertSubtractionValuesRomanNumber(actual,posterior);
                                i = i + 1;
                            } else {
                                return false;
                            }
                        }
                    }
                } else {
                    insertActualRomanNumber(actual);
                }
            }
        }else{
            return false;
        }
        return true;
    }

    public void insertActualRomanNumber(String actual){
        RomanNumber romanNumber = new RomanNumber();
        romanNumber.setSymbol(actual);
        romanNumber.setValue(rN.getValueRomanNumber(actual));
        ListRomanNumberValues.add(romanNumber);
    }

    public void insertSubtractionValuesRomanNumber(String actual,String posterior){
        RomanNumber romanNumber = new RomanNumber();
        romanNumber.setSymbol(actual+posterior);
        romanNumber.setValue(rN.getValueRomanNumber(posterior) - rN.getValueRomanNumber(actual));
        ListRomanNumberValues.add(romanNumber);
    }

    public void insert2ValuesRomanNumber(String actual,String posterior){
        RomanNumber romanNumber = new RomanNumber();
        romanNumber.setSymbol(actual+posterior);
        romanNumber.setValue(rN.getValueRomanNumber(actual)+rN.getValueRomanNumber(posterior));
        ListRomanNumberValues.add(romanNumber);
    }

    public void insert3ValuesRomanNumber(String actual,String posterior, String tercero){
        RomanNumber romanNumber = new RomanNumber();
        romanNumber.setSymbol(actual+posterior+tercero);
        romanNumber.setValue(rN.getValueRomanNumber(actual)+rN.getValueRomanNumber(posterior)+rN.getValueRomanNumber(tercero));
        ListRomanNumberValues.add(romanNumber);
    }

    public boolean validateMaximumNumberOfRepetitions(String sentence) {
        for (String symbol : rN.getSymbols()) {
            long repeat = repeatedSymbols(sentence, symbol);
            if ((symbol.contains("I")) || (symbol.contains("X")) || (symbol.contains("C"))) {
                if(repeat==3){
                    return ruleRepetition3LowerValue(sentence);
                }
                if(repeat==4){
                    return ruleRepetition4LowerValue(sentence);
                }
                if(repeat>4){
                    return false;
                }
            }
            if(symbol.contains("M") && repeat==4){
                return false;
            }
            if (symbol.contains("V") || (symbol.contains("L")) || (symbol.contains("D")))  {
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
                if(pos1.equals(pos2)){
                    if(pos2.equals(pos3)){
                        if(pos3.equals(pos4)){
                            return false;
                        }
                    }
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
                String pos2 = "" + listRomanNumerals.get(i + 2);
                String pos3 = "" + listRomanNumerals.get(i + 3);
                String pos4 = "" + listRomanNumerals.get(i + 4);
                if(pos1.equals(pos2)){
                    if(pos2.equals(pos3)){
                       if(pos3.equals(pos4)){
                           return false;
                       }
                    }
                }
            }
            if((i+4)< listRomanNumerals.size()){
                String pos3 = ""+listRomanNumerals.get(i+2);
                String pos4 = ""+listRomanNumerals.get(i+3);
                if(rN.getValueRomanNumber(pos3) <rN.getValueRomanNumber(pos4)){
                    return false;
                }
            }
        }
        return true;
    }

    public long repeatedSymbols(String sentence, String symbol) {
           return  sentence.chars()
                    .mapToObj(i -> (char) i)
                    .filter((l) -> l == symbol.charAt(0))
                    .count();
    }
    public boolean orderNumberMayorMinor(String firstSymbol, String secondSymbol){
        return (rN.getValueRomanNumber(firstSymbol) > rN.getValueRomanNumber(secondSymbol));
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
