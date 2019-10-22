/*
 * InternalWordProvider.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.words;

public class InternalWordProvider extends WordProviderBase {

    @Override
    public void addWord(String word) throws WordException {
        if (word.length() > this.miniWordSize) {
            this.words.add(normalize(word));
        } else {
            throw new WordException("To short word");
        }
    }

}
