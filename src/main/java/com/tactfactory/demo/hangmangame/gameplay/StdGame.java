/*
 * StdGame.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.gameplay;

public class StdGame extends GameBase {

    private static final int MAX_ERROR = 10;

    public StdGame(final String word) {
        super(word);
    }

    @Override
    public void submitChar(final Character value) {
        if (!this.finish) {
            boolean checkFinish = true;
            boolean checkFound = false;

            this.countTry++;

            for (int i = 0; i < this.wordSearchMap.size(); i++) {
                final Character letterRef = this.wordSearchMap.get(i);

                if (value.equals(letterRef)) {
                    this.wordfindedMap.put(i, letterRef);
                    checkFound = true;
                }

                if (this.wordfindedMap.get(i) == null) {
                    checkFinish = false;
                }
            }

            this.finish = checkFinish;

            // If Finish without error => Wins !!!
            if (this.finish) {
                this.win = true;
            }

            // If Error (not found value)
            if (!checkFound) {
                this.countError++;

                if (this.countError == MAX_ERROR) {
                    this.finish = true;
                }
            }
        }
    }

}
