/*
 * GameEngine.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame;

import java.util.Scanner;

import com.tactfactory.demo.hangmangame.gameplay.Game;
import com.tactfactory.demo.hangmangame.gameplay.StdGame;
import com.tactfactory.demo.hangmangame.words.WordProvider;
import com.tactfactory.demo.hangmangame.words.WordProviderFactory;
import com.tactfactory.demo.hangmangame.words.WordProviderType;

/**
 * Main game engine.
 */
public class GameEngine {

    /** Display Engine. */
    private final DisplayCli display = new DisplayCli();
    /** Word provider. */
    private WordProvider words;
    /** GamePlay engine. */
    private Game game;

    /** Main game is running. */
    private boolean finish;

    /** Main Thread of game (Main loop). */
    public void run() {

        try (Scanner scan = new Scanner(System.in)) {
//             while (!this.finish) {

//                this.menuDisplay();

                this.words = WordProviderFactory.make(WordProviderType.Internal);
                this.game = this.makeNewGame();

                while (!this.game.isFinish()) {
                    this.mainDisplay();

                    final Character letter = scan.nextLine().charAt(0);
                    this.game.submitChar(letter);
                }

                this.finalDisplay();
//            }
        }
    }

    /**
     * Create Instance of game play and generate word to use.
     * @return Instance of GamePlay
     */
    private Game makeNewGame() {
        final String word = this.words.getRandom();
        final Game game = new StdGame(word);

        return game;
    }

    /**
     * Display Menu screen.
     * @param scanner input.
     */
    private void menuDisplay(Scanner scanner) {
        boolean validate = false;

        while (!this.finish && !validate) {
            this.display.menuRequest();
            scanner.nextLine();
        }

    }

    /** Main game loop to display. */
    private void mainDisplay() {
        this.display.step(this.game);
        this.display.requestValue();
    }

    /** Win game to display. */
    private void finalDisplay() {
        this.display.step(this.game);
        this.display.resultMessage(this.game);
    }
}
