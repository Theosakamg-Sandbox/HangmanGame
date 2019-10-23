/*
 * WordException.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.words;

/**
 * Exception of Word provider.
 */
public class WordException extends Exception {

    private static final long serialVersionUID = 1L;

    public WordException(String string) {
        super(string);
    }

}
