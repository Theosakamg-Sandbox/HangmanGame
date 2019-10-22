/*
 * GameMock.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.gameplay;

public class GameMock extends GameBase {

    public GameMock() {
        this("mock");
    }

    public GameMock(String word) {
        super(word);
    }

    @Override
    public void submitChar(Character value) {

    }

    public void setFiniched(boolean isFinish) {
        this.finish = isFinish;
    }

    public void setWinner(boolean isWin) {
        this.win = isWin;
    }

    public void setCountTry(int countTry) {
        this.countTry = countTry;

    }

}
