/*
 * Game.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.gameplay;

import java.util.List;

public interface Game {

    List<Character> maskToDisplay();

    void submitChar(Character value);

    int getCountTry();

    int getCountError();

    boolean isFinish();

    boolean isWin();
}
