package com.fisa.model;

import lombok.Getter;
import java.util.ArrayList;

@Getter
public class MainFile {
    public ArrayList <LineCode> lineCodeList = new ArrayList<LineCode>();

    public boolean insertLine(int line , String code){
        lineCodeList.add(new LineCode(line,code,false));
        return true;
    }

}
