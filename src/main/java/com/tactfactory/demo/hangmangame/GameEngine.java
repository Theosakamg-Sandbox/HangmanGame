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
import com.tactfactory.demo.hangmangame.words.InternalWordProvider;
import com.tactfactory.demo.hangmangame.words.WordException;
import com.tactfactory.demo.hangmangame.words.WordProvider;

public class GameEngine {

    private final WordProvider words = new InternalWordProvider();
    private final DisplayCli display = new DisplayCli();

    public void run() {
        try {
            this.words.addWord("Bonjour");
            this.words.addWord("Pendu");
            this.words.addWord("Enfant");

        } catch (WordException e) {
            e.printStackTrace();
        }

        final Game game = this.makeNewGame();

        try (Scanner scan = new Scanner(System.in)) {
            while (!game.isFinish()) {
                this.display.step(game);
                this.display.requestValue();

                final Character letter = scan.nextLine().charAt(0);
                game.submitChar(letter);
            }

            this.display.step(game);
            this.display.resultMessage(game);
        }
    }

    private Game makeNewGame() {
        final String word = this.words.getRandom();
        final Game game = new StdGame(word);

        return game;
    }
}
