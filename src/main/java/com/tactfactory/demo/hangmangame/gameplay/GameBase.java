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

    protected boolean finish;
    protected boolean win;
    protected int countError;
    protected int countTry;

    protected final Map<Integer, Character> wordSearchMap = new HashMap<>();
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
