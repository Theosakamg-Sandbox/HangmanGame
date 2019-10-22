/*
 * WordProvider.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.words;

public interface WordProvider {

    void addWord(String word) throws WordException;

    String getRandom();

    WordProvider setMiniWordSize(int miniWordSize);

    int getMiniWordSize();

}
