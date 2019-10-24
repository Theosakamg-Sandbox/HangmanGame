/*
 * InternalWordProvider.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.words;

/**
 * Internal dictionary of Words.
 */
public class InternalWordProvider extends WordProviderBase {

    /**
     * Constructor.
     */
    public InternalWordProvider() {
        super();

        try {
            this.addWord("Bonjour");
            this.addWord("Pendu");
            this.addWord("Enfant");

        } catch (WordException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addWord(String word) throws WordException {
        if (word.length() > this.miniWordSize) {
            this.words.add(normalize(word));
        } else {
            throw new WordException("To short word");
        }
    }

}
