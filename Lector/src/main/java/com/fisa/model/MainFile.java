package com.fisa.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
public class MainFile {
    public ArrayList <LineCode> lineCodeMap = new ArrayList<LineCode>();

    public boolean insertLine(int line , String code){
        lineCodeMap.add(new LineCode(line,code,false));
        return true;
    }

}
