package com.tactfactory.demo.hangmangame.gameplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class GameBase implements Game {

    protected boolean finish = false;
    protected boolean win = false;
    protected int countError = 0;
    protected int countTry = 0;

    protected final HashMap<Integer, Character> wordSearchMap = new HashMap<>();
    protected final HashMap<Integer, Character> wordfindedMap = new HashMap<>();

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
