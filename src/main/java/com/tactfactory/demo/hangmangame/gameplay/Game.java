/*
 * Game.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.gameplay;

import java.util.List;

public interface Game {

    /** @return Mask of current Word discover. */
    List<Character> maskToDisplay();

    /**
     * Process game engine to new proposal.
     * @param value to propose.
     */
    void submitChar(Character value);

    /** @return Number of try. */
    int getCountTry();

    /** @return Number of Error. */
    int getCountError();

    /** @Return if Game is finish. (True if is finiched)*/
    boolean isFinish();

    /** @Return if Game is Win. */
    boolean isWin();

}
