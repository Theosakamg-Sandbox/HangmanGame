/*
 * GameBase.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.gameplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GameBase implements Game {

    /** State of Game */
    protected boolean finish;

    /** Winning the game. */
    protected boolean win;

    /** Number of Errors. */
    protected int countError;

    /** Number of try. */
    protected int countTry;

    /** Search word attribute. */
    protected final Map<Integer, Character> wordSearchMap = new HashMap<>();

    /** Finded on word attribute. */
    protected final Map<Integer, Character> wordfindedMap = new HashMap<>();

    public GameBase(final String word) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            this.wordSearchMap.put(i, letter);
        }

        for (int i = 0; i < word.length(); i++) {
            this.wordfindedMap.put(i, null);
        }
    }

    @Override
    public List<Character> maskToDisplay() {
        return new ArrayList<>(this.wordfindedMap.values());
    }

    @Override
    public int getCountTry() {
        return  this.countTry;
    }

    @Override
    public int getCountError() {
        return  this.countError;
    }

    @Override
    public boolean isFinish() {
        return this.finish;
    }

    @Override
    public boolean isWin() {
        return this.win;
    }
}
