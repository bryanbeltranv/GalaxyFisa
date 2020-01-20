package com.fisa.model;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    public Map<String, Word> WordsMap = new HashMap<String, Word>();
    public Map<String, Product> ProductsMap = new HashMap<String, Product>();
    public Map<String, Token> TokensMap = new HashMap<String, Token>();

    public Dictionary() {
        loadInitialTokens();
        //insertWord("GLOP","X");
        //insertWord("SPOK","I");

    }

    public boolean insertWord(String name , String value){
        WordsMap.put(name,new Word(name,value));
        TokensMap.put(name,new Token(name,"word"));
        return true;
    }
    public boolean insertProduct(String name , double value){
        ProductsMap.put(name,new Product(name,value));
        TokensMap.put(name,new Token(name,"product"));
        return true;
    }

    public boolean loadInitialTokens(){
        TokensMap.put("",new Token("",""));
        TokensMap.put("IS",new Token("IS","assignment"));
        TokensMap.put("HOW",new Token("HOW","query"));
        TokensMap.put("MANY",new Token("MANY","query"));
        TokensMap.put("MUCH",new Token("MUCH","query"));
        TokensMap.put("?",new Token("?","query"));
        TokensMap.put("CREDITS",new Token("CREDITS","currency"));
        //insertProduct("SILVER",2);
        return true;
    }

}
