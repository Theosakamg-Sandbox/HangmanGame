/*
 * WordProviderFactory.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.words;

/**
 * Factory to make instance of Provider.
 */
public final class WordProviderFactory {

    /** Internal Constructor. */
    private WordProviderFactory() { /** */ }

    /**
     * Make the Instance.
     * @param type of Provider.
     * @return Instance
     */
    public static WordProvider make(final WordProviderType type) {
        WordProvider result = null;

        switch (type) {
        case Internal:
            result = new InternalWordProvider();
            break;
        case File:
            result = new FileWordProvider();
            break;
        default:
            break;
        }

        return result;
    }

}
