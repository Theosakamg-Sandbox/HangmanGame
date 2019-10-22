/*
 * Application.java, HangMan Game
 *
 * Copyright © 2019 Mickael Gaillard / TACTfactory
 * License    : all rights reserved
 */

package com.tactfactory.demo.hangmangame;

public final class Application {

    public static void main(String[] args) {
        GameEngine app = new GameEngine();
        app.run();
    }

    private Application() { /** */ }

}
