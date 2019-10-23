/*
 * WordProvider.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.words;

/**
 * Provide Word for Game Engine.
 */
public interface WordProvider {

    /**
     * Add word to dictionary.
     * @param word to add.
     * @throws WordException if word if not normalize.
     */
    void addWord(String word) throws WordException;


    /**
     * get a random word.
     * @return the word.
     */
    String getRandom();

    WordProvider setMiniWordSize(int miniWordSize);

    int getMiniWordSize();

}
