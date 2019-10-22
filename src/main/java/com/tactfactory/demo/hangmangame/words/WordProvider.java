package com.tactfactory.demo.hangmangame.words;

public interface WordProvider {

    void addWord(String word) throws WordException;

    String getRandom();

}
