package com.fisa.model;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    public Map<String, Word> wordsMap = new HashMap<String, Word>();
    public Map<String, Product> productsMap = new HashMap<String, Product>();
    public Map<String, Token> tokensMap = new HashMap<String, Token>();

    static final String QUERY_CONSTANT = "query"; 
    
    public Dictionary() {
        loadInitialTokens();
    }

    public boolean insertWord(String name , String value){
        wordsMap.put(name,new Word(name,value));
        tokensMap.put(name,new Token(name,"word"));
        return true;
    }
    public boolean insertProduct(String name , double value){
        productsMap.put(name,new Product(name,value));
        tokensMap.put(name,new Token(name,"product"));
        return true;
    }

    public boolean loadInitialTokens(){
        tokensMap.put("",new Token("",""));
        tokensMap.put("IS",new Token("IS","assignment"));
        tokensMap.put("HOW",new Token("HOW",QUERY_CONSTANT));
        tokensMap.put("MANY",new Token("MANY",QUERY_CONSTANT));
        tokensMap.put("MUCH",new Token("MUCH",QUERY_CONSTANT));
        tokensMap.put("?",new Token("?",QUERY_CONSTANT));
        tokensMap.put("CREDITS",new Token("CREDITS","currency"));
        return true;
    }

}
