/*
 * Game.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame.gameplay;

import java.util.List;

/**
 * GamePlay concept.
 */
public interface Game {

    /**
     * Mask of current Word discover.
     * @return the mask.
     */
    List<Character> maskToDisplay();

    /**
     * Process game engine to new proposal.
     * @param value to propose.
     */
    void submitChar(Character value);

    /**
     * Number of try.
     * @return the value.
     */
    int getCountTry();

    /**
     * Number of Error.
     * @return the value.
     */
    int getCountError();

    /**
     * If Game is finish (True if is finished).
     * @return the value.
     */
    boolean isFinish();

    /**
     * If Game is Win.
     * @return the value.
     */
    boolean isWin();

}
