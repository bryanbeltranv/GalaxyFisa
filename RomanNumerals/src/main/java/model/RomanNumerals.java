package model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class RomanNumerals {

    private int finalValue = 0;

    private Map<String, RomanNumber> romanNumeralsMap = new HashMap<>();

    private String [] symbols = {"I","V","X","L","C","D","M"};

    public RomanNumerals() {
        loadRomanNumerals();
    }

    private void loadRomanNumerals(){
        romanNumeralsMap.put("I",new RomanNumber("I",1));
        romanNumeralsMap.put("V",new RomanNumber("V",5));
        romanNumeralsMap.put("X",new RomanNumber("X",10));
        romanNumeralsMap.put("L",new RomanNumber("L",50));
        romanNumeralsMap.put("C",new RomanNumber("C",100));
        romanNumeralsMap.put("D",new RomanNumber("D",500));
        romanNumeralsMap.put("M",new RomanNumber("M",1000));

    }

    public int getValueRomanNumber(String symbol){
        return romanNumeralsMap.get(symbol).getValue();
    }
}
