/*
 * Application.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame;

/**
 * Main Application.
 */
public final class Application {

    /**
     * End-point to start application.
     * @param args
     */
    public static void main(String[] args) {
        GameEngine app = new GameEngine();
        app.run();
    }

    private Application() { /** */ }

}
