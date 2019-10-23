/*
 * WordProviderBase.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.words;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Common Implementation of Word Provider.
 */
public abstract class WordProviderBase implements WordProvider {

    /** Randomizer */
    protected static final Random random = new Random(LocalDateTime.now().getNano());

    /** Size Minimal */
    protected int miniWordSize = 1;

    /** Internal dictionary of words. */
    protected final List<String> words = new ArrayList<>();

    @Override
    public String getRandom() {
        int idx = WordProviderBase.random.nextInt(this.words.size() - 1);
        final String word = this.words.get(idx);

        return word;
    }

    /**
     * Normalize word for Game Engine.
     * @param word to normalize.
     * @return Word normalized.
     */
    protected static String normalize(String word) {
        return word.trim().toLowerCase(Locale.getDefault());
    }

    /**
     * @return the miniWordSize.
     */
    @Override
    public int getMiniWordSize() {
        return this.miniWordSize;
    }

    /**
     * @param miniWordSize the miniWordSize to set.
     * @return this.
     */
    @Override
    public WordProvider setMiniWordSize(int miniWordSize) {
        this.miniWordSize = miniWordSize;
        return this;
    }



}
