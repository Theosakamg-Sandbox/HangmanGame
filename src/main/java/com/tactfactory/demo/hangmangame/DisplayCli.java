/*
 * DisplayCli.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame;

import java.util.List;

import com.tactfactory.demo.hangmangame.gameplay.Game;

/**
 * Graphical Engine for Console.
 */
public class DisplayCli {

    /*
    " ╔═════╤═\n";
    " ║     │\n";
    " ║     O\n";
    " ║    /│\\\n";
    " ║     ║\n";
    " ║\n";
    "═╩═══════";
    */

    public static final String ERR10 = " ╔═════╤═\n ║     │\n ║     O\n ║    /│\\\n ║     ║\n ║\n═╩═══════";
    public static final String ERR9 = " ╔═════╤═\n ║     │\n ║     O\n ║    /│\\\n ║     |\n ║\n═╩═══════";
    public static final String ERR8 = " ╔═════╤═\n ║     │\n ║     O\n ║    /│\\\n ║\n ║\n═╩═══════";
    public static final String ERR7 = " ╔═════╤═\n ║     │\n ║     O\n ║    /│\n ║\n ║\n═╩═══════";
    public static final String ERR6 = " ╔═════╤═\n ║     │\n ║     O\n ║     │\n ║\n ║\n═╩═══════";
    public static final String ERR5 = " ╔═════╤═\n ║     │\n ║     O\n ║\n ║\n ║\n═╩═══════";
    public static final String ERR4 = " ╔═════╤═\n ║     │\n ║\n ║\n ║\n ║\n═╩═══════";
    public static final String ERR3 = " ╔═════╤═\n ║\n ║\n ║\n ║\n ║\n═╩═══════";
    public static final String ERR2 = "\n ║\n ║\n ║\n ║\n ║\n═╩═══════";
    public static final String ERR1 = "\n\n\n\n\n\n═╩═══════";
    public static final String ERR0 = "\n\n\n\n\n\n";

    public static final String SPACE = " ";
    public static final Character CASE = '_';

    /**
     * Display on console the ...
     * @param value
     */
    public void displayMask(final List<Character> value) {
        final StringBuilder builder = new StringBuilder(value.size());

        for (int i = 0; i < value.size(); i++) {
            Character letter = value.get(i);

            if (letter == null) {
                letter = CASE;
            }

            if (builder.length() > 0) {
                builder.append(SPACE);
            }

            builder.append(letter);
        }

        System.out.println(builder.toString());
    }

    /**
     * Display Hang-man state, depend of count error.
     * @param countError of game.
     */
    public void displayHangman(int countError) {

        switch (countError) {

        case 10:
            System.out.println(ERR10);
            break;
        case 9:
            System.out.println(ERR9);
            break;
        case 8:
            System.out.println(ERR8);
            break;
        case 7:
            System.out.println(ERR7);
            break;
        case 6:
            System.out.println(ERR6);
            break;
        case 5:
            System.out.println(ERR5);
            break;
        case 4:
            System.out.println(ERR4);
            break;
        case 3:
            System.out.println(ERR3);
            break;
        case 2:
            System.out.println(ERR2);
            break;
        case 1:
            System.out.println(ERR1);
            break;
        case 0:
            System.out.println(ERR0);
            break;
        default:
            System.out.println();
            break;
        }
    }

    /**
     * Display global step. Mask + Hang-Man.
     * @param game instance.
     */
    public void step(Game game) {
        System.out.println("");

        if (game.getCountTry() > 0) {
            // TODO (mickael) : Remove after Debug
            System.out.println(
                    String.format("Try %d, with %d errors, finished : %b",
                            game.getCountTry(),
                            game.getCountError(),
                            game.isFinish()));

            this.displayHangman(game.getCountError());
        }

        this.displayMask(game.maskToDisplay());
    }

    /**
     * Display to request a value.
     */
    public void requestValue() {
        System.out.println("Enter a charactere : ");
    }

    /**
     * Display result of Game.
     * @param game instance.
     */
    public void resultMessage(final Game game) {
        System.out.println();
        if (game.isWin()) {
            System.out.println("GOOD GAME !!!");
        } else {
            System.out.println("You lose !");
        }
    }

}
